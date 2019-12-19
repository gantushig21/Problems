
/*
ID: gantush6
LANG: JAVA
TASK: maze1
*/

import java.io.*;
import java.util.*;
import java.lang.*;

public class maze1 {
    static int h, w;
    static char[][] map;
    static int x1 = -1, y1 = -1, x2 = -1, y2 = -1;
    static int[] xPlus = { -1, 0, 1, 0 }, yPlus = { 0, 1, 0, -1 };

    static void setStartFinishPositions(int x, int y) {
        if (x1 == -1) {
            x1 = x;
            y1 = y;
        } else {
            x2 = x;
            y2 = y;
        }
    }

    static class Pair {
        public int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("maze1.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("maze1.out")));

        w = input.nextInt();
        h = input.nextInt();
        map = new char[2 * h + 1][2 * w + 1];
        for (int i = 0; i <= 2 * h; i++)
            map[i] = input.nextLine().toCharArray();

        for (int i = 0; i < h; i++) {
            if (map[2 * i + 1][0] == ' ') {
                setStartFinishPositions(i, 0);
            }
            if (map[2 * i + 1][2 * w] == ' ') {
                setStartFinishPositions(i, w - 1);
            }
        }

        for (int j = 0; j < w; j++) {
            if (map[0][2 * j + 1] == ' ') {
                setStartFinishPositions(0, j);
            }
            if (map[2 * h][2 * j + 1] == ' ') {
                setStartFinishPositions(h - 1, j);
            }
        }

        int[][] used = new int[h][w];

        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(x1, y1));
        queue.add(new Pair(x2, y2));
        used[x1][y1] = 1;
        used[x2][y2] = 1;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            for (int i = 0; i < 4; i++) {
                int xx = pair.x + xPlus[i];
                int yy = pair.y + yPlus[i];
                if (0 <= xx && xx < h && 0 <= yy && yy < w && used[xx][yy] == 0
                        && map[2 * pair.x + 1 + xPlus[i]][2 * pair.y + 1 + yPlus[i]] == ' ') {
                    used[xx][yy] = used[pair.x][pair.y] + 1;
                    queue.add(new Pair(xx, yy));
                }
            }
        }

        int step = 0;
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
                step = Math.max(step, used[i][j]);

        output.println(step);

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