T = int(input())
nums = []

for _ in range(T):
    num = int(input())
    if num == 0 and nums:
        nums.pop()
    else:
        nums.append(num)

res = 0
for i in nums:
    res += i

print(res)
        
