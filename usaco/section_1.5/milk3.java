
/*
ID: gantush6
LANG: JAVA
TASK: milk3
*/

import java.io.*;
import java.util.*;

public class milk3 {
    final static int LIMIT = 21;
    static boolean[][][] buckets = new boolean[LIMIT][LIMIT][LIMIT];
    static int A, B, C;
    static boolean[] possible = new boolean[LIMIT];

    static void pour(int a, int b, int c) {
        if (buckets[a][b][c])
            return;
        buckets[a][b][c] = true;
        if (a == 0)
            possible[c] = true;

        if (a + c > A)
            pour(A, b, a + c - A);
        else
            pour(a + c, b, 0);

        if (b + c > B)
            pour(a, B, b + c - B);
        else
            pour(a, b + c, 0);

        if (a + b > A)
            pour(A, a + b - A, c);
        else
            pour(a + b, 0, c);

        if (c + b > C)
            pour(a, c + b - C, C);
        else
            pour(a, 0, c + b);

        if (b + a > B)
            pour(b + a - B, B, c);
        else
            pour(0, b + a, c);

        if (c + a > C)
            pour(c + a - C, b, C);
        else
            pour(0, b, c + a);
    }

    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("milk3.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));

        A = input.nextInt();
        B = input.nextInt();
        C = input.nextInt();

        pour(0, 0, C);

        for (int i = 0; i < C; i++) {
            if (possible[i])
                output.print(i + " ");
        }
        output.println(C);

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