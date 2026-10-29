import java.io.*;
import java.util.*;

public class Main {
    static final long INF = 100_000_000_000L;

    static int N, M;
    static int A, B;
    static long[] dist;
    static List<Edge>[] graph;

    static class Edge {
        int to;
        long cost;

        public Edge(int to, long cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; ++i) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new Edge(to, cost));
            graph[to].add(new Edge(from, cost));
        }

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        dist = new long[N + 1];
        Arrays.fill(dist, INF);
        dist[A] = 0;

        dijkstra();

        System.out.print(dist[B]);
    }

    private static void dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> {
            return Long.compare(a.cost, b.cost);
        });

        pq.offer(new Edge(A, 0));
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            if (curr.cost > dist[curr.to]) continue;

            for (Edge next : graph[curr.to]) {
                if (dist[next.to] > dist[curr.to] + next.cost) {
                    dist[next.to] = dist[curr.to] + next.cost;
                    pq.offer(new Edge(next.to, dist[next.to]));
                }
            }
        }
    }
}