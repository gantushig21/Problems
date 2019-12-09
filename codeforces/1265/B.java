import java.util.*;
import java.io.*;

public class B {
    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(System.in);
        PrintWriter output = new PrintWriter(System.out);

        int t = input.nextInt();
        for (int q = 0; q < t; q++) {
            int n = input.nextInt();

            int[] positions = new int[n + 1];
            for (int i = 0; i < n; i++) {
                int x = input.nextInt();
                positions[x] = i;
            }

            StringBuilder answer = new StringBuilder("");
            int startPosition = Integer.MAX_VALUE;
            int finishPosition = 0;
            for (int i = 1; i <= n; i++) {
                startPosition = Math.min(startPosition, positions[i]);
                finishPosition = Math.max(finishPosition, positions[i]);

                if (finishPosition - startPosition == i - 1)
                    answer.append("1");
                else
                    answer.append("0");
            }
            System.out.println(answer.toString());
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