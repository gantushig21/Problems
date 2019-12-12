
/*
ID: gantush6
LANG: JAVA
TASK: sort3
*/

import java.io.*;
import java.util.*;

public class sort3 {
    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("sort3.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));

        int n = input.nextInt();
        int[] a = new int[n];
        int[] count = new int[4];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
            count[a[i]]++;
        }

        int[][] b = new int[4][4];
        int limit = 0, j = 0;
        for (int i = 1; i <= 3; i++) {
            limit += count[i];
            while (j < limit) {
                b[i][a[j++]]++;
            }
        }

        int[][] pairs = { { 1, 2 }, { 1, 3 }, { 2, 3 } };
        int diff = 0;
        int exchanges = 0;
        for (int[] pair : pairs) {
            exchanges += Math.min(b[pair[0]][pair[1]], b[pair[1]][pair[0]]);
            diff += Math.abs(b[pair[0]][pair[1]] - b[pair[1]][pair[0]]);
        }
        exchanges += diff / 3 * 2;

        output.println(exchanges);
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