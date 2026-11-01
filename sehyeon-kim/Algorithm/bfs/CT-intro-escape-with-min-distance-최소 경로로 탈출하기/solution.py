from collections import deque

n, m = map(int, input().split())
a = [list(map(int, input().split())) for _ in range(n)]
visited = [[0] * m for _ in range(n)]
q = deque([(0, 0, 0)])
visited[0][0] = 1

def bfs():
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    while q:
        x, y, dist = q.popleft()
        
        if x == n - 1 and y == m - 1:
            return dist

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < m and a[nx][ny] == 1 and not visited[nx][ny]:
                visited[nx][ny] = 1
                q.append((nx, ny, dist + 1))
    
    return -1

print(bfs())
