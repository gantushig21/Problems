
/*
ID: gantush6
LANG: JAVA
TASK: ariprog
*/

import java.io.*;
import java.util.*;

public class ariprog {
    static class Pair implements Comparable<Pair> {
        public int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            if (y != o.y)
                return y - o.y;

            return x - o.x;
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("ariprog.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));

        int n = input.nextInt(), m = input.nextInt();
        int m2 = m * m;
        boolean[] bisquares = new boolean[2 * m2 + 1];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= m; i++) {
            for (int j = i; j <= m; j++) {
                int pq = i * i + j * j;
                if (!bisquares[pq]) {
                    bisquares[pq] = true;
                    list.add(pq);
                }
            }
        }

        Collections.sort(list);

        List<Pair> pairs = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int element = list.get(i);
                int diff = list.get(j) - element;
                count = 0;
                while (count < n && element <= 2 * m2 && bisquares[element]) {
                    count++;
                    element += diff;
                }
                if (count == n)
                    pairs.add(new Pair(list.get(i), diff));
            }
        }

        if (pairs.size() == 0)
            output.println("NONE");
        else {
            Collections.sort(pairs);
            for (Pair pair : pairs)
                output.println(pair.x + " " + pair.y);
        }

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