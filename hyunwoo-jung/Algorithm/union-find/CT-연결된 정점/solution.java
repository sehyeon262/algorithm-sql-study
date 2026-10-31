import java.io.*;
import java.util.*;

public class solution {
    static int N, M;
    static int[] parent;
    static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        size = new int[N + 1];
        for (int i = 1; i <= N; ++i) {
            parent[i] = i;
            size[i] = 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            char cmd = st.nextToken().charAt(0);
            
            if (cmd == 'x') {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            } else {
                int a = Integer.parseInt(st.nextToken());

                int pa = find(a);
                sb.append(size[pa]).append('\n');
            }
        }

        System.out.print(sb.toString());
    }

    private static int find(int x) {
        if (parent[x] != x) return parent[x] = find(parent[x]);

        return parent[x];
    }

    private static boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) return false;

        if (size[pa] < size[pb]) {
            int tmp = pb;
            pb = pa;
            pa = tmp;
        }

        parent[pb] = pa;
        size[pa] += size[pb];
        return true;
    }
}