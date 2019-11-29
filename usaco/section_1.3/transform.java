
/*
ID: gantush6
LANG: JAVA
TASK: transform
*/

import java.io.*;
import java.util.*;

public class transform {

    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("transform.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));

        int n = input.nextInt();

        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++)
            map[i] = input.next().toCharArray();

        char[][] answer = new char[n][n];
        for (int i = 0; i < n; i++)
            answer[i] = input.next().toCharArray();

        int step = 7;
        if (isEqual(map, answer))
            step = 6;

        int step13 = step13(map, answer);
        if (step13 != -1)
            step = step13;
        else {
            reflection(map);
            if (isEqual(map, answer))
                step = 4;
            else {
                step13 = step13(map, answer);
                if (step13 != -1)
                    step = 5;
            }
        }

        output.println(step);
        output.close();
    }

    static int step13(char[][] m1, char[][] m2) {
        for (int i = 1; i < 4; i++) {
            m1 = rotate90(m1);
            if (isEqual(m1, m2))
                return i;
        }
        return -1;
    }

    static void reflection(char[][] m1) {
        int size = m1.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size / 2; j++) {
                char temp = m1[i][j];
                m1[i][j] = m1[i][size - 1 - j];
                m1[i][size - 1 - j] = temp;
            }
        }
    }

    static char[][] rotate90(char[][] m1) {
        int size = m1.length;
        char[][] temp = new char[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                temp[j][size - i - 1] = m1[i][j];

        return temp;
    }

    static boolean isEqual(char[][] m1, char[][] m2) {
        int size = m1.length;
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (m1[i][j] != m2[i][j])
                    return false;
        return true;
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