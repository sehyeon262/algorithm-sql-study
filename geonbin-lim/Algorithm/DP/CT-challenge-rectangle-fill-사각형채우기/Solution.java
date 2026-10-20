import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        dp[1] = 1;
        if(n>1) dp[2] = 2;
        if(n>2) {
            for(int i = 3; i<=n; i++){
                dp[i] = (dp[i-1] + dp[i-2])%10007;
            }
        }
        System.out.print(dp[n]);
        // Please write your code here.
    }
}


// dp[1] = 1
// dp[2] = 2 // 세로 2개 가로 2개 근데 그건 상관없이 여튼 사각형이 만들어진 상태임
// dp[3] = dp[2]에 세로로 하나 붙인거 dp[1] 에 가로로 2개 붙인거

// 따라서 dp[i] = dp[i-1] + dp[i-2];
