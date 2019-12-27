
/*
ID: gantush6
LANG: JAVA
TASK: agrinet
*/

import java.io.*;
import java.util.*;
import java.lang.*;

public class agrinet {
    static int[] parent;
    static int[] rank;

    static class Edge implements Comparable<Edge> {
        public int u, v, d;

        public Edge(int u, int v, int d) {
            this.u = u;
            this.v = v;
            this.d = d;
        }

        @Override
        public int compareTo(Edge o) {
            if (d > o.d)
                return 1;
            if (d < o.d)
                return -1;

            return 0;
        }

        @Override
        public String toString() {
            return "(" + u + ", " + v + ", " + d + ")";
        }
    }

    static int getRoot(int x) {
        if (parent[x] == x)
            return x;

        return getRoot(parent[x]);
    }

    static boolean union(int u, int v) {
        int rootU = getRoot(u);
        int rootV = getRoot(v);

        if (rootU == rootV)
            return false;

        if (rank[rootU] > rank[rootV]) {
            parent[rootV] = rootU;
        } else if (rank[rootU] < rank[rootV]) {
            parent[rootU] = rootV;
        } else {
            parent[rootU] = rootV;
            rank[rootV]++;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("agrinet.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("agrinet.out")));

        int n = input.nextInt();
        parent = new int[n];
        rank = new int[n];
        int[][] distances = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                distances[i][j] = input.nextInt();

            parent[i] = i;
            rank[i] = 1;
        }
        int size = n * (n - 1) / 2;
        List<Edge> list = new ArrayList<>(size);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++)
                list.add(new Edge(i, j, distances[i][j]));
        }

        Collections.sort(list);
        int count = 0;
        int cost = 0;
        for (Edge edge : list) {
            if (union(edge.u, edge.v)) {
                count++;
                cost += edge.d;

                if (count == n)
                    break;
            }
        }

        output.println(cost);
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