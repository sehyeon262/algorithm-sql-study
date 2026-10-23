import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];

        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
                
        // Please write your code here.
        boolean[][] isVisited = new boolean[n][n];
        int result = 0;

        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < n; j++){
                if(grid[i][j]==1&&!isVisited[i][j]){
                    result++;
                    subResult = 1;
                    isVisited[i][j] = true;
                    dfs(grid,isVisited,i,j,n);
                    pq.add(subResult);
                }
            }
        }
        sb.append(result).append("\n");
        while(!pq.isEmpty()){
            sb.append(pq.poll()).append("\n");
        }

        System.out.print(sb);
    }


    static int subResult = 0;
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};

    static void dfs(int[][] grid, boolean[][] isVisited, int r, int c, int n){

        for(int i = 0; i < 4; i++){
            int rr = r + dr[i];
            int cc = c + dc[i];
            if(rr<0||cc<0||rr>=n||cc>=n||grid[rr][cc]==0||isVisited[rr][cc]) continue;
            subResult++;
            isVisited[rr][cc] = true;
            dfs(grid,isVisited,rr,cc,n);
        }
    }
}
