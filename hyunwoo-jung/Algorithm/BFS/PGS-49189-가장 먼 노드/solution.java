import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        Queue<Integer> q = new ArrayDeque<>();
        int[] dist = new int[n + 1];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <=n; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        Arrays.fill(dist, -1);
        dist[1] = 0;
        q.offer(1);
        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int next : graph.get(curr)) {
                if (dist[next] == -1) {
                    dist[next] = dist[curr] + 1;
                    q.offer(next);
                }
            }
        }

        int maxDist = 1;
        for (int d : dist) {
            maxDist = Math.max(maxDist, d);
        }

        int answer = 0;
        for (int d : dist) {
            if (d == maxDist) ++answer;
        }

        return answer;
    }
}