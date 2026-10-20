import sys
n = int(input())
a = [int(input()) for _ in range(n)]

min_v = sys.maxsize
for k in range(n):
    sum_v = 0
    for i in range(n):
        sum_v += i * a[(k + i) % n]
    
    min_v = min(sum_v, min_v)

print(min_v)
