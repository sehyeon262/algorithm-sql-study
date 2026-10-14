import java.util.*;

class Point{
    int r ;
    int c ;
    int time;
    Point(int r, int c, int time){
        this.r = r;
        this.c = c;
        this.time = time;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] grid = new int[n][n];
        List<Point> walls = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if(grid[i][j]==1){
                    walls.add(new Point(i,j,0));
                }
            }
        }
        int r1 = sc.nextInt()-1;
        int c1 = sc.nextInt()-1;
        int r2 = sc.nextInt()-1;
        int c2 = sc.nextInt()-1;
        

        combination(0,0,n,k,grid,walls,r1,c1,r2,c2);
        // Please write your code here.

        if(min==Integer.MAX_VALUE){
            System.out.println("-1");
        }else{
            System.out.println(min);
        }

    }

    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};

    static int min = Integer.MAX_VALUE;

    static void combination(int idx, int count, int n, int k, int[][] grid, List<Point> walls, int r1, int c1, int r2, int c2){
        if(count == k ){
            bfs(n, grid, r1, c1, r2, c2);
            return;
        }

        if(idx == walls.size()){
            return;
        }

        Point p = walls.get(idx);
        grid[p.r][p.c] = 0;
        combination(idx+1,count+1,n,k,grid,walls,r1,c1,r2,c2);
        grid[p.r][p.c] = 1;

        combination(idx + 1, count, n , k , grid, walls, r1, c1, r2 ,c2);
    }

    static void bfs(int n , int[][] grid, int r1, int c1, int r2, int c2){
        ArrayDeque<Point> q = new ArrayDeque<>();
        boolean[][] isVisited = new boolean[n][n];

        q.add(new Point(r1,c1,0));
        isVisited[r1][c1] = true;

        while(!q.isEmpty()){
            Point pt = q.poll();

            if(pt.r==r2&&pt.c==c2){
                min = Math.min(min,pt.time);
                return;
            }

            for(int i = 0; i<4;i++){
                int r = pt.r + dr[i];
                int c = pt.c + dc[i];

                if(r<0||c<0||r>=n||c>=n||grid[r][c]==1) continue;
                if(isVisited[r][c]) continue;
                isVisited[r][c] = true;

                q.add(new Point(r,c,pt.time+1));
            }
        }
    }
}
