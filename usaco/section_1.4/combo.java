
/*
ID: gantush6
LANG: JAVA
TASK: combo
*/

import java.io.*;
import java.util.*;

public class combo {

    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("combo.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));

        int n = input.nextInt();
        Combination farmer = new Combination(input.nextInt(), input.nextInt(), input.nextInt());
        Combination master = new Combination(input.nextInt(), input.nextInt(), input.nextInt());

        Combination comb = new Combination(0, 0, 0);
        int count = 0;
        for (comb.a = 1; comb.a <= n; comb.a++) {
            for (comb.b = 1; comb.b <= n; comb.b++) {
                for (comb.c = 1; comb.c <= n; comb.c++) {
                    if (isCloseCombination(comb, farmer, n) || isCloseCombination(comb, master, n))
                        count++;
                }
            }
        }

        output.println(count);
        output.close();
    }

    static boolean isCloseCombination(Combination c1, Combination c2, int n) {
        if (!isClose(c1.a, c2.a, n) || !isClose(c1.b, c2.b, n) || !isClose(c1.c, c2.c, n))
            return false;

        return true;
    }

    static boolean isClose(int p1, int p2, int n) {
        int p = Math.abs(p1 - p2);

        return p < 3 || p > n - 3;
    }

    static class Combination {
        public int a, b, c;

        public Combination(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
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