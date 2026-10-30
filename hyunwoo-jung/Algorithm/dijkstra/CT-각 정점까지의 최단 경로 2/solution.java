import java.io.*;
import java.util.*;

public class Main {
    static final long INF = 100_000_000_000L;
    
    static int N, M;
    static long[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new long[N + 1][N + 1];
        for (int i = 1; i <= N; ++i) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());

            dist[from][to] = Math.min(dist[from][to], cost);
        }

        floyd();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= N; ++j) {
                if (dist[i][j] == INF) sb.append(-1).append(' ');
                else sb.append(dist[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }

    private static void floyd() {
        for (int k = 1; k <= N; ++k) {
            for (int i = 1; i <= N; ++i) {
                for (int j = 1; j <= N; ++j) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
    }
}
