class Edge{
    int to;
    int cost;
    Edge(int to, int cost){
        this.to = to ;
        this.cost = cost;
    }
}
class State implements Comparable<State>{
    int node;
    long cost;
    State(int node, long cost){
        this.node = node;
        this.cost = cost;
    }

    public int compareTo(State o){
        return Long.compare(this.cost,o.cost);
    }
}

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<Edge>> graph = new ArrayList<>();
        for(int i = 0; i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph.get(u).add(new Edge(v,w));
            graph.get(v).add(new Edge(u,w)); // 양방향 이니까 
        }

        long[][] distance = new long[n][n] ; // 모든 노드에서 임의의 모든 노드까지의 최단 경로를 알아야 풀리는 문제
        for(int i = 0 ; i<n; i++){
            Arrays.fill(distance[i], Long.MAX_VALUE);
        }
     

        for(int i = 0 ; i < n; i++){
            PriorityQueue<State> pq = new PriorityQueue<>();
            distance[i][i] = 0;
            pq.add(new State(i,0));
            while(!pq.isEmpty()){
                State cur = pq.poll();
                if(cur.cost != distance[i][cur.node]) continue;

                for(Edge edge : graph.get(cur.node)){
                    long nextDist = distance[i][cur.node] + edge.cost;
                    if(nextDist<distance[i][edge.to]){
                        distance[i][edge.to] = nextDist;
                        pq.add(new State(edge.to,nextDist));
                    }
                }
            }
        }

        int result = -1;
        int resultCost = Integer.MAX_VALUE; // 노드 result의 distanceThreshold 값
        for(int i = 0 ; i < n ; i++){
            int cnt = 0; // dT 개수 세기
            for(int j = 0; j <n ; j++){
                if(i==j) continue;
                if(distance[i][j] <= distanceThreshold) cnt ++;
            }
            if(resultCost >= cnt) {
                System.out.println(result + " " + resultCost);
                result = i;
                resultCost = cnt;
            }
        }

        return result;

    }
}
