
/*
ID: gantush6
LANG: JAVA
TASK: ratios
*/

import java.io.*;
import java.util.*;

public class ratios {
    static int getDeterminant(int[][] arr, int a, int b, int c) {
        return arr[0][a] * arr[1][b] * arr[2][c] + 
            arr[0][c] * arr[1][a] * arr[2][b] + 
            arr[0][b] * arr[1][c] * arr[2][a] -
            arr[0][c] * arr[1][b] * arr[2][a] -
            arr[0][a] * arr[1][c] * arr[2][b] -
            arr[0][b] * arr[1][a] * arr[2][c];
    }

    static int gcd(int a, int b) {
        if (a == 0 )
            return b;

        return gcd(b % a, a);
    }
    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("ratios.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("ratios.out")));

        int[][] arr = new int[3][4];
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 3; j++)
                arr[j][i] = input.nextInt();

        int[] d = new int[4];
        d[3] = getDeterminant(arr, 1, 2, 3);
        d[0] = getDeterminant(arr, 0, 2, 3);
        d[1] = getDeterminant(arr, 1, 0, 3);
        d[2] = getDeterminant(arr, 1, 2, 0);

        // System.out.println(Arrays.toString(d));
        int gcd = d[0];
        for (int i = 1; i < 4; i++)
            gcd = gcd(gcd, d[i]);

        boolean none = gcd == 0 ? true : false;

        if (!none) {
            for (int i = 0; i < 4; i++) {
                if (d[i] / gcd < 0) {
                    none = true;
                    break;
                }
            }
        }

        if (none)
            output.println("NONE");
        else {
            output.println(d[0] / gcd + " " + d[1] / gcd + " " + d[2] / gcd + " " + d[3] / gcd);
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