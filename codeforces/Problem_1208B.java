import java.util.*;
import java.io.*;

public class Problem_1208B {
    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(System.in);
        PrintWriter output = new PrintWriter(System.out);

        int n = input.nextInt();
        int[] a = new int[n];

        Map<Integer, Integer> map = new HashMap<>();
        int m = 0;

        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
            if (!map.containsKey(a[i]))
                map.put(a[i], m++);
        }
        if (n == m) {
            output.println(0);
            output.close();
            System.exit(0);
        }
        for (int i = 0; i < n; i++)
            a[i] = map.get(a[i]);

        boolean[] used = new boolean[n];
        Arrays.fill(used, false);
        int count = 0;
        for (int i = 0; i < n; i++) {
            int take = 0;
            for (int j = 0; j < n; j++) {
                if (used[a[n - 1 - j]])
                    break;
                used[a[n - 1 - j]] = true;
                take++;
            }
            count = Math.max(count, i + take);
            for (int j = 0; j < take; j++)
                used[a[n - 1 - j]] = false;

            if (used[a[i]])
                break;

            used[a[i]] = true;
        }

        output.println(n - count);
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