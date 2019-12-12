
/*
ID: gantush6
LANG: JAVA
TASK: frac1
*/

import java.io.*;
import java.util.*;

public class frac1 {
    static int n;

    static class Fraction {
        public int numerator, denominator;

        public Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    static List<Fraction> list = new ArrayList<>();

    static void dfs(int n1, int d1, int n2, int d2) {
        if (d1 + d2 <= n) {
            dfs(n1, d1, n1 + n2, d1 + d2);
            list.add(new Fraction(n1 + n2, d1 + d2));
            dfs(n1 + n2, d1 + d2, n2, d2);
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("frac1.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));

        n = input.nextInt();

        list.add(new Fraction(0, 1));
        dfs(0, 1, 1, 1);
        list.add(new Fraction(1, 1));

        for (Fraction fraction : list)
            output.println(fraction.numerator + "/" + fraction.denominator);

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