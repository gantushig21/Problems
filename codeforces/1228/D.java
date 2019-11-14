import java.util.*;
import java.io.*;

public class D {
    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(System.in);
        PrintWriter output = new PrintWriter(System.out);

        int n = input.nextInt(), m = input.nextInt();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int u = input.nextInt() - 1;
            int v = input.nextInt() - 1;
            list.get(u).add(v);
            list.get(v).add(u);
        }

        int[] groups = new int[n];
        int[] sizes = new int[n];
        sizes[0] = n;

        int group = 0;
        boolean correct = true;
        for (int i = 0; i < n; i++) {
            boolean find = false;
            ArrayList<Integer> vertices = list.get(i);
            for (Integer vertice : vertices) {
                if (groups[i] == groups[vertice]) {
                    sizes[groups[vertice]]--;
                    sizes[group + 1]++;
                    groups[vertice] = group + 1;
                    find = true;
                }
            }
            if (find)
                group++;
        }

        if (group != 2)
            correct = false;

        // output.println(Arrays.toString(sizes));
        for (int i = 0; i < n; i++)
            if (sizes[groups[i]] != n - list.get(i).size())
                correct = false;

        if (!correct)
            output.println("-1");
        else {
            for (int i = 0; i < n - 1; i++)
                output.print((groups[i] + 1) + " ");
            output.println(groups[n - 1] + 1);
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