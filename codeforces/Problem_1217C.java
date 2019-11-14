import java.util.*;
import java.io.*;

public class Problem_1217C {
    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(System.in);
        PrintWriter output = new PrintWriter(System.out);

        int t = input.nextInt();
        for (int q = 0; q < t; q++) {
            String s = input.next();
            int count = 0;
            int[] l = new int[s.length()];

            if (s.charAt(0) == '0')
                l[0] = -1;

            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == '0')
                    l[i] = l[i - 1];
                else
                    l[i] = i;
            }

            for (int i = 0; i < s.length(); i++) {
                int value = 0;
                for (int j = i; j >= 0 && i - j <= 20; j--) {
                    if (s.charAt(j) == '1')
                        value |= 1 << (i - j);
                    if (value == i - j + 1)
                        count++;
                }

                if (i > 20 && 21 < value && value <= i - l[i - 21])
                    count++;
            }
            output.println(count);
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