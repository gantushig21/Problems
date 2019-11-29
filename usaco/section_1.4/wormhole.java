
/*
ID: gantush6
LANG: JAVA
TASK: wormhole
*/

import java.io.*;
import java.util.*;

public class wormhole {

    static int recursive(int[] pair, int[] next, int n) {
        int count = 0;

        int first = 0;
        while (first < n && pair[first] != -1)
            first++;

        if (first == n) {
            if (isCycle(pair, next, n))
                return 1;
            return 0;
        }

        for (int second = first + 1; second < n; second++) {
            if (pair[second] == -1) {
                pair[first] = second;
                pair[second] = first;
                count += recursive(pair, next, n);
                pair[first] = -1;
                pair[second] = -1;
            }
        }

        return count;
    }

    static boolean isCycle(int[] pair, int[] next, int n) {
        boolean cycle = false;

        for (int i = 0; i < n; i++) {
            int position = i;
            for (int j = 0; j < n; j++) {
                position = next[pair[position]];
                if (position == -1)
                    break;
            }
            if (position != -1)
                cycle = true;
        }
        return cycle;
    }

    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("wormhole.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));

        int n = input.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        int[] next = new int[n];
        int[] pair = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = input.nextInt();
            y[i] = input.nextInt();
            next[i] = -1;
            pair[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (y[i] == y[j] && x[i] < x[j]) {
                    if (next[i] == -1 || x[j] < x[next[i]])
                        next[i] = j;
                }
            }
        }

        output.println(recursive(pair, next, n));

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