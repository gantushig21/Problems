import java.io.*;
import java.util.*;

public class A {
    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(System.in);
        PrintWriter output = new PrintWriter(System.out);

        int n = input.nextInt();
        SortedMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int r = input.nextInt();
            map.put(r, i);
        }

        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        int index = 0;
        int[] values = new int[3];
        for (Map.Entry<Integer, Integer> entry : set) {
            values[index++] = entry.getValue() + 1;
            if (index == 3)
                break;
        }

        if (index == 3) {
            System.out.println(values[0] + " " + values[1] + " " + values[2]);
        } else {
            System.out.println("-1 -1 -1");
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