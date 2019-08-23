import java.util.*;
import java.io.*;

// TLE

public class Problem_1207F {
    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(System.in);
        PrintWriter output = new PrintWriter(System.out);

        int limit = 710;
        int[] a = new int[500001];
        int[][] matrix = new int[limit + 1][limit];

        int q = input.nextInt();
        for (int k = 0; k < q; k++) {
            int t = input.nextInt(), x = input.nextInt(), y = input.nextInt();
            if (t == 1) {
                a[x] += y;
                for (int i = 1; i <= limit; i++)
                    matrix[i][x % i] += y;
            } else {
                if (x <= limit)
                    output.println(matrix[x][y]);
                else {
                    int sum = 0;
                    for (int i = y; i <= 500000; i += x)
                        sum += a[i];
                    output.println(sum);
                }
            }
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