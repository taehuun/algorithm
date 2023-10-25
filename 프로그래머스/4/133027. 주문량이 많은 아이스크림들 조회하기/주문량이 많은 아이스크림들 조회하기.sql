-- 코드를 입력하세요
SELECT a.FLAVOR
from FIRST_HALF a
join JULY b
on a.FLAVOR = b.FLAVOR
group by FLAVOR
order by sum(a.TOTAL_ORDER + b.TOTAL_ORDER) desc
limit 3
