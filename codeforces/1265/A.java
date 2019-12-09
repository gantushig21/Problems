import java.util.*;
import java.io.*;

public class A {
    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(System.in);
        PrintWriter output = new PrintWriter(System.out);

        int t = input.nextInt();
        for (int q = 0; q < t; q++) {
            String s = input.next();

            StringBuilder word = new StringBuilder(s);
            boolean done = true;

            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == '?') {
                    String options = "abc";
                    if (i > 0) {
                        options = options.replace(word.charAt(i - 1) + "", "");
                    }
                    if (i + 1 < word.length() && word.charAt(i + 1) != '?') {
                        options = options.replace(word.charAt(i + 1) + "", "");
                    }
                    word.setCharAt(i, options.charAt(0));
                }
                if (i > 0 && word.charAt(i - 1) == word.charAt(i)) {
                    done = false;
                    break;
                }
            }

            if (!done)
                System.out.println("-1");
            else
                System.out.println(word.toString());
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