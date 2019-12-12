
/*
ID: gantush6
LANG: JAVA
TASK: preface
*/

import java.io.*;
import java.util.*;

public class preface {
    static void countLetters(Map<Character, Integer> count, String str) {
        for (int i = 0; i < str.length(); i++) {
            count.put(str.charAt(i), count.get(str.charAt(i)) + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("preface.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("preface.out")));

        Map<Integer, String> map = new HashMap<>();

        Map<Character, Integer> count = new HashMap<>();
        String[] s = { "I", "V", "X", "L", "C", "D", "M" };
        for (String str : s)
            count.put(str.charAt(0), 0);

        int p = 1;
        for (int i = 0; i < 7; i += 2) {
            map.put(p, s[i]);
            map.put(2 * p, s[i] + s[i]);
            map.put(3 * p, s[i] + s[i] + s[i]);
            if (p < 1000) {
                map.put(4 * p, s[i] + s[i + 1]);
                map.put(5 * p, s[i + 1]);
                map.put(6 * p, s[i + 1] + s[i]);
                map.put(7 * p, s[i + 1] + s[i] + s[i]);
                map.put(8 * p, s[i + 1] + s[i] + s[i] + s[i]);
                map.put(9 * p, s[i] + s[i + 2]);
            }
            p *= 10;
        }
        // for (Map.Entry<Integer, String> entry : map.entrySet())
        // output.println(entry.getKey() + " " + entry.getValue());

        int n = input.nextInt();
        for (int i = 1; i <= n; i++) {
            int temp = i;
            p = 1;
            while (temp != 0) {
                if (temp % 10 != 0)
                    countLetters(count, map.get(p * (temp % 10)));
                p *= 10;
                temp /= 10;
            }
        }

        for (String str : s) {
            if (count.get(str.charAt(0)) != 0)
                output.println(str.charAt(0) + " " + count.get(str.charAt(0)));
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