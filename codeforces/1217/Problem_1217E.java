import java.util.*;
import java.io.*;

public class Problem_1217E {
    static List<Edge>[] map;
    static boolean[] used;
    static boolean[] visited;
    static int[] color;
    static int numOfColors = 1;

    static PrintWriter output = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(System.in);
        // PrintWriter output = new PrintWriter(System.out);

        int n = input.nextInt(), m = input.nextInt();
        map = new List[n];
        color = new int[m];
        used = new boolean[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
            used[i] = false;
            visited[i] = false;
        }
        for (int i = 0; i < m; i++) {
            int u = input.nextInt(), v = input.nextInt();
            map[u - 1].add(new Edge(v - 1, i));
            color[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            if (!used[i])
                DFS(i);
        }

        output.println(numOfColors);
        for (int i = 0; i < m - 1; i++)
            output.print(color[i] + " ");
        output.println(color[m - 1]);

        output.close();
    }

    static void DFS(int node) {
        used[node] = true;
        visited[node] = true;
        for (Edge edge : map[node]) {
            if (used[edge.u]) {
                if (visited[edge.u]) {
                    color[edge.index] = 2;
                    numOfColors = 2;
                }
            } else
                DFS(edge.u);
        }
        visited[node] = false;
    }

    static class Edge {
        public int u, index;

        public Edge(int u, int index) {
            this.u = u;
            this.index = index;
        }
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
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
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