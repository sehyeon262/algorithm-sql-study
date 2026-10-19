n = int(input())
arr = list(map(int, input().split()))

answer = n
for i in range(n - 1):
    for j in range(i + 1, n):
        sum_v = 0
        lst = []
        for k in range(i, j + 1):
            lst.append(arr[k])
            sum_v += arr[k]            
        
        avg_v = sum_v / (j - i + 1)
        if avg_v in lst:
            answer += 1

print(answer)
