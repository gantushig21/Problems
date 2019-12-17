
/*
ID: gantush6
LANG: JAVA
TASK: prefix
*/

import java.io.*;
import java.util.*;

public class prefix {
    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("prefix.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("prefix.out")));

        Set<String> set = new HashSet<>();
        String primitive = input.next();
        while (!primitive.equals(".")) {
            set.add(primitive);
            primitive = input.next();
        }

        StringBuilder sb = new StringBuilder();
        String part = input.next();
        while (part != null) {
            sb.append(part);
            part = input.next();
        }

        String sequence = sb.toString();
        int[] A = new int[sequence.length()];
        int maxLength = 0;
        for (int i = 0; i < sequence.length(); i++) {
            String word = "";
            for (int j = 0; j < 10; j++) {
                if (i - j >= 0) {
                    word = sequence.charAt(i - j) + word;
                    if ((i - j == 0 || (i - j > 0 && A[i - j - 1] == 1)) && set.contains(word)) {
                        maxLength = i + 1;
                        A[i] = 1;
                        break;
                    }
                }
            }
        }
        output.println(maxLength);

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