import java.util.*;
import java.io.*;

public class E {
    final static long M = 998244353;

    static long power(long x, long y) {
        long z = 1;
        while (y != 0) {
            if (y % 2 == 1)
                z = (z * x) % M;
            x = (x * x) % M;
            y = y / 2;
        }

        return z;
    }

    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(System.in);
        PrintWriter output = new PrintWriter(System.out);

        int n = input.nextInt();

        long[] up = new long[n];
        up[n - 1] = 100;
        for (int i = n - 2; i >= 0; i--)
            up[i] = (up[i + 1] * 100) % M;

        long p = up[0];
        long q = input.nextLong();
        for (int i = 1; i < n; i++) {
            p = (p + (q * up[i]) % M) % M;
            q = (q * input.nextLong()) % M;
        }

        output.println((p * power(q, M - 2)) % M);
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