
/*
ID: gantush6
LANG: JAVA
TASK: subset
*/

import java.io.*;
import java.util.*;

public class subset {

    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("subset.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("subset.out")));

        int n = input.nextInt();
        int m = n * (n + 1);

        if (m % 4 == 0)
            m /= 4;
        else
            m = 1;

        long[] A = new long[m + 1];
        A[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= i; j--)
                A[j] = A[j] + A[j - i];
        }

        output.println(A[m] / 2);
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