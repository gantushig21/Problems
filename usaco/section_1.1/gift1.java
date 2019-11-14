
/*
ID: gantush6
LANG: JAVA
TASK: gift1
*/

import java.io.*;
import java.util.*;

public class gift1 {
    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("gift1.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));

        Map<String, Integer> map = new LinkedHashMap<>();

        String name, friend;
        int amount, number, each;
        int np = input.nextInt();
        for (int i = 0; i < np; i++) {
            name = input.next();
            map.put(name, 0);
        }

        for (int i = 0; i < np; i++) {
            name = input.next();
            amount = input.nextInt();
            number = input.nextInt();
            if (number != 0) {
                each = amount / number;
                map.put(name, map.get(name) - each * number);
                for (int j = 0; j < number; j++) {
                    friend = input.next();
                    map.put(friend, map.get(friend) + each);
                }
            }
        }

        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet)
            output.println(entry.getKey() + " " + entry.getValue());

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