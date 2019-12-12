
/*
ID: gantush6
LANG: JAVA
TASK: sprime
*/

import java.io.*;
import java.util.*;

public class sprime {
    static int N;
    static List<Integer> primes = new ArrayList<>();

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

    static void recursive(int n, int length) {
        if (length == N)
            primes.add(n);

        for (int i = length == 0 ? 1 : 0; i <= 9; i++) {
            if (isPrime(n * 10 + i))
                recursive(n * 10 + i, length + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("sprime.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));

        N = input.nextInt();

        recursive(0, 0);

        for (Integer prime : primes)
            output.println(prime);

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