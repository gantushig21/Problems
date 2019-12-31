
/*
ID: gantush6
LANG: JAVA
TASK: humble
*/

import java.io.*;
import java.util.*;
import java.lang.*;

public class humble {
    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("humble.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("humble.out")));

        int k = input.nextInt(), n = input.nextInt();
        int[] primes = new int[k];
        int[] indexes = new int[k];
        for (int i = 0; i < k; i++)
            primes[i] = input.nextInt();

        int[] numbers = new int[n + 1];
        numbers[0] = 1;

        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int j = 0; j < k; j++) {
                while (primes[j] * numbers[indexes[j]] <= numbers[i - 1])
                    indexes[j]++;

                if (primes[j] * numbers[indexes[j]] < min) {
                    min = primes[j] * numbers[indexes[j]];
                    minIndex = j;
                }
            }
            numbers[i] = min;
            indexes[minIndex]++;
        }

        output.println(numbers[n]);
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