from collections import deque

n, m = map(int, input().split())
a = [list(map(int, input().split())) for _ in range(n)]
visited = [[0] * m for _ in range(n)]

def bfs():
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    while q:
        x, y = q.popleft()

        if x == n - 1 and y == m - 1:
            return 1

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny] and a[nx][ny] == 1:
                visited[nx][ny] = 1
                q.append((nx, ny))
        
    return 0
                

q = deque([(0, 0)])
visited[0][0] = 1
print(bfs())
