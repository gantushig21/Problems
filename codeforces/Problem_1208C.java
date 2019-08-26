import java.util.*;
import java.io.*;

public class Problem_1208C {
    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(System.in);
        PrintWriter output = new PrintWriter(System.out);

        int n = input.nextInt();
        int value = 0;
        int[][] a = new int[n][n];

        for (int i = 0; i < n; i += 4) {
            for (int j = 0; j < n; j += 4) {
                for (int x = 0; x < 4; x++) {
                    for (int y = 0; y < 4; y++)
                        a[i + x][j + y] = value++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++)
                output.print(a[i][j] + " ");
            output.println(a[i][n - 1]);
        }

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