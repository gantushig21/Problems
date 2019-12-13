
/*
ID: gantush6
LANG: JAVA
TASK: runround
*/

import java.io.*;
import java.util.*;

public class runround {
    static boolean isRunaroundNumber(int[] digits, int length) {
        boolean[] d = new boolean[10];

        int current = 0;
        for (int i = 0; i < length; i++) {
            if (d[digits[current]])
                return false;
            d[digits[current]] = true;
            current = (current + length - digits[current] % length) % length;
        }

        return current == 0;
    }

    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("runround.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("runround.out")));

        int m = input.nextInt() + 1;

        int[] digits = new int[10];
        int length = 0;
        int temp = m;
        while (temp != 0) {
            digits[length++] = temp % 10;
            temp /= 10;
        }

        while (!isRunaroundNumber(digits, length)) {
            int r = 0;
            digits[0]++;
            for (int i = 0; i < length; i++) {
                temp = (digits[i] + r) / 10;
                digits[i] = (digits[i] + r) % 10;
                r = temp;
            }
            if (r != 0) {
                length++;
                digits[length] = r;
            }
        }

        for (int i = length - 1; i >= 0; i--)
            output.print(digits[i]);
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