-- 코드를 입력하세요
SELECT BOOK_ID, DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') AS PUBLISHED_DATE
from BOOK
where year(PUBLISHED_DATE) = 2021 and CATEGORY like '인문%'
order by BOOK_ID;