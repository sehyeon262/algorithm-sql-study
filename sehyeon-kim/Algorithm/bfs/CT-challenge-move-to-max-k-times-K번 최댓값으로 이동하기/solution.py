from collections import deque

n, k = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]
r, c = map(int, input().split())

def bfs(start_x, start_y):
    start_num = grid[start_x][start_y]

    q = deque([(start_x, start_y)])
    visited = [[0] * n for _ in range(n)]
    visited[start_x][start_y] = 1
    candidates = []

    while q:
        x, y = q.popleft()
            
        # 상 하 좌 우
        dx = [-1, 1, 0, 0]
        dy = [0, 0, -1, 1]

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < n and grid[nx][ny] < start_num and not visited[nx][ny]:
                q.append((nx, ny))
                visited[nx][ny] = 1
                candidates.append((grid[nx][ny], nx, ny))
                
    return candidates


for _ in range(k):
    candidates = bfs(r - 1, c - 1)
    
    if not candidates:
        break

    candidates.sort(key=lambda x: (-x[0], x[1], x[2]))

    res_val, res_x, res_y = candidates[0]
    r, c = res_x + 1, res_y + 1

print(r, c)
