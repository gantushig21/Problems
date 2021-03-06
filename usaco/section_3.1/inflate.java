
/*
ID: gantush6
LANG: JAVA
TASK: inflate
*/

import java.io.*;
import java.util.*;
import java.lang.*;

public class inflate {
    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("inflate.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("inflate.out")));

        int m = input.nextInt(), n = input.nextInt();
        int[] points = new int[n];
        int[] minutes = new int[n];
        for (int i = 0; i < n; i++) {
            points[i] = input.nextInt();
            minutes[i] = input.nextInt();
        }

        int[] A = new int[m + 1];
        A[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = minutes[i]; j <= m; j++)
                A[j] = Math.max(A[j], A[j - minutes[i]] + points[i]);
        }

        output.println(A[m]);
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