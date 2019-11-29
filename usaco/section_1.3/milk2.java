
/*
ID: gantush6
LANG: JAVA
TASK: milk2
*/

import java.io.*;
import java.util.*;

public class milk2 {

    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("milk2.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));

        int n = input.nextInt();
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++)
            pairs[i] = new Pair(input.nextInt(), input.nextInt());

        Arrays.sort(pairs, new PairComparator());

        Pair interval = pairs[0].clone();
        int longestMilked = 0;
        int longestUnmilked = 0;
        for (Pair pair : pairs) {
            if (interval.finish < pair.start) {
                longestUnmilked = Math.max(longestUnmilked, pair.start - interval.finish);
                longestMilked = Math.max(longestMilked, interval.finish - interval.start);
                interval.start = pair.start;
                interval.finish = pair.finish;
            } else
                interval.finish = Math.max(interval.finish, pair.finish);
        }
        longestMilked = Math.max(longestMilked, interval.finish - interval.start);

        output.println(longestMilked + " " + longestUnmilked);
        output.close();
    }

    static class Pair implements Cloneable {
        public int start;
        public int finish;

        public Pair(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }

        @Override
        protected Pair clone() {
            try {
                return (Pair) super.clone();
            } catch (CloneNotSupportedException e) {
                return this;
            }
        }
    }

    static class PairComparator implements Comparator<Pair> {

        @Override
        public int compare(Pair o1, Pair o2) {
            if (o1.start > o2.start)
                return 1;
            if (o1.start < o2.start)
                return -1;
            if (o1.finish > o2.finish)
                return 1;
            if (o1.finish < o2.finish)
                return -1;

            return 0;
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