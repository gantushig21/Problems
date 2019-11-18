
/*
ID: gantush6
LANG: JAVA
TASK: milk
*/

import java.io.*;
import java.util.*;

public class milk {

    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("milk.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));

        List<Pair> list = new ArrayList<>();
        int n = input.nextInt();
        int m = input.nextInt();
        for (int i = 0; i < m; i++)
            list.add(new Pair(input.nextInt(), input.nextInt()));

        Collections.sort(list);
        int cost = 0;
        for (Pair pair : list) {
            if (pair.second < n) {
                cost += pair.first * pair.second;
                n -= pair.second;
            } else {
                cost += n * pair.first;
                break;
            }
        }
        output.println(cost);

        output.close();
    }

    static class Pair implements Comparable<Pair> {
        public int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair o) {
            return first > o.first ? 1 : -1;
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