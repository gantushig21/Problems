
/*
ID: gantush6
LANG: JAVA
TASK: hamming
*/

import java.io.*;
import java.util.*;

public class hamming {
    static int N, B, D;
    static int[] numbers;
    static int finish;
    static boolean ended = false;

    static int countBitDifference(int x, int y) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int v1 = (x >> i) & 1;
            int v2 = (y >> i) & 1;
            if (v1 != v2)
                count++;
        }
        return count;
    }

    static void dfs(int start, int index) {
        if (index == N)
            ended = true;

        for (int i = start; i < finish; i++) {
            if (ended)
                return;

            boolean passed = true;
            for (int j = index - 1; j >= 0; j--) {
                if (countBitDifference(i, numbers[j]) < D) {
                    passed = false;
                    break;
                }
            }
            if (passed) {
                numbers[index] = i;
                dfs(i + 1, index + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("hamming.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("hamming.out")));

        N = input.nextInt();
        B = input.nextInt();
        D = input.nextInt();
        numbers = new int[N];
        finish = 1 << B;

        dfs(0, 0);
        for (int i = 0; i < N; i++) {
            if (i % 10 != 0) {
                output.print(" ");
            } else if (i != 0)
                output.println();
            output.print(numbers[i]);
        }
        output.println();
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