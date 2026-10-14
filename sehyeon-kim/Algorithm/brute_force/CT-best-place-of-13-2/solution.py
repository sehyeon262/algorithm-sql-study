n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

max_v = -10000

# 첫 번째 직사각형의 합 구하기
for i in range(n):
    for j in range(n - 2):
        sum_1 = arr[i][j] + arr[i][j + 1] + arr[i][j + 2]
        
        # 두 번째 직사각형의 합 구하기 
        for a in range(n):
            for b in range(n - 2):
                # 두 직사각형이 겹치면 pass (시작 열의 차이가 2 이하면 겹침)
                if i == a and abs(j - b) <= 2:
                    continue
                
                sum_2 = arr[a][b] + arr[a][b + 1] + arr[a][b + 2]
                max_v = max(max_v, sum_1 + sum_2)

print(max_v)
