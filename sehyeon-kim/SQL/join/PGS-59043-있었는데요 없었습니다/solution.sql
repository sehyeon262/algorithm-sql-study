-- 보호 시작일보다 입양일이 더 빠른 동물의 아이디와 이름을 조회하는 SQL문을 작성 (a.DATETIME > b.DATETIME)
-- 결과는 보호 시작일이 빠른 순으로 조회

SELECT a.ANIMAL_ID, a.NAME
FROM ANIMAL_INS a
JOIN ANIMAL_OUTS b ON (
    a.ANIMAL_ID = b.ANIMAL_ID
)
WHERE a.DATETIME > b.DATETIME
ORDER BY a.DATETIME
