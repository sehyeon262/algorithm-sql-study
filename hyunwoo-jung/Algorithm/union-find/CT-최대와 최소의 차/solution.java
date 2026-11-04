import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] parent;
    static int[][] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for (int i = 1; i <= N; ++i) parent[i] = i;

        edges = new int[M][3];
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int type = Integer.parseInt(st.nextToken());

            edges[i][0] = a;
            edges[i][1] = b;
            edges[i][2] = type;
        }
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        int conn = 0;
        int count = 0;
        int maxTotal = 0;
        for (int[] edge : edges) {
            if (union(edge[0], edge[1])) {
                ++conn;

                if (edge[2] == 0) ++count;
            }

            if (conn == N - 1) break;
        }
        maxTotal = count * count;

        int minTotal = 0;
        for (int i = 1; i <= N; ++i) parent[i] = i;
        conn = 0;
        count = 0;
        Arrays.sort(edges, (a, b) -> Integer.compare(b[2], a[2]));
        for (int[] edge : edges) {
            if (union(edge[0], edge[1])) {
                ++conn;

                if (edge[2] == 0) ++count;
            }

            if (conn == N - 1) break;
        }

        minTotal = count * count;

        System.out.print(maxTotal - minTotal);
    }

    private static int find(int x) {
        if (parent[x] != x) return parent[x] = find(parent[x]);

        return parent[x];
    }

    private static boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb) return false;

        parent[pb] = pa;

        return true;
    }
}