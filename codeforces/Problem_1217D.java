import java.util.*;
import java.io.*;
 
public class Problem_1217D {
    static List<Edge>[] map;
    static boolean[] used;
    static int[] color;
    static boolean hasCycle = false;
 
    static PrintWriter output;
 
    public static void main(String[] args) throws IOException {
        // FastScanner input = new FastScanner(System.in);
        Scanner input = new Scanner(new File("input.txt"));
        output = new PrintWriter(System.out);
 
        int n = input.nextInt(), m = input.nextInt();
        map = new List[n];
        color = new int[m];
        used = new boolean[n];
 
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
            used[i] = false;
        }
        for (int i = 0; i < m; i++) {
            int u = input.nextInt(), v = input.nextInt();
            map[u - 1].add(new Edge(v - 1, i));
        }
 
        for (int i = 0; i < n; i++) {
            if (map[i].size() > 0 && color[map[i].get(0).index] == 0) {
                output.print("x");
                DFS(i, 1);
            }
        }
 
        if (hasCycle) {
            output.println("2");
            for (int i = 0; i < m - 1; i++) {
                if (color[i] == -1)
                    color[i] = 2;
                output.print(color[i] + " ");
            }
            if (color[m - 1] == -1)
                color[m - 1] = 2;
            output.println(color[m - 1]);
        } else {
            output.println("1");
            for (int i = 1; i < m; i++)
                output.print("1 ");
            output.println("1");
        }
 
        output.close();
    }
 
    static void DFS(int node, int edgeColor) {
        used[node] = true;
        for (Edge edge : map[node]) {
            color[edge.index] = edgeColor;
            if (used[edge.u]) 
                hasCycle = true;
            else 
                DFS(edge.u, edgeColor * -1);
        }
        used[node] = false;
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
