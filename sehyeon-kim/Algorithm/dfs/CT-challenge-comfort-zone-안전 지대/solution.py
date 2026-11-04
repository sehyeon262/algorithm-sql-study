# K이하인 칸은 무시 
# K초과인 칸 중에서 상하좌우로 인접한 칸은 하나의 칸으로 간주 -> 안전 영역
# 안전 영역의 수가 최대가 될 때의 K와 그때의 안전 영역의 수는?
# ※ 안전 영역의 수의 최댓값이 0인 경우 -> 0 1 출력!!
import sys
sys.setrecursionlimit(10**6)

n, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

def dfs(x, y, k):
    # 방문 표시한다
    visited[x][y] = 1

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny] and grid[nx][ny] > k:
            dfs(nx, ny, k)

    return 1

answer = 0
answer_k = 1

max_h = max(max(row) for row in grid)

for k in range(1, max_h + 1):
    visited = [[0] * m for _ in range(n)]
    cnt = 0

    for i in range(n):
        for j in range(m):
            if not visited[i][j] and grid[i][j] > k:
                cnt += dfs(i, j, k)
    
    if cnt > answer:
        answer = cnt
        answer_k = k

print(answer_k, answer)
