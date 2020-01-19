
/*
ID: gantush6
LANG: JAVA
TASK: kimbits
*/

import java.io.*;
import java.util.*;

public class kimbits {
    final static int BIT_SIZE = 32;
    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("kimbits.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("kimbits.out")));

        int[][] c = new int[BIT_SIZE][BIT_SIZE];
        c[0][0] = 1;
        for (int i = 1; i < BIT_SIZE; i++) {
            c[i][0] = 1;
            for (int j = 1; j < BIT_SIZE; j++)
                c[i][j] = c[i - 1][j - 1] + c[i - 1][j];
        }
        for (int i = 0; i < BIT_SIZE; i++) {
            for (int j = 1; j < BIT_SIZE; j++)
                c[i][j] = c[i][j - 1] + c[i][j];
        }
        int N = input.nextInt(), L = input.nextInt();
        long I = input.nextLong();
        StringBuilder sb = new StringBuilder();
        for (int i = N; i >= 1; i--) {
            if (c[i - 1][L] >= I) {
                sb.append("0");
            } else {
                sb.append("1");
                I -= c[i - 1][L];
                L--;
            }
        }

        output.println(sb.toString());
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