
/*
ID: gantush6
LANG: JAVA
TASK: ride
*/

import java.io.*;
import java.util.*;

public class ride {
    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("ride.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));

        String comet = input.next();
        String group = input.next();

        String answer = "STAY";
        if (getScore(comet) == getScore(group))
            answer = "GO";

        output.println(answer);
        output.close();
    }

    static int getScore(String name) {
        int score = 1;
        for (int i = 0; i < name.length(); i++) {
            score *= name.charAt(i) - 64;
            score %= 47;
        }

        return score;
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