-- 자동차 종류가 '세단' 또는 'SUV' 인 자동차 중/ 2022년 11월 1일부터 2022년 11월 30일까지 대여 가능하고/ 30일간의 대여 금액이 50만원 이상 200만원 미만인 자동차에 대해서/ 자동차 ID, 자동차 종류, 대여 금액(컬럼명: FEE) 리스트를 출력하는 SQL문
-- 대여 금액을 기준으로 내림차순 정렬/ 자동차 종류를 기준으로 오름차순 정렬/ 자동차 ID를 기준으로 내림차순 정렬

-- CTE: '차량 종류 필터링'과 '대여 가능 여부 필터링'
WITH CAR_T AS (
    SELECT *
    FROM CAR_RENTAL_COMPANY_CAR 
    WHERE CAR_TYPE IN ('SUV', '세단')
        AND CAR_ID NOT IN (
            SELECT CAR_ID
            FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
            WHERE START_DATE <= '2022-11-30' AND END_DATE >= '2022-11-01'
        )
)

SELECT a.CAR_ID, a.CAR_TYPE, FLOOR(a.DAILY_FEE * 30 * (100 - b.DISCOUNT_RATE) / 100) AS FEE
FROM CAR_T a
JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN b
    ON a.CAR_TYPE = b.CAR_TYPE
WHERE b.DURATION_TYPE = '30일 이상'
    AND FLOOR(a.DAILY_FEE * 30 * (100 - b.DISCOUNT_RATE) / 100) >= 500000
    AND FLOOR(a.DAILY_FEE * 30 * (100 - b.DISCOUNT_RATE) / 100) < 2000000
ORDER BY FEE DESC, a.CAR_TYPE, a.CAR_ID DESC;

