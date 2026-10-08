class Edge {
    int to;
    int cost;
    Edge(int to, int cost){
        this.to = to;
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
        return Long.compare(this.cost, o.cost);
    }
}


class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] time : times) {
            int u = time[0]; 
            int v = time[1]; 
            int w = time[2]; 
            graph.get(u).add(new Edge(v, w));
        }

        long[] distance = new long[n+1];
        Arrays.fill(distance, Long.MAX_VALUE);
        PriorityQueue<State> pq = new PriorityQueue<>();
        distance[k] = 0;
        pq.add(new State(k,0));

        while(!pq.isEmpty()){
            State cur = pq.poll();
            if(cur.cost != distance[cur.node]) continue;

            for(Edge edge : graph.get(cur.node)){
                long nextDist = distance[cur.node] + edge.cost;
                
                if (nextDist < distance[edge.to]) {
                    distance[edge.to] = nextDist;
                    pq.add(new State(edge.to, nextDist));
                }
            }
        }
        long maxTime = 0;
        for (int i = 1; i <= n; i++) {
            // 무한대 값이 남아있다면 도달 불가능한 노드가 있다는 뜻
            if (distance[i] == Long.MAX_VALUE) {
                return -1; 
            }
            maxTime = Math.max(maxTime, distance[i]);
        }
        
        return (int) maxTime;
    }
}
