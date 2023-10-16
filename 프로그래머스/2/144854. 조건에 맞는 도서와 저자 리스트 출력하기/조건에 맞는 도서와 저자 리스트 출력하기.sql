-- 코드를 입력하세요
SELECT b.book_id as BOOK_ID, a.author_name as AUTHOR_NAME, date_format(b.published_date, '%Y-%m-%d') as PUBLISHED_DATE
from book b join author a
on b.AUTHOR_ID = a.AUTHOR_ID
where CATEGORY like '경제'
order by b.published_date;