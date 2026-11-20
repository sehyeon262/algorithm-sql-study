-- AIR_POLLUTION 테이블에서 수원 지역의 연도 별 평균 미세먼지 오염도와 평균 초미세먼지 오염도를 조회하는 SQL문
-- 이때, 평균 미세먼지 오염도와 평균 초미세먼지 오염도의 컬럼명은 각각 PM10, PM2.5로 해 주시고, 값은 소수 셋째 자리에서 반올림

SELECT YEAR(YM) AS YEAR, ROUND(AVG(PM_VAL1), 2) AS PM10, ROUND(AVG(PM_VAL2), 2) AS 'PM2.5'
FROM AIR_POLLUTION
WHERE LOCATION2 = '수원'
GROUP BY YEAR
ORDER BY YEAR;
