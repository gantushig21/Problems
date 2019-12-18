
/*
ID: gantush6
LANG: JAVA
TASK: concom
*/

import java.io.*;
import java.util.*;
import java.lang.*;

public class concom {
    static class Triple {
        public int a, b, percent;

        public Triple(int a, int b, int percent) {
            this.a = a;
            this.b = b;
            this.percent = percent;
        }
    }

    static class Pair implements Comparable<Pair> {
        public int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Pair p) {
            if (a != p.a)
                return a - p.a;
            return b - p.b;
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("concom.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("concom.out")));

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> companies = new ArrayList<>();
        int n = input.nextInt();
        Triple[] triples = new Triple[n];
        int m = 0;
        for (int i = 0; i < n; i++) {
            int a = input.nextInt(), b = input.nextInt(), percent = input.nextInt();
            if (map.get(a) == null) {
                map.put(a, m++);
                companies.add(a);
            }

            if (map.get(b) == null) {
                map.put(b, m++);
                companies.add(b);
            }

            triples[i] = new Triple(a, b, percent);
        }

        int[][] stock = new int[m][m];
        for (int i = 0; i < n; i++) {
            int aIndex = map.get(triples[i].a);
            int bIndex = map.get(triples[i].b);
            stock[aIndex][bIndex] = triples[i].percent;
        }

        for (int c = 0; c < m; c++) {
            for (int a = 0; a < m; a++) {
                if (a != c && stock[a][c] > 50) {
                    for (int b = 0; b < m; b++) {
                        if (a != b && b != c)
                            stock[a][b] += stock[c][b];
                    }
                }
            }
        }
        List<Pair> list = new ArrayList<>();
        for (int a = 0; a < m; a++) {
            for (int b = 0; b < m; b++) {
                if (a != b && stock[a][b] > 50)
                    list.add(new Pair(companies.get(a), companies.get(b)));
            }
        }

        Collections.sort(list);
        for (Pair pair : list)
            output.println(pair.a + " " + pair.b);

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