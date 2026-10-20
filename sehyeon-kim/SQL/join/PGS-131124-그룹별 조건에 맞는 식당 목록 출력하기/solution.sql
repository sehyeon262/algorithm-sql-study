-- 테이블에서 리뷰를 가장 많이 작성한 회원의/ 리뷰들을 조회/하는 SQL문을 작성
-- 회원 이름, 리뷰 텍스트, 리뷰 작성일이 출력되도록 작성
-- 결과는 리뷰 작성일을 기준으로 오름차순
-- 리뷰 작성일이 같다면 리뷰 텍스트를 기준으로 오름차순 

WITH MAX_MEMBER AS (
    SELECT MEMBER_ID
    FROM REST_REVIEW 
    GROUP BY MEMBER_ID
    ORDER BY COUNT(*) DESC
    LIMIT 1
)
SELECT m.MEMBER_NAME, r.REVIEW_TEXT, DATE_FORMAT(r.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
FROM REST_REVIEW r
JOIN MEMBER_PROFILE m
    ON r.MEMBER_ID = m.MEMBER_ID
JOIN MAX_MEMBER mm
    ON r.MEMBER_ID = mm.MEMBER_ID
ORDER BY r.REVIEW_DATE, r.REVIEW_TEXT;
