
/*
ID: gantush6
LANG: JAVA
TASK: lamps
*/

import java.io.*;
import java.util.*;

public class lamps {
    static int N;
    static List<Integer> on = new ArrayList<>();
    static List<Integer> off = new ArrayList<>();

    static void executeAction(int buttonNumber, List<Integer> lamps) {
        if (buttonNumber == 1) {
            for (int i = 0; i < N; i++)
                lamps.set(i, 1 - lamps.get(i));
        } else if (buttonNumber == 2) {
            for (int i = 0; i < N; i += 2)
                lamps.set(i, 1 - lamps.get(i));
        } else if (buttonNumber == 3) {
            for (int i = 1; i < N; i += 2)
                lamps.set(i, 1 - lamps.get(i));
        } else {
            for (int i = 0; i < N; i += 3)
                lamps.set(i, 1 - lamps.get(i));
        }
    }

    static boolean checkCondition(List<Integer> lamps) {
        for (Integer x : on) {
            if (lamps.get(x) == 0)
                return false;
        }
        for (Integer x : off) {
            if (lamps.get(x) == 1)
                return false;
        }
        return true;
    }

    static class SortByBinary implements Comparator<List<Integer>> {
        public int compare(List<Integer> l1, List<Integer> l2) {
            for (int i = 0; i < l1.size(); i++) {
                int b1 = l1.get(i);
                int b2 = l2.get(i);
                if (b1 > b2)
                    return 1;
                else if (b1 < b2)
                    return -1;
            }
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("lamps.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("lamps.out")));

        int[][] options = { { 0 }, { 1, 2, 4, 8 }, { 0, 3, 5, 6, 9, 10, 12 }, { 1, 2, 4, 7, 8, 11, 13, 14 },
                { 0, 3, 5, 6, 9, 10, 12, 15 } };

        N = input.nextInt();
        int C = input.nextInt();
        int x = input.nextInt();
        while (x != -1) {
            on.add(x - 1);
            x = input.nextInt();
        }
        x = input.nextInt();
        while (x != -1) {
            off.add(x - 1);
            x = input.nextInt();
        }

        if (C > 4) {
            if (C % 2 == 1)
                C = 3;
            else
                C = 4;
        }

        List<List<Integer>> lists = new ArrayList<>();
        for (int option : options[C]) {
            List<Integer> lamps = new ArrayList<>(N);
            for (int i = 0; i < N; i++)
                lamps.add(1);
            for (int i = 0; i < 4; i++) {
                if (((1 << i) & option) != 0) {
                    executeAction(i + 1, lamps);
                }
            }
            if (checkCondition(lamps)) {
                lists.add(lamps);
            }
        }

        Collections.sort(lists, new SortByBinary());

        for (List<Integer> list : lists) {
            for (Integer lamp : list)
                output.print(lamp);
            output.println();
        }

        if (lists.size() == 0)
            output.println("IMPOSSIBLE");

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