import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] scores;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        scores = new int[301];
        dp = new int[301];

        for (int i = 1; i <= N; ++i) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = scores[1];
        dp[2] = scores[1] + scores[2];
        dp[3] = scores[3] + Math.max(scores[1], scores[2]);

        for (int i = 4; i <= N; ++i) {
            dp[i] = Math.max(dp[i - 2] + scores[i], dp[i - 3] + scores[i - 1] + scores[i]);
        }

        System.out.print(dp[N]);
    }
}
