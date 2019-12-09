import java.util.*;
import java.io.*;

public class C {
    static int firstOccurence(int[] arr, int low, int high, int target) {
        int result = -1;
        while (low <= high) {
            int middle = (low + high) / 2;

            if (target == arr[middle]) {
                result = middle;
                high = middle - 1;
            } else if (target > arr[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        return result;
    }

    static int lastOccurance(int[] arr, int low, int high, int target) {
        int result = -1;

        while (low <= high) {
            int middle = (low + high) / 2;

            if (target == arr[middle]) {
                result = middle;
                low = middle + 1;
            } else if (target > arr[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(System.in);
        PrintWriter output = new PrintWriter(System.out);

        int t = input.nextInt();
        int[] p = new int[400000];
        for (int q = 0; q < t; q++) {
            int n = input.nextInt();
            for (int i = 0; i < n; i++)
                p[i] = input.nextInt();

            int g = 0, s = 0, b = 0;
            if (n > 9) {
                int bronze = n / 2 - 1;
                int bronzeRight = lastOccurance(p, 0, n - 1, p[bronze]);
                if (bronzeRight != bronze) {
                    bronzeRight = firstOccurence(p, 0, n - 1, p[bronze]) - 1;
                }

                if (bronzeRight > 0) {
                    int goldRight = lastOccurance(p, 0, n - 1, p[0]);

                    int bronzeLeft = firstOccurence(p, 0, n - 1, p[bronzeRight]);
                    while (bronzeLeft > 0 && bronzeRight - bronzeLeft <= goldRight) {
                        bronzeLeft = firstOccurence(p, 0, n - 1, p[bronzeLeft - 1]);
                    }

                    g = goldRight + 1;
                    s = bronzeLeft - goldRight - 1;
                    b = bronzeRight - bronzeLeft + 1;
                    if (g >= s || g >= b) {
                        g = s = b = 0;
                    }
                }
            }
            System.out.println(g + " " + s + " " + b);
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