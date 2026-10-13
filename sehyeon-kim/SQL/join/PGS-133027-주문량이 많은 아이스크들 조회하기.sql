-- 7월 아이스크림 총 주문량과/ 상반기의 아이스크림 총 주문량을 더한 값이/ 큰 순서대로 상위 3개의 맛을 조회/하는 SQL 문을 작성

SELECT a.FLAVOR
FROM FIRST_HALF a
JOIN JULY b
    ON (a.FLAVOR = b.FLAVOR)
GROUP BY a.FLAVOR
ORDER BY SUM(a.TOTAL_ORDER) + SUM(b.TOTAL_ORDER) DESC
LIMIT 3;
