
/*
ID: gantush6
LANG: JAVA
TASK: beads
*/

import java.io.*;
import java.util.*;

public class milk2 {

    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("milk2.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));

        int n = input.nextInt();

        output.close();
    }

    static class Pair {
        public int start;
        public int finish;

        public Pair(int start, int finish) {
            this.start = start;
            this.finish = finish;
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