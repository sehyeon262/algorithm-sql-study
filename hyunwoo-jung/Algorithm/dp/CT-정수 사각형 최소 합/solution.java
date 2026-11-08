import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; ++i) {
            for (int j = N - 1; j >= 0; --j) {
                if (i == 1 && j == N - 1) {
                    dp[i][j] = map[i][j];
                } else if (i == 1) {
                    dp[i][j] = map[i][j] + dp[i][j + 1];
                } else if (j == N - 1) {
                    dp[i][j] = map[i][j] + dp[i - 1][j];
                } else {
                    dp[i][j] = map[i][j] + Math.min(dp[i - 1][j], dp[i][j + 1]);
                }
            }
        }

        System.out.print(dp[N][0]);
    }
}