import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.
        boolean[][] isVisited = new boolean[n][m];
        isVisited[0][0] = true;
        dfs(grid,n,m,0,0,isVisited);

        System.out.print(result);
    }

    static int[] dr = {1,0};
    static int[] dc = {0,1};

    static int result = 0;

    static void dfs(int[][] grid, int n, int m ,int r, int c, boolean[][] isVisited){

        if(r==n-1&&c==m-1) result = 1;

        for(int i = 0; i<2; i++){
            int rr = r +dr[i];
            int cc = c +dc[i];

            if(rr<0||cc<0||rr>=n||cc>=m||grid[rr][cc]==0||isVisited[rr][cc]) continue;
            isVisited[rr][cc] = true;
            dfs(grid,n,m,rr,cc,isVisited);

        }
    }
}
