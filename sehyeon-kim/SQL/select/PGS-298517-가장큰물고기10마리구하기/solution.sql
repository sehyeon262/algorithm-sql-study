-- FISH_INFO 테이블에서 가장 큰 물고기 10마리의 ID와 길이를 출력하는 SQL 문을 작성
-- 길이를 기준으로 내림차순 정렬, 길이가 같다면 물고기의 ID에 대해 오름차순 정렬
SELECT ID, LENGTH
FROM FISH_INFO
WHERE LENGTH IS NOT NULL
ORDER BY LENGTH DESC, ID
LIMIT 10;