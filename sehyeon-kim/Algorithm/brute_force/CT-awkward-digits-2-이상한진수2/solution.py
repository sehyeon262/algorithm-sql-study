a = list(input())
n = len(a)

# 0이 있을 경우 -> 가장 왼쪽에 있는 0을 1로 바꿈
if '0' in a:
    idx = a.index('0')
    a[idx] = '1'
# 0이 없을 경우 -> 젤 끝에 있는 1을 0으로 바꿈 (최댓값 구하기 때문)
else:
    a[-1] ='0'

sum_v = 0

for i in range(n):
    if a[i] == '1':
        sum_v += 2 ** (n - 1 - i)

print(sum_v)
