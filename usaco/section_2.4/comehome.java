
/*
ID: gantush6
LANG: JAVA
TASK: comehome
*/

import java.io.*;
import java.util.*;
import java.lang.*;

public class comehome {
    static class Node implements Comparable<Node> {
        public int value, distance;

        public Node(int value, int distance) {
            this.value = value;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            if (distance > o.distance)
                return 1;
            if (distance < o.distance)
                return -1;

            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("comehome.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("comehome.out")));

        int n = 52;
        int m = input.nextInt();
        int[][] map = new int[n][n];
        for (int i = 0; i < m; i++) {
            char ch = input.next().charAt(0);
            int u = ch - 71;
            if ('A' <= ch && ch <= 'Z')
                u = ch - 65;

            ch = input.next().charAt(0);
            int v = ch - 71;
            if ('A' <= ch && ch <= 'Z')
                v = ch - 65;

            int d = input.nextInt();
            if (map[u][v] == 0 || d < map[u][v]) {
                map[u][v] = d;
                map[v][u] = d;
            }
        }

        List<List<Node>> mp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Node> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (i != j && map[i][j] > 0)
                    list.add(new Node(j, map[i][j]));
            }
            mp.add(list);
        }

        int[] distances = new int[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            distances[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        int start = 25;
        distances[start] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));

        int count = 0;
        while (count < n && !queue.isEmpty()) {
            Node u = queue.poll();
            if (!visited[u.value]) {
                visited[u.value] = true;
                count++;

                List<Node> list = mp.get(u.value);
                for (Node v : list) {
                    if (!visited[v.value]) {
                        if (distances[v.value] > distances[u.value] + v.distance)
                            distances[v.value] = distances[u.value] + v.distance;
                        queue.add(new Node(v.value, distances[v.value]));
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        char pasture = 'A';
        for (int i = 0; i < n / 2 - 1; i++) {
            if (distances[i] < min) {
                min = distances[i];
                pasture = (char) (i + 65);
            }
        }

        output.println(pasture + " " + min);
        output.close();
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