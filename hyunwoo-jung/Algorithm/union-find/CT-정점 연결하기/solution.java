import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        for (int i = 1; i <= N; ++i) parent[i] = i;

        for (int i = 0; i < N - 2; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        int answerB = 0;
        int p1 = find(1);
        for (int i = 2; i <= N; ++i) {
            if (find(i) != p1) {
                answerB = i;
                break;
            }
        }

        System.out.print(1 + " " + answerB);
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