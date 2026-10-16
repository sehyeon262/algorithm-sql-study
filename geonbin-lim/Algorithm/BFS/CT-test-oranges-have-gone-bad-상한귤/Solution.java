import java.util.*;

class Point{
    int r ;
    int c ;
    int time ;
    Point(int r, int c, int time){
        this.r = r ;
        this.c = c ;
        this.time =time;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] grid = new int[n][n];
        int[][] cnt = new int[n][n];
        ArrayDeque<Point> q = new ArrayDeque<>();
        boolean[][] isVisited = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++){
                grid[i][j] = sc.nextInt();
                if(grid[i][j]==2) {
                    q.add(new Point(i,j,0));
                    isVisited[i][j] = true;
                    cnt[i][j] = 0;
                }
                if(grid[i][j]==0) { 
                    isVisited[i][j] = true; // 사실상 못가니까 방문처리를 해도 될듯
                    cnt[i][j] = -1; // 나중에 순회하면서 cnt[i][j] 가 0인걸 -2로 바꾸기
                }
            }
        // Please write your code here.

        bfs(grid,q,isVisited,n,cnt);
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j]==1&&cnt[i][j]==0) System.out.print("-2 ");
                else System.out.print(cnt[i][j]+" ");
            }
            System.out.println();
        }

    }

    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};

    static void bfs(int[][] grid, ArrayDeque<Point> q, boolean[][] isVisited,int n,int[][] cnt){
        while(!q.isEmpty()){
            Point pt = q.poll();
            for(int i =0; i<4; i++){
                int r = pt.r + dr[i];
                int c = pt.c + dc[i];
                if(r<0||c<0||r>=n||c>=n||grid[r][c]==2||grid[r][c]==0) continue;
                if(isVisited[r][c]) continue;
                isVisited[r][c] = true ; 
                cnt[r][c] = pt.time + 1;
                q.add(new Point(r,c,pt.time+1));
            }
        }
    }
}
