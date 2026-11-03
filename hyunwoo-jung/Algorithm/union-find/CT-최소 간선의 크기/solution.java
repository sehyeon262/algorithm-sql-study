import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int A, B;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for (int i = 1; i <= N; ++i) parent[i] = i;

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        
        int[][] edges = new int[M][3];
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges[i][0] = from;
            edges[i][1] = to;
            edges[i][2] = cost;
        }
        Arrays.sort(edges, (a, b) -> Integer.compare(b[2], a[2]));

        int answer = 0;
        for (int[] edge : edges) {
            union(edge[0], edge[1]);

            if (find(A) == find(B)) {
                answer = edge[2];
                break;
            }
        }

        System.out.print(answer);
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