import java.util.*;
import java.io.*;
import java.lang.*;

// TLE

public class Trafficn {
    private static Reader input;
    private static PrintWriter output;

    public static void main(String[] args) throws FileNotFoundException, Exception {
        input = new Reader();
        output = new PrintWriter(System.out, true);

        int T = input.nextInt();
        for (int q = 0; q < T; q++) {
            int n = input.nextInt(), m = input.nextInt(), k = input.nextInt(), s = input.nextInt() - 1,
                    t = input.nextInt() - 1;
            List<List<Node>> fromS = new ArrayList<List<Node>>();
            List<List<Node>> fromV = new ArrayList<List<Node>>();

            for (int i = 0; i < n; i++) {
                fromS.add(new ArrayList<>());
                fromV.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                int u = input.nextInt() - 1, v = input.nextInt() - 1;
                long w = input.nextLong();
                fromS.get(u).add(new Node(v, w));
                fromV.get(v).add(new Node(u, w));
            }

            Dijkstra d1 = new Dijkstra(n);
            Dijkstra d2 = new Dijkstra(n);

            d1.shortestPath(fromS, s);
            // d1.print();
            d2.shortestPath(fromV, t);
            // d2.print();

            long min = d1.dist[t];
            for (int i = 0; i < k; i++) {
                int u = input.nextInt() - 1, v = input.nextInt() - 1;
                long w = input.nextLong();

                if (d1.dist[u] != Long.MAX_VALUE && d2.dist[v] != Long.MAX_VALUE) {
                    long distance = Math.min(d1.dist[u] + w + d2.dist[v], d1.dist[v] + w + d2.dist[u]);
                    min = Math.min(min, distance);
                }
            }

            if (min == Long.MAX_VALUE)
                output.println("-1");
            else {
                output.println(min);
            }
        }

        input.close();
    }
}

class Dijkstra {
    private Set<Integer> used;
    public long[] dist;
    private PriorityQueue<Node> queue;
    private int n;
    private List<List<Node>> map;

    public Dijkstra(int n) {
        this.n = n;
        used = new HashSet<>();
        dist = new long[n];
        queue = new PriorityQueue<>(n, new Node());
    }

    public void shortestPath(List<List<Node>> map, int start) {
        this.map = map;

        for (int i = 0; i < dist.length; i++)
            dist[i] = Long.MAX_VALUE;

        queue.add(new Node(start, 0));
        dist[start] = 0;
        while (used.size() != n && !queue.isEmpty()) {
            Node u = queue.poll();

            used.add(u.node);

            visitNeighbours(u.node);
        }
    }

    private void visitNeighbours(int u) {
        for (int i = 0; i < map.get(u).size(); i++) {
            Node v = map.get(u).get(i);

            if (!used.contains(v.node)) {
                if (dist[v.node] > dist[u] + v.weight)
                    dist[v.node] = dist[u] + v.weight;

                queue.add(new Node(v.node, dist[v.node]));
            }
        }
    }

    public void print() {
        for (int i = 0; i < n; i++)
            System.out.println(i + 1 + " => " + dist[i]);
        System.out.println();
    }
}

class Node implements Comparator<Node> {
    public int node;
    public long weight;

    public Node() {
    }

    public Node(int node, long weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public int compare(Node n1, Node n2) {
        if (n1.weight < n2.weight)
            return -1;
        if (n1.weight > n2.weight)
            return 1;
        return 0;
    }
}

/** Faster input **/
class Reader {
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Reader() {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public Reader(String file_name) throws IOException {
        din = new DataInputStream(new FileInputStream(file_name));
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public String readLine() throws IOException {
        byte[] buf = new byte[64]; // line length
        int cnt = 0, c;
        while ((c = read()) != -1) {
            if (c == '\n')
                break;
            buf[cnt++] = (byte) c;
        }
        return new String(buf, 0, cnt);
    }

    public int nextInt() throws IOException {
        int ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (neg)
            return -ret;
        return ret;
    }

    public long nextLong() throws IOException {
        long ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (neg)
            return -ret;
        return ret;
    }

    public double nextDouble() throws IOException {
        double ret = 0, div = 1;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (c == '.')
            while ((c = read()) >= '0' && c <= '9')
                ret += (c - '0') / (div *= 10);
        if (neg)
            return -ret;
        return ret;
    }

    private void fillBuffer() throws IOException {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1)
            buffer[0] = -1;
    }

    private byte read() throws IOException {
        if (bufferPointer == bytesRead)
            fillBuffer();
        return buffer[bufferPointer++];
    }

    public void close() throws IOException {
        if (din == null)
            return;
        din.close();
    }
}