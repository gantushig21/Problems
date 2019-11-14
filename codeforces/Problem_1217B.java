import java.util.*;
import java.io.*;

public class Problem_1217B {
    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(System.in);
        PrintWriter output = new PrintWriter(System.out);

        int t = input.nextInt();
        for (int q = 0; q < t; q++) {
            int n = input.nextInt(), x = input.nextInt();

            int maxD = 0, maxDiff = 0;
            for (int i = 0; i < n; i++) {
                int d = input.nextInt(), h = input.nextInt();
                maxD = Math.max(maxD, d);
                maxDiff = Math.max(maxDiff, d - h);
            }
            if (maxDiff == 0 && x > maxD)
                output.println("-1");
            else if (x <= maxD)
                output.println("1");
            else {
                int blows = (x - maxD) / maxDiff + 1;
                if ((x - maxD) % maxDiff != 0)
                    blows++;
                output.println(blows);
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