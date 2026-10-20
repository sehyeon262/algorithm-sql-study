import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] graph = new int[n+1][n+1];
        boolean[] isVisited = new boolean[n+1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        isVisited[1] = true;
        dfs(graph,isVisited,1);
        // Please write your code here.
        System.out.print(result);
    }

    static int result = 0;

    static void dfs(int[][] graph,boolean[] isVisited,int vertex){
        for(int i=1;i<graph.length;i++){
            if(vertex==i) continue;
            if(graph[vertex][i]==1 && isVisited[i]==false){
                isVisited[i] = true;
                result++;
                dfs(graph,isVisited,i);
            }
        }




    }
}   
