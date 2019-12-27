
/*
ID: gantush6
LANG: JAVA
TASK: fracdec
*/

import java.io.*;
import java.util.*;
import java.lang.*;

public class fracdec {

    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("fracdec.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("fracdec.out")));

        int N = input.nextInt(), D = input.nextInt();
        List<Character> list = new ArrayList<>();
        String str = N / D + "";
        for (int i = 0; i < str.length(); i++)
            list.add(str.charAt(i));
        list.add('.');

        Map<Integer, Integer> map = new HashMap<>();
        int number = N % D * 10;
        int count = str.length() + 1;
        while (!map.containsKey(number)) {
            map.put(number, count++);
            list.add((char) (number / D + 48));
            number = number % D * 10;
        }
        int index = map.get(number);
        list.add(index, '(');
        list.add(')');

        int limit = list.size();
        if (index + 3 == list.size() && list.get(index + 1) == '0') {
            limit -= 3;
            if (list.get(limit - 1) == '.') {
                list.set(limit, '0');
                limit++;
            }
        }

        for (int i = 0; i < limit; i++) {
            if (i % 76 == 0 && i > 0)
                output.println();
            output.print(list.get(i));
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