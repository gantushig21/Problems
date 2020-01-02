
/*
ID: gantush6
LANG: JAVA
TASK: stamps
*/

import java.io.*;
import java.util.*;
import java.lang.*;

public class stamps {
    static int MAX_SIZE = 2000000;

    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("stamps.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("stamps.out")));

        int K = input.nextInt(), N = input.nextInt();
        int[] A = new int[MAX_SIZE + 1];
        for (int i = 0; i < N; i++) {
            int stamp = input.nextInt();
            A[stamp] = 1;
            for (int j = stamp + 1; j <= MAX_SIZE; j++) {
                if (A[j - stamp] != 0 && A[j] != 0) {
                    A[j] = Math.min(A[j - stamp] + 1, A[j]);
                } else if (A[j - stamp] != 0) {
                    A[j] = A[j - stamp] + 1;
                }
            }
        }

        for (int i = 1; i <= MAX_SIZE; i++) {
            if (A[i] > K || A[i] == 0) {
                output.println(i - 1);
                break;
            }
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