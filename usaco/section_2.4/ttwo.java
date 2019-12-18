
/*
ID: gantush6
LANG: JAVA
TASK: ttwo
*/

import java.io.*;
import java.util.*;
import java.lang.*;

public class ttwo {
    static boolean onMap(int x, int y) {
        return 0 <= x && x < 10 && 0 <= y && y < 10;
    }

    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("ttwo.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("ttwo.out")));

        char[][] map = new char[10][10];
        int cowX = 0, cowY = 0, cowD = 0, farmerX = 0, farmerY = 0, farmerD = 0;
        for (int i = 0; i < 10; i++) {
            map[i] = input.next().toCharArray();
            for (int j = 0; j < 10; j++) {
                if (map[i][j] == 'F') {
                    farmerX = i;
                    farmerY = j;
                } else if (map[i][j] == 'C') {
                    cowX = i;
                    cowY = j;
                }
            }
        }

        boolean[][][] farmer = new boolean[10][10][4];
        boolean[][][] cow = new boolean[10][10][4];

        int[] x = { -1, 0, 1, 0 }, y = { 0, 1, 0, -1 };
        int minute = 0, fx, fy, cx, cy;
        // System.out.println(farmer[farmerX][farmerY][farmerD] + " " +
        // cow[cowX][cowY][cowD]);
        while (minute < 160000) {
            farmer[farmerX][farmerY][farmerD] = true;
            cow[cowX][cowY][cowD] = true;

            minute++;
            fx = farmerX + x[farmerD];
            fy = farmerY + y[farmerD];

            cx = cowX + x[cowD];
            cy = cowY + y[cowD];

            if (onMap(fx, fy) && map[fx][fy] != '*') {
                farmerX = fx;
                farmerY = fy;
            } else {
                farmerD = (farmerD + 1) % 4;
            }

            if (onMap(cx, cy) && map[cx][cy] != '*') {
                cowX = cx;
                cowY = cy;
            } else {
                cowD = (cowD + 1) % 4;
            }

            if (farmerX == cowX && farmerY == cowY)
                break;
        }
        if (farmerX == cowX && farmerY == cowY)
            output.println(minute);
        else
            output.println("0");

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