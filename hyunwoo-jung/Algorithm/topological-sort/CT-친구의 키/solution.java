import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] indegree;
    static List<Integer>[] graph;
    static Deque<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        indegree = new int[n + 1];

        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; ++i) graph[i] = new ArrayList<>();

        q = new ArrayDeque<>();

        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ++indegree[b];
            graph[a].add(b);
        }

        System.out.print(topologicalSort());
    }

    private static String topologicalSort() {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; ++i) {
            if (indegree[i] == 0) {
                q.offer(i);
                sb.append(i).append(' ');
            }
        }

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int next : graph[curr]) {
                if (--indegree[next] == 0) {
                    q.offer(next);
                    sb.append(next).append(' ');
                }
            }
        }

        return sb.toString();
    }
}