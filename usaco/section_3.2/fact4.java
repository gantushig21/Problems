
/*
ID: gantush6
LANG: JAVA
TASK: fact4
*/

import java.io.*;
import java.util.*;

public class fact4 {
    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("fact4.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("fact4.out")));

        int n = input.nextInt();
        int digit = 1, s2 = 0, s5 = 0;
        for (int i = 2; i <= n; i++) {
            int temp = i;
            while (temp % 2 == 0) {
                s2++;
                temp /= 2;
            }
            while (temp % 5 == 0) {
                s5++;
                temp /= 5;
            }

            digit = (digit * temp) % 10;
        }
        for (int i = 0; i < s2 - s5; i++)
            digit = (digit * 2) % 10;

        output.println(digit);
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