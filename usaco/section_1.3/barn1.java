
/*
ID: gantush6
LANG: JAVA
TASK: barn1
*/

import java.io.*;
import java.util.*;

public class barn1 {

    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("barn1.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));

        int m = input.nextInt(), s = input.nextInt(), c = input.nextInt();
        int[] stalls = new int[c];
        for (int i = 0; i < c; i++)
            stalls[i] = input.nextInt();

        List<Integer> list = new ArrayList<>();
        Arrays.sort(stalls);
        for (int i = 1; i < c; i++)
            list.add(stalls[i] - stalls[i - 1]);
        Collections.sort(list, Collections.reverseOrder());

        int numberOfStalls = stalls[c - 1] - stalls[0] + 1;
        m = Math.min(m, list.size() + 1);
        for (int i = 1; i < m; i++)
            numberOfStalls -= list.get(i - 1) - 1;

        output.println(numberOfStalls);
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