import java.io.*;
import java.util.*;

public class B {
    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(System.in);
        PrintWriter output = new PrintWriter(System.out);

        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();

            int[] a = new int[4 * n];
            for (int i = 0; i < 4 * n; i++)
                a[i] = input.nextInt();

            Arrays.sort(a);

            boolean possible = true;
            for (int i = 0; i < 4 * n; i += 2) {
                if (a[i] != a[i + 1]) {
                    possible = false;
                    break;
                }
            }

            int area = a[0] * a[4 * n - 1];
            for (int i = 0; i < n; i++) {
                if (a[2 * i] * a[4 * n - 2 * i - 1] != area) {
                    possible = false;
                    break;
                }
            }
            if (possible)
                System.out.println("YES");
            else
                System.out.println("NO");
        }

        output.close();
    }

    static class Pair implements Comparable<Pair> {
        public int value, count;

        public Pair(int value, int count) {
            this.value = value;
            this.count = count;
        }

        public int compareTo(Pair p) {
            if (value > p.value)
                return 1;
            return -1;
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