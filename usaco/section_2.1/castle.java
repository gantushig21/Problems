
/*
ID: gantush6
LANG: JAVA
TASK: castle
*/

import java.io.*;
import java.util.*;

public class castle {
    static int[] xPlus = { 0, -1, 0, 1 };
    static int[] yPlus = { -1, 0, 1, 0 };
    static int rooms = 0, n, m, count;
    static List<Integer> areas = new ArrayList<>();
    static int[][] walls;
    static int[][] map;

    static boolean isAvailable(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m && map[x][y] == 0;
    }

    static void DFS(int x, int y) {
        map[x][y] = rooms;
        count++;

        for (int i = 0; i < 4; i++) {
            int value = (1 << i) & walls[x][y];
            if (value == 0) {
                if (isAvailable(x + xPlus[i], y + yPlus[i]))
                    DFS(x + xPlus[i], y + yPlus[i]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("castle.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));

        m = input.nextInt();
        n = input.nextInt();
        walls = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                walls[i][j] = input.nextInt();

        int maxArea = 0;

        map = new int[n][m];
        areas.add(0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    rooms++;
                    count = 0;
                    DFS(i, j);
                    areas.add(count);
                    maxArea = Math.max(maxArea, count);
                }
            }
        }

        // for (int i = 0; i < n; i++)
        // output.println(Arrays.toString(map[i]));

        int doubleMax = 0;
        int xCoordinate = 0, yCoordinate = 0;
        char direction = 'N';
        for (int j = 0; j < m; j++) {
            for (int i = n - 1; i >= 0; i--) {
                if (0 <= i - 1 && map[i][j] != map[i - 1][j]) {
                    int area = areas.get(map[i][j]) + areas.get(map[i - 1][j]);
                    if (area > doubleMax) {
                        doubleMax = area;
                        xCoordinate = i + 1;
                        yCoordinate = j + 1;
                        direction = 'N';
                    }
                }
                if (j + 1 < m && map[i][j] != map[i][j + 1]) {
                    int area = areas.get(map[i][j]) + areas.get(map[i][j + 1]);
                    if (area > doubleMax) {
                        doubleMax = area;
                        xCoordinate = i + 1;
                        yCoordinate = j + 1;
                        direction = 'E';
                    }
                }
            }
        }
        output.println(rooms + "\n" + maxArea + "\n" + doubleMax);
        output.println(xCoordinate + " " + yCoordinate + " " + direction);

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