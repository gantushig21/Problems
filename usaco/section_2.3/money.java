
/*
ID: gantush6
LANG: JAVA
TASK: money
*/

import java.io.*;
import java.util.*;

public class money {
    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("money.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("money.out")));

        int V = input.nextInt(), N = input.nextInt();
        int[] coins = new int[V];
        for (int i = 0; i < V; i++)
            coins[i] = input.nextInt();

        long[] A = new long[N + 1];
        A[0] = 1;
        for (int i = 0; i < V; i++) {
            for (int j = coins[i]; j <= N; j++)
                A[j] = A[j] + A[j - coins[i]];
        }

        output.println(A[N]);
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