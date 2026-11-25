-- 각 분기(QUARTER)별 분화된 대장균의 개체의 총 수(ECOLI_COUNT)를 출력하는 SQL 문
-- 이때 각 분기에는 'Q' 를 붙이고 분기에 대해 오름차순으로 정렬
-- 대장균 개체가 분화되지 않은 분기는 없습니다. 

SELECT CONCAT(QUARTER(DIFFERENTIATION_DATE), 'Q') AS QUARTER, COUNT(*)
FROM ECOLI_DATA 
GROUP BY QUARTER
ORDER BY QUARTER;
