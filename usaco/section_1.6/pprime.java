
/*
ID: gantush6
LANG: JAVA
TASK: pprime
*/

import java.io.*;
import java.util.*;

public class pprime {
    static int A, B;
    static List<Integer> pprimes = new ArrayList<>();

    static boolean isPrime(int n) {
        if (n < 2)
            return false;

        int k = (int) Math.sqrt(n);

        for (int i = 2; i <= k; i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }

    static void check(int n) {
        if (A <= n && n <= B && isPrime(n))
            pprimes.add(n);
    }

    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("pprime.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));

        A = input.nextInt();
        B = input.nextInt();

        for (int a = 1; a <= 9; a += 2) {
            check(a);
            check(a * 10 + a);
            for (int b = 0; b <= 9; b++) {
                check(a * 100 + b * 10 + a);
                check(a * 1000 + b * 100 + b * 10 + a);
                for (int c = 0; c <= 9; c++) {
                    check(a * 10000 + b * 1000 + c * 100 + b * 10 + a);
                    check(a * 100000 + b * 10000 + c * 1000 + c * 100 + b * 10 + a);
                    for (int d = 0; d <= 9; d++)
                        check(a * 1000000 + b * 100000 + c * 10000 + d * 1000 + c * 100 + b * 10 + a);
                }
            }
        }

        Collections.sort(pprimes);
        for (Integer pprime : pprimes)
            output.println(pprime);

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