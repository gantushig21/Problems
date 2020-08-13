
/*
ID: gantush6
LANG: JAVA
TASK: spin
*/

import java.io.*;
import java.util.*;

public class spin {
    static class Wheel {
        public int speed;
        public int[] cuts;
        public boolean[] empty;
        public boolean[] e;

        public Wheel(int speed, int size) {
            this.speed = speed;
            cuts = new int[size];
            empty = new boolean[360];
            e = new boolean[360];
        }
    }
    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("spin.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("spin.out")));

        Wheel[] wheels = new Wheel[5];
        for (int i = 0; i < 5; i++) {
            int speed = input.nextInt();
            int size = input.nextInt() * 2;
            wheels[i] = new Wheel(speed, size);
            for (int j = 0; j < size; j++)
                wheels[i].cuts[j] = input.nextInt();
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < wheels[i].cuts.length; j += 2) {
                for (int d = 0; d <= wheels[i].cuts[j + 1]; d++)
                    wheels[i].empty[(wheels[i].cuts[j] + d) % 360] = true;
            }
        }

        boolean none = true;
        mainLoop: for (int seconds = 0; seconds < 360; seconds++) {
            for (int i = 0; i < 5; i++) {
                for (int degree = 0; degree < 360; degree++) {
                    int position = (degree + wheels[i].speed * seconds) % 360;
                    wheels[i].e[position] = wheels[i].empty[degree];
                }
            }
            for (int degree = 0; degree < 360; degree++) {
                boolean light = true;
                for (int i = 0; i < 5; i++)
                    light &= wheels[i].e[degree];

                if (light) {
                    output.println(seconds);
                    none = false;
                    break mainLoop;
                }
            }
        }
        if (none)
            output.println("none");

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