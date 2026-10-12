class Edge{
    String to;
    double value;
    Edge(String to , double value){
        this.to = to;
        this.value = value;
    }
}


class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Edge>> graph = new HashMap<>();

        for(int i = 0; i < equations.size(); i++){
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];

            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());

            graph.get(u).add(new Edge(v, val));
            graph.get(v).add(new Edge(u, 1.0 / val));
        }
        double[] result = new double[queries.size()];
        for(int i = 0; i < queries.size() ; i ++) {
            String u = queries.get(i).get(0);
            String v = queries.get(i).get(1);
            if (!graph.containsKey(u) || !graph.containsKey(v)) {
                result[i] = -1.0;
            }else{
                Set<String> visited = new HashSet<>();
                double a = dfs(graph, u, v, visited);
                result[i] = a;
            }
        }
        return result;
    }


    double dfs(Map<String, List<Edge>> graph, String current, String target, Set<String> visited){

        if(current.equals(target)) return 1.0;
        // 방문 처리
        visited.add(current);
        for(Edge edge : graph.get(current)){
            if(!visited.contains(edge.to)){
                double result = dfs(graph,edge.to ,target,visited);

                if(result != -1.0){
                    return edge.value*result;
                }
            }
        }
        return -1.0;

        
        

        
    }

}
