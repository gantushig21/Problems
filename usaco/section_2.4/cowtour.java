
/*
ID: gantush6
LANG: JAVA
TASK: cowtour
*/

import java.io.*;
import java.util.*;
import java.lang.*;

public class cowtour {
    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("cowtour.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("cowtour.out")));

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