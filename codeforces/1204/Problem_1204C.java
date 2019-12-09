import java.util.*;
import java.io.*;

// TLE

public class Problem_1204C {
    final static int MAX_VALUE = 1000000;

    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(System.in);
        PrintWriter output = new PrintWriter(System.out);

        int n = input.nextInt();
        int[][] dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            String row = input.next();

            for (int j = 1; j <= n; j++)
                dist[i][j] = row.charAt(j - 1) == '1' ? 1 : MAX_VALUE;

            dist[i][i] = 0;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++)
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
            }
        }

        int m = input.nextInt();
        int[] p = new int[m + 1];
        for (int i = 1; i <= m; i++)
            p[i] = input.nextInt();

        List<Integer> path = new ArrayList<>();
        path.add(1);
        for (int i = 2; i <= m; i++) {
            int lastIndex = path.get(path.size() - 1);
            if (dist[p[lastIndex]][p[i]] != i - lastIndex)
                path.add(i - 1);
        }
        path.add(m);

        output.println(path.size());
        for (int i = 0; i < path.size() - 1; i++)
            output.print(p[path.get(i)] + " ");
        output.println(p[path.get(path.size() - 1)]);

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