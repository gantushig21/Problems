
/*
ID: gantush6
LANG: JAVA
TASK: beads
*/

import java.io.*;
import java.util.*;

public class beads {

    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("beads.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));

        int n = input.nextInt();
        String necklace = input.next();

        int[][] left = new int[2 * n + 1][2];
        for (int i = 1; i <= 2 * n; i++) {
            char ch = necklace.charAt((i - 1) % n);
            if (ch == 'b') {
                left[i][0] = left[i - 1][0] + 1;
                left[i][1] = 0;
            } else if (ch == 'r') {
                left[i][0] = 0;
                left[i][1] = left[i - 1][1] + 1;
            } else {
                left[i][0] = left[i - 1][0] + 1;
                left[i][1] = left[i - 1][1] + 1;
            }
        }

        int[][] right = new int[2 * n + 1][2];
        for (int i = 2 * n - 1; i >= 0; i--) {
            char ch = necklace.charAt(i % n);
            if (ch == 'b') {
                right[i][0] = right[i + 1][0] + 1;
                right[i][1] = 0;
            } else if (ch == 'r') {
                right[i][0] = 0;
                right[i][1] = right[i + 1][1] + 1;
            } else {
                right[i][0] = right[i + 1][0] + 1;
                right[i][1] = right[i + 1][1] + 1;
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++)
            max = Math.max(max, Math.max(left[i][0] + right[i][1], left[i][1] + right[i][0]));

        max = Math.min(max, n);

        output.println(max);
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