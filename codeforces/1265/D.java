import java.util.*;
import java.io.*;

public class D {
    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(System.in);
        PrintWriter output = new PrintWriter(System.out);

        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        int d = input.nextInt();

        int one = b - a;
        int two = c - d;
        int[] numbers = new int[a + b + c + d];
        int size = 0;
        boolean solved = true;
        if (a <= b && c >= d && (one == two || one + 1 == two || one == two + 1)) {
            if (one > two)
                numbers[size++] = 1;
            for (int i = 0; i < a; i++) {
                numbers[size++] = 0;
                numbers[size++] = 1;
            }
            for (int i = 0; i < Math.min(one, two); i++) {
                numbers[size++] = 2;
                numbers[size++] = 1;
            }
            for (int i = 0; i < d; i++) {
                numbers[size++] = 2;
                numbers[size++] = 3;
            }
            if (one < two)
                numbers[size++] = 2;

        } else if (a == b && a == 0 && c + 1 == d) {
            numbers[size++] = 3;

            for (int i = 0; i < c; i++) {
                numbers[size++] = 2;
                numbers[size++] = 3;
            }
        } else if (a == b + 1 && c == d && c == 0) {
            numbers[size++] = 0;

            for (int i = 0; i < b; i++) {
                numbers[size++] = 1;
                numbers[size++] = 0;
            }
        } else {
            solved = false;
        }

        if (solved) {
            output.print("YES\n" + numbers[0]);
            for (int i = 1; i < size; i++)
                output.print(" " + numbers[i]);
            
            output.println();   
        } else {
            output.println("NO");
    
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