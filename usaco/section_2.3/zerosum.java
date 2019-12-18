
/*
ID: gantush6
LANG: JAVA
TASK: zerosum
*/

import java.io.*;
import java.util.*;

public class zerosum {
    // static char[] operations = { '+', '-', ' ' };
    static int n;
    static Character[] list;
    static List<String> sequences = new ArrayList<>();

    static void dfs(int a, char op, int b, int current) {
        int c = a + b;
        if (op == '-')
            c = a - b;

        if (current == n + 1) {
            if (c == 0) {
                StringBuilder sequence = new StringBuilder("1");
                int i = 2;
                for (Character operation : list) {
                    sequence.append(operation + "" + i);
                    i++;
                }
                sequences.add(sequence.toString());
            }
        } else {
            list[current - 2] = ' ';
            dfs(a, op, b * 10 + current, current + 1);
            list[current - 2] = '+';
            dfs(c, '+', current, current + 1);
            list[current - 2] = '-';
            dfs(c, '-', current, current + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("zerosum.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("zerosum.out")));

        n = input.nextInt();
        list = new Character[n - 1];

        dfs(0, '+', 1, 2);
        for (String operation : sequences)
            output.println(operation);

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