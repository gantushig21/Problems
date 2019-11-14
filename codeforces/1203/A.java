import java.io.*;
import java.util.*;

public class A {
    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(System.in);
        PrintWriter output = new PrintWriter(System.out);

        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();
            int[] p = new int[n];
            for (int i = 0; i < n; i++)
                p[i] = input.nextInt() - 1;

            boolean upStatus = true, downStatus = true;
            for (int i = 0; i < n - 1; i++) {
                upStatus &= (p[i] + 1) % n == p[i + 1];
                downStatus &= (p[i + 1] + 1) % n == p[i];
            }

            if (upStatus || downStatus)
                System.out.println("YES");
            else
                System.out.println("NO");
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