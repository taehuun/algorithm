-- 코드를 입력하세요
SELECT PRODUCT_CODE, PRICE*(select sum(SALES_AMOUNT)
                            from OFFLINE_SALE
                            where PRODUCT.PRODUCT_ID = OFFLINE_SALE.PRODUCT_ID) as SALES
from PRODUCT
order by SALES desc, PRODUCT_CODE