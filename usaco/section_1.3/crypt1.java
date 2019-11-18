
/*
ID: gantush6
LANG: JAVA
TASK: crypt1
*/

import java.io.*;
import java.util.*;

public class crypt1 {

    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("crypt1.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));

        boolean[] exists = new boolean[10];
        List<Integer> digits = new ArrayList<>();
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            int digit = input.nextInt();
            digits.add(digit);
            exists[digit] = true;
        }

        List<Integer> abc = new ArrayList<>();
        List<Integer> de = new ArrayList<>();
        createList(abc, 0, 0, digits, 3);
        createList(de, 0, 0, digits, 2);

        int count = 0;
        for (Integer first : abc) {
            for (Integer second : de) {
                int abce = first * (second % 10);
                int abcd = first * (second / 10);
                if (checkNumber(abce, exists) && abce < 1000 && checkNumber(abcd, exists) && abcd < 1000
                        && first * second < 10000 && checkNumber(first * second, exists)) {
                    count++;
                    // System.out.println(first + " " + second);
                }
            }
        }

        output.println(count);
        output.close();
    }

    static boolean checkNumber(int number, boolean[] exists) {
        while (number != 0) {
            if (!exists[number % 10])
                return false;
            number /= 10;
        }
        return true;
    }

    static void createList(List<Integer> list, int value, int current, List<Integer> digits, int size) {
        if (current == size) {
            list.add(value);
            return;
        }
        for (Integer number : digits)
            createList(list, value * 10 + number, current + 1, digits, size);
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