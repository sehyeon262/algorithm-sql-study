--  Front End 스킬을 가진 개발자의 정보를 조회하려 합니다. 조건에 맞는 개발자의 ID, 이메일, 이름, 성을 조회하는 SQL 문\
-- ID를 기준으로 오름차순 정렬
-- 스킬의 코드는 2진수로 표현했을 때 각 bit로 구분될 수 있도록 2의 제곱수로 구성되어 있습니다.

WITH FRONTEND AS (
    SELECT CODE
    FROM SKILLCODES 
    WHERE CATEGORY = 'Front End'
)

SELECT DISTINCT d.ID, d.EMAIL, d.FIRST_NAME, d.LAST_NAME
FROM DEVELOPERS d
JOIN FRONTEND f
    ON d.SKILL_CODE & f.CODE > 0
ORDER BY d.ID
