-- 코드를 입력하세요
SELECT m.MEMBER_NAME, r.REVIEW_TEXT, DATE_FORMAT(REVIEW_DATE, '%Y-%m-%d') REVIEW_DATE
from REST_REVIEW R
join MEMBER_PROFILE M ON M.MEMBER_ID = R.MEMBER_ID
where M.MEMBER_ID = 
                    (SELECT MEMBER_ID
                    FROM REST_REVIEW
                    GROUP BY MEMBER_ID
                    ORDER BY COUNT(*) DESC
                    LIMIT 1)
ORDER BY REVIEW_DATE, REVIEW_TEXT;