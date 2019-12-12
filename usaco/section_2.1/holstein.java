
/*
ID: gantush6
LANG: JAVA
TASK: holstein
*/

import java.io.*;
import java.util.*;

public class holstein {
    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("holstein.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("holstein.out")));

        int n = input.nextInt();
        int[] v = new int[n];
        for (int i = 0; i < n; i++)
            v[i] = input.nextInt();

        int m = input.nextInt();
        int[][] g = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                g[i][j] = input.nextInt();
        }

        int[] total = new int[n];
        int min = Integer.MAX_VALUE, minValue = Integer.MAX_VALUE;
        int limit = 1 << m;
        for (int i = 1; i < limit; i++) {
            int count = 0;
            for (int j = 0; j < m; j++) {
                int value = (1 << j) & i;
                if (value != 0) {
                    count++;
                    for (int q = 0; q < n; q++)
                        total[q] += g[j][q];
                }
            }
            boolean passed = true;
            for (int q = 0; q < n; q++) {
                if (total[q] < v[q])
                    passed = false;
                total[q] = 0;
            }
            if (passed && count < min) {
                min = count;
                minValue = i;
            }
        }

        output.print(min);
        for (int i = 0; i < m; i++) {
            int value = (1 << i) & minValue;
            if (value != 0)
                output.print(" " + (i + 1));
        }
        output.println();
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