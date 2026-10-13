board = [list(map(int, input().split())) for _ in range(19)]

row = len(board)
col = len(board[0])

def check(x, y, num):
    # 상, 오른쪽 위 대각선, 우, 오른쪽 아래 대각선
    dx = [-1, -1, 0, 1]
    dy = [0, 1, 1, 1]

    for i in range(4):
        cnt = 1
        for j in range(1, 5):
            nx = dx[i] * j + x
            ny = dy[i] * j + y
            if 0 <= nx < row and 0 <= ny < col:
                if board[nx][ny] == num:
                    cnt += 1
                else:
                    break

        if cnt == 5:
            return (x + dx[i] * 2, y + dy[i] * 2)

    return 0 


winner = 0
for x in range(row):
    for y in range(col):
        if board[x][y]:
            res = check(x, y, board[x][y])
            if res:
                a, b = res
                print(board[x][y])
                print(a + 1, b + 1)
                winner = board[x][y]
                break
    # 승자가 이미 정해졌으면 종료
    if winner:
        break

# 승부가 결정되지 않을 경우
if winner == 0:
    print(winner)

        
