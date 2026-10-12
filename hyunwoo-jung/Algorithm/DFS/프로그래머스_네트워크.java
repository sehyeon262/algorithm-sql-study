package DFS;

public class 프로그래머스_네트워크 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(3, new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        }));

        System.out.println(sol.solution(3, new int[][]{
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
        }));

        System.out.println(sol.solution(3, new int[][]{
                {1, 0, 1},
                {0, 1, 1},
                {1, 1, 1}
        }));
    }

    static class Solution {
        public int solution(int n, int[][] computers) {
            boolean[] visited = new boolean[n];
            int answer = 0;

            for (int i = 0; i < n; i++) {
                // 방문하지 않았다면 dfs 진입, 새로운 네트워크 발견한 거임.
                if (!visited[i]) {
                    dfs(i, n, computers, visited);
                    ++answer;
                }
            }

            return answer;
        }

        private void dfs(int node, int n, int[][] computers, boolean[] visited) {
            // node를 방문 처리하고, 연결된 컴퓨터 중 방문하지 않은 곳으로 이동
            // 자기자신은 첫 줄에서 방문처리하므로 반복문에서 통과됨
            visited[node] = true;

            for (int i = 0; i < n; ++i) {
                if (computers[node][i] == 1 && !visited[i]) {
                    dfs(i, n, computers, visited);
                }
            }
        }
    }
}

