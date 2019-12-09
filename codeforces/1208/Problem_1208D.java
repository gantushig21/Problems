import java.util.*;
import java.io.*;

public class Problem_1208D {
    static long[] sum;
    static int n = 0;

    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(System.in);
        PrintWriter output = new PrintWriter(System.out);

        n = input.nextInt();

        sum = new long[n + 1];
        Arrays.fill(sum, 0);
        long[] a = new long[n];

        for (int i = 0; i < n; i++) {
            a[i] = input.nextLong();
            addToSum(i + 1, i + 1);
        }

        for (int i = n - 1; i >= 0; i--) {
            int low = 0, high = n;
            while (high - low > 1) {
                int middle = (low + high) / 2;
                long response = getSum(middle);
                if (response <= a[i])
                    low = middle;
                else
                    high = middle;
            }
            a[i] = high;
            addToSum(high, -high);
        }

        for (int i = 0; i < n; i++) {
            output.print(a[i]);
            if (i < n - 1)
                output.print(" ");
        }
        output.println();

        output.close();
    }

    static long getSum(int middle) {
        long response = 0;
        for (; middle >= 0; middle = (middle & (middle + 1)) - 1)
            response += sum[middle];

        return response;
    }

    static void addToSum(int index, long amount) {
        for (; index <= n; index |= (index + 1))
            sum[index] += amount;
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