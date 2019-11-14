import java.io.*;
import java.util.*;

public class C {
    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(System.in);
        PrintWriter output = new PrintWriter(System.out);

        int n = input.nextInt();
        long gcd = 0;
        for (int i = 0; i < n; i++)
            gcd = gcd(gcd, input.nextLong());

        long k = (long) Math.sqrt(gcd);
        long ans = 1;
        for (int i = 2; i <= k; i++) {
            long count = 0;
            while (gcd % i == 0) {
                gcd /= i;
                count++;
            }
            ans *= (count + 1);
        }
        if (gcd != 1)
            ans *= 2;

        System.out.println(ans);

        output.close();
    }

    static long gcd(long a, long b) {
        if (a == 0 || b == 0)
            return a + b;

        if (a > b)
            return gcd(a % b, b);
        return gcd(a, b % a);
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