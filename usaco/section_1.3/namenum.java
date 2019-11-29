
/*
ID: gantush6
LANG: JAVA
TASK: namenum
*/

import java.io.*;
import java.util.*;

public class namenum {

    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("namenum.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
        FastScanner dictionary = new FastScanner(new FileReader("dict.txt"));

        int[] A = { 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 0, 7, 7, 8, 8, 8, 9, 9, 9, 0 };
        String number = input.next();
        String name = dictionary.next();
        int count = 0;
        while (name != null) {
            if (name.length() == number.length()) {
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < name.length(); i++)
                    temp.append(A[name.charAt(i) - 65] + "");

                if (number.equals(temp.toString())) {
                    output.println(name);
                    count++;
                }
            }
            name = dictionary.next();
        }
        if (count == 0)
            output.println("NONE");
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