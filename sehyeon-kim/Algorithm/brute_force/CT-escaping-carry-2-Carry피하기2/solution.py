from itertools import combinations

n = int(input())
arr = [int(input()) for _ in range(n)]

def check(a, b, c):
    is_carry = True
    
    while a > 0 or b > 0 or c > 0:
        one = a % 10
        two = b % 10
        three = c % 10

        a //= 10
        b //= 10
        c //= 10

        if one + two + three >= 10:
            is_carry = False
            break

    return is_carry

max_n = -1
for a, b, c in combinations(arr, 3):
    if check(a, b, c):
        max_n = max(max_n, a + b + c)

print(max_n)
