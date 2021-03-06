
/*
ID: gantush6
LANG: JAVA
TASK: numtri
*/

import java.io.*;
import java.util.*;

public class numtri {
    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("numtri.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));

        int n = input.nextInt();
        int[] a = new int[n];
        for (int i = 1; i <= n; i++) {
            int previous = 0, temp;
            for (int j = 0; j < i; j++) {
                temp = a[j];
                a[j] = Math.max(previous, a[j]) + input.nextInt();
                previous = temp;
            }
        }

        int highest = 0;
        for (int i = 0; i < n; i++)
            highest = Math.max(highest, a[i]);

        output.println(highest);

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