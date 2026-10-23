# 상 하 좌 우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def dfs(x, y, arr):
    
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        
        if 0 <= nx < 16 and 0 <= ny < 16 and arr[nx][ny] != 1:
            if arr[nx][ny] == 0:
                arr[nx][ny] = 1
                
                if dfs(nx, ny, arr) == 1:
                    return 1
            else :
                return 1
    return 0

for _ in range(10):
    tc = int(input())
    arr = [list(map(int, input())) for _ in range(16)]

    # 시작점(1, 1) 방문 처리 한 뒤 시작 
    arr[1][1] = 1
    res = dfs(1, 1, arr)
    print(f'#{tc} {res}')
