n, k = map(int, input().split())
x = []
c = []
for _ in range(n):
    pos, char = input().split()
    x.append(int(pos))
    c.append(char)

ans = 0

for start in range(1, 10001 - k):
    end = start + k
    score = 0

    for i in range(n):
        if start <= x[i] <= end:
            if c[i] == 'G':
                score += 1
            else:
                score += 2

    ans = max(ans, score)

print(ans)
