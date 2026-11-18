def solution(sequence, k):
    n = len(sequence)
    left = 0
    cur_sum = 0
    
    min_len = float('inf')
    answer = [0, 0]
    
    # right을 0부터 끝까지 한 칸씩 늘려감
    for right in range(n):
        cur_sum += sequence[right]
        
        # 합이 k보다 크면 작아질 때까지 left를 오른쪽으로 당김
        while cur_sum > k and left <= right:
            cur_sum -= sequence[left]
            left += 1
            
        # 합이 k와 같은 경우
        if cur_sum == k:
            # 길이가 더 짧을 때만 갱신함. (앞에서부터 탐색하므로 시작 인덱스가 작은 조건은 무시해도 됨!)
            if right - left + 1 < min_len:
                min_len = right - left + 1
                answer = [left, right]
                         
    return answer
