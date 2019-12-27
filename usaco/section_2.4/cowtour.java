
/*
ID: gantush6
LANG: JAVA
TASK: cowtour
*/

import java.io.*;
import java.util.*;
import java.lang.*;

public class cowtour {
    static int count = 0;
    static int[] fields;
    static double[] farthest;
    static double[] farthestInField;

    static class Pair {
        public int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Node {
        public int value;
        public double distance;

        public Node(int value, double distance) {
            this.value = value;
            this.distance = distance;
        }
    }

    static double getDistance(Pair p1, Pair p2) {
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    }

    static void floyd(double[][] matrix) {
        for (int k = 0; k < matrix.length; k++) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }
    }

    static void dfs(int current, List<List<Node>> map) {
        if (fields[current] != 0)
            return;
        fields[current] = count;
        List<Node> nodes = map.get(current);
        for (Node node : nodes)
            dfs(node.value, map);
    }

    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("cowtour.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("cowtour.out")));
        PrintWriter testOutput = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));

        int n = input.nextInt();
        fields = new int[n];
        Pair[] coordinates = new Pair[n];
        for (int i = 0; i < n; i++)
            coordinates[i] = new Pair(input.nextInt(), input.nextInt());

        List<List<Node>> map = new ArrayList<>();
        double[][] matrix = new double[n][n];
        for (int i = 0; i < n; i++) {
            String line = input.next();
            List<Node> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    matrix[i][i] = 0.0;
                } else if (line.charAt(j) == '1') {
                    double distance = getDistance(coordinates[i], coordinates[j]);
                    list.add(new Node(j, distance));
                    matrix[i][j] = distance;
                } else {
                    matrix[i][j] = Double.MAX_VALUE;
                }
            }
            map.add(list);
        }

        floyd(matrix);
        for (int i = 0; i < n; i++) {
            if (fields[i] == 0) {
                count++;
                dfs(i, map);
            }
        }

        farthest = new double[n];
        farthestInField = new double[n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (farthest[i] < matrix[i][j] && matrix[i][j] != Double.MAX_VALUE) {
                    farthest[i] = matrix[i][j];
                }
            }
            if (farthest[i] > farthestInField[fields[i]])
                farthestInField[fields[i]] = farthest[i];
        }

        double diameter = Double.MAX_VALUE;

        int ii = 0, jj = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (fields[i] == fields[j])
                    continue;

                double d = farthest[i] + getDistance(coordinates[i], coordinates[j]) + farthest[j];
                if (d < farthestInField[fields[i]])
                    d = farthestInField[fields[i]];
                if (d < farthestInField[fields[j]])
                    d = farthestInField[fields[j]];

                if (d < diameter) {
                    ii = i;
                    jj = j;
                    diameter = d;
                }
            }
        }

        // print(map, matrix, testOutput);
        output.printf("%.6f\n", diameter);
        output.close();
        testOutput.close();
    }

    static void print(List<List<Node>> map, double[][] matrix, PrintWriter testOutput) {
        for (int i = 0; i < map.size(); i++) {
            List<Node> list = map.get(i);
            for (int j = 0; j < list.size(); j++) {
                Node node = list.get(j);
                testOutput.println(i + " " + node.value + " => " + node.distance);
            }
        }

        testOutput.println("Length is: " + matrix.length);
        for (int i = 0; i < matrix.length; i++)
            testOutput.println(i + " " + Arrays.toString(matrix[i]));

        testOutput.println("Fields: ");
        for (int i = 0; i < fields.length; i++)
            testOutput.println(i + " " + fields[i] + " ");
        testOutput.println();

        testOutput.println("Farthest: ");
        for (int i = 0; i < farthest.length; i++)
            testOutput.println(i + " " + farthest[i] + " ");
        testOutput.println();

        testOutput.println("Farthest In Fields: ");
        for (int i = 0; i < farthestInField.length; i++)
            testOutput.print(farthestInField[i] + " ");
        testOutput.println();
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        FastScanner(FileReader s) {
            br = new BufferedReader(s);
        }

        String next() throws IOException {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(br.readLine());
                return st.nextToken();
            } catch (NullPointerException ex) {
                return null;
            }
        }

        String nextLine() throws IOException {
            return br.readLine();
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }
}