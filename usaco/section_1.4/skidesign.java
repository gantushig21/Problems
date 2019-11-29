
/*
ID: gantush6
LANG: JAVA
TASK: skidesign
*/

import java.io.*;
import java.util.*;

public class skidesign {

    static int getCost(int[] hills, int min, int max) {
        int cost = 0;
        for (int height : hills) {
            if (height < min)
                cost += Math.pow(min - height, 2);
            else if (max < height)
                cost += Math.pow(height - max, 2);
        }

        return cost;
    }

    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("skidesign.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));

        int n = input.nextInt();
        int[] hills = new int[n];
        for (int i = 0; i < n; i++)
            hills[i] = input.nextInt();

        int minCost = Integer.MAX_VALUE;
        for (int min = 1; min <= 100; min++) {
            int max = min + 17;
            int cost = getCost(hills, min, max);
            if (cost < minCost)
                minCost = cost;
        }

        output.println(minCost);
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