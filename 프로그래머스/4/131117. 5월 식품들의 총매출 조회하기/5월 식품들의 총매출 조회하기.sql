-- 코드를 입력하세요
SELECT p.PRODUCT_ID, p.PRODUCT_NAME, p.PRICE*sum(o.AMOUNT) as TOTAL_SALES
from FOOD_PRODUCT p join FOOD_ORDER o
on p.PRODUCT_ID = o.PRODUCT_ID
where year(PRODUCE_DATE) like '2022' and month(PRODUCE_DATE) like '5'
group by PRODUCT_ID
order by TOTAL_SALES desc, p.PRODUCT_ID;