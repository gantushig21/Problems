
/*
ID: gantush6
LANG: JAVA
TASK: nocows
*/

import java.io.*;
import java.util.*;

public class nocows {
    static final int MOD = 9901;
    static int n, k;
    static int[][] A;

    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("nocows.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("nocows.out")));

        n = input.nextInt();
        k = input.nextInt();

        A = new int[k + 1][n + 1];
        A[0][0] = 1;
        for (int i = 1; i <= k; i++) {
            A[i][0] = 1;
            for (int j = 1; j <= n; j += 2) {
                // System.out.print(i + " " + j + " =>");
                for (int q = 0; q < j; q++) {
                    // System.out.print(" [" + (i - 1) + ", " + q + "]*[" + (i - 1) + ", " + (j - q
                    // - 1) + "]");
                    A[i][j] = (A[i][j] + (A[i - 1][q] * A[i - 1][j - q - 1]) % MOD) % MOD;
                }
                // System.out.println();
            }
            // System.out.println(Arrays.toString(A[i]));
        }

        output.println((A[k][n] - A[k - 1][n] + MOD) % MOD);

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