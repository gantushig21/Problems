
/*
ID: gantush6
LANG: JAVA
TASK: dualpal
*/

import java.io.*;
import java.util.*;

public class dualpal {

    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("dualpal.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));

        int N = input.nextInt();
        int S = input.nextInt();
        int found = 0;
        while (found < N) {
            S++;
            int count = 0, i = 2;
            while (count < 2 && i < 11) {
                if (isPalindrome(baseConversion(S + "", 10, i++)))
                    count++;
            }
            if (count == 2) {
                output.println(S);
                found++;
            }
        }

        output.close();
    }

    public static boolean isPalindrome(String str) {
        int length = str.length();
        for (int i = 0; i < length / 2; i++)
            if (str.charAt(i) != str.charAt(length - i - 1))
                return false;
        return true;
    }

    public static String baseConversion(String number, int sBase, int dBase) {
        return Integer.toString(Integer.parseInt(number, sBase), dBase);
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