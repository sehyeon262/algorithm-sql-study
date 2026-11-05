-- 2021년에 가입한 전체 회원들 중/ 상품을 구매한 회원수와/ 상품을 구매한 회원의 비율(=2021년에 가입한 회원 중 상품을 구매한 회원수 / 2021년에 가입한 전체 회원 수)을/ 년, 월 별로 출력하는 SQL문
-- 상품을 구매한 회원의 비율은 소수점 두번째자리에서 반올림/ 전체 결과는 년을 기준으로 오름차순 정렬/ 월을 기준으로 오름차순 정렬

-- 2021년에 가입한 전체 회원들
WITH JOIN_USER AS (
    SELECT USER_ID 
    FROM USER_INFO 
    WHERE YEAR(JOINED) = 2021
)

SELECT YEAR(s.SALES_DATE) AS YEAR, MONTH(s.SALES_DATE) AS MONTH, 
    COUNT(DISTINCT u.USER_ID) AS PURCHASED_USERS,
    ROUND(COUNT(DISTINCT u.USER_ID) / (SELECT COUNT(*) FROM JOIN_USER), 1) AS PUCHASED_RATIO
FROM JOIN_USER u
JOIN ONLINE_SALE s
    ON u.USER_ID = s.USER_ID
GROUP BY YEAR(s.SALES_DATE), MONTH(s.SALES_DATE)
ORDER BY YEAR(s.SALES_DATE), MONTH(s.SALES_DATE);
