import java.util.*;
import java.io.*;
import java.lang.*;

// TLE

public class Trafficn {
    public static void main(String[] args) throws FileNotFoundException, Exception {
        FastScanner input = new FastScanner(System.in);
        PrintWriter output = new PrintWriter(System.out);

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
