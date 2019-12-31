
/*
ID: gantush6
LANG: JAVA
TASK: contact
*/

import java.io.*;
import java.util.*;
import java.lang.*;

public class contact {
    static int BIT_SIZE = 12;
    static int SIZE = 1 << 13;
    static Node[] list = new Node[SIZE];

    static class Node implements Comparable<Node> {
        public int value, count;

        public Node(int value, int count) {
            this.value = value;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            if (count < o.count)
                return 1;

            if (count > o.count)
                return -1;

            return 0;
        }
    }

    static void printBit(int number, PrintWriter output) {
        if (number == 1)
            return;

        printBit(number >> 1, output);
        output.print(number & 1);
    }

    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new FileReader("contact.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("contact.out")));

        int A = input.nextInt(), B = input.nextInt(), N = input.nextInt();
        StringBuilder sb = new StringBuilder();
        String line = input.next();
        while (line != null) {
            sb.append(line);
            line = input.next();
        }

        char[] ch = sb.toString().toCharArray();
        int bits = 0;
        int nbit = 0;
        for (int i = 0; i < list.length; i++)
            list[i] = new Node(i, 0);

        for (int i = 0; i < ch.length; i++) {
            bits <<= 1;
            if (ch[i] == '1')
                bits |= 1;

            if (nbit < B)
                nbit++;

            for (int j = A; j <= nbit; j++) {
                int temp = bits & ((1 << j) - 1);
                temp |= 1 << j;
                list[temp].count++;
            }
        }
        Arrays.sort(list);
        int j = 0;
        for (int i = 0; i < N; i++) {
            if (list[j].count == 0)
                break;

            int c = list[j].count;
            output.println(c);
            String sep = "";
            for (int k = 0; list[j].count == c; j++, k++) {
                output.print(sep);
                printBit(list[j].value, output);
                if (k % 6 == 5)
                    sep = "\n";
                else
                    sep = " ";
            }
            output.println();
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