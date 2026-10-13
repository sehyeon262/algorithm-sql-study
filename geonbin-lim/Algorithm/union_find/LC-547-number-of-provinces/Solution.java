class Solution {

    static int[] parent;
    
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parent = new int[n];
        for (int i = 0; i < parent.length; i++) parent[i] = i;
        Set<Integer> set = new HashSet<>();
        boolean[] checkP = new boolean[n];
        for(int i = 0 ; i < n ; i ++){
            for (int j = 0; j < n ; j++) {
                if(isConnected[i][j] == 1) {
                    union(i,j);
                }
            }
        }
        for(int i = 0; i< n; i++) set.add(find(i));
        return set.size();
    }

    public static boolean union(int x, int y){
        x = find(x);
        y = find(y);

        if(x==y) return false;

        if(x<=y) parent[y] = x;
        else parent[x] = y;
        return true;
    }

    public static int find(int x){
        if(parent[x]==x) return x;
        return parent[x] = find(parent[x]);
    }
}

