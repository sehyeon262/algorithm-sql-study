def solution(numbers, target):
    answer = 0
    
    def dfs(i, sum_v):
        nonlocal answer
        
        if i == len(numbers):
            if sum_v == target:
                answer += 1
            return
                
        dfs(i + 1, sum_v + numbers[i])
        dfs(i + 1, sum_v - numbers[i])
    
        
    # (인덱스, 현재까지의 합)
    dfs(0, 0)
    return answer