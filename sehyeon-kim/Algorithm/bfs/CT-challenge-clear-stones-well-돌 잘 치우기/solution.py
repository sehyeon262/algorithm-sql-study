from collections import deque
from itertools import combinations
import copy

# 격자 크기, 시작점의 수, 꼭 치워야 할 돌 개수
n, k, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

# 시작점의 위치 (r:행, c:열)
starts = []
for _ in range(k):
    r, c = map(int, input().split())
    starts.append((r - 1, c - 1))


def bfs(x, y):
    global cnt
    
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    
    q = deque([(x, y)])
    visited[x][y] = 1
    
    while q:
        x, y = q.popleft()
        cnt += 1

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny] and new_grid[nx][ny] == 0:
                q.append((nx, ny))
                visited[nx][ny] = 1

    return cnt


answer = -10000
stones = []
for i in range(n):
    for j in range(n):
        if grid[i][j] == 1:
            stones.append((i, j))

for removed in combinations(stones, m):
    new_grid = copy.deepcopy(grid)
    for a, b in removed:
        new_grid[a][b] = 0
    
    visited = [[0] * n for _ in range(n)]
    cnt = 0

    for x, y in starts:
        if not visited[x][y]:
            bfs(x, y)
    answer = max(answer, cnt)
          
print(answer)
