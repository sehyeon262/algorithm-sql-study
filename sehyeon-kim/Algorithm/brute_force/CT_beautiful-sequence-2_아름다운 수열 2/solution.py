N, M = map(int, input().split())
A = list(map(int, input().split()))
B = list(map(int, input().split()))

# 비교 기준이 될 수열 B를 미리 정렬
sorted_B = sorted(B)

answer = 0

for i in range(N - M + 1):
    # i번째부터 M개의 원소를 잘라 정렬한 결과가 sorted_B와 같으면 +1
    if sorted(A[i:i+M]) == sorted_B:
        answer += 1

print(answer)
