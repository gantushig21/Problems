
/*
ID: gantush6
LANG: JAVA
TASK: friday
*/

import java.io.*;
import java.util.*;

public class friday {
    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("friday.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));

        int[] A = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int[] days = { 0, 0, 0, 0, 0, 0, 0 };

        int n = input.nextInt();
        int total = 0;
        for (int year = 1900; year < 1900 + n; year++) {
            A[1] = 28;
            if (isLeapYear(year))
                A[1] = 29;
            for (int i = 0; i < 12; i++) {
                days[(total + 13) % 7]++;
                total += A[i];
            }
        }

        output.println(days[6] + " " + days[0] + " " + days[1] + " " + days[2] + " " + days[3] + " " + days[4] + " "
                + days[5]);
        output.close();
    }

    static boolean isLeapYear(int year) {
        if (year % 100 == 0) {
            return year % 400 == 0;
        }
        return year % 4 == 0;
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
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
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