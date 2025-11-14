-- 예약과 주문 정보 T가 매출, 주문 관련 정보 

---2. 매출 분석 
-- 매출에 대한 특징 통계값 
SELECT COUNT(*) 총주문건, SUM(sales) 총매출합계, ROUND(AVG(NVL(sales,0)),0) 평균매출, MAX(sales) 최고매출, MIN(sales) 최저매출
FROM order_info ;


--3. 매출 비교 분석
-- 온라인 전용 상품 판매량 분석 


SELECT COUNT(*) 총주문건, SUM(sales) 총매출합계, COUNT(i.item_id) 온라인주문건, 
    (select sum(o.sales) from  order_info o join item i on o.item_id = i.item_id where i.product_desc = '온라인_전용상품' group by i.item_id) 온라인매출
FROM order_info o
LEFT JOIN reservation r 
    ON o.reserv_no = r.reserv_no 
LEFT JOIN item i
    ON o.item_id = i.item_id and i.product_desc = '온라인_전용상품'    
group by o.item_id ;
----------------------------------
SELECT COUNT(*) 총주문건, SUM(sales) 총매출합계,
    count(
     case when ( order_info.item_id = 'M0001') then 1 else null end
    ) 온라인주문건, 
    SUM(
    case when( order_info.item_id = 'M0001' ) then sales else null end
    ) 온라인매출합계,
    
    ROUND(( count(case when ( order_info.item_id = 'M0001') then 1 else null end)) /COUNT(*)*100,3) 주문건수비율,
    ROUND( SUM( case when( order_info.item_id = 'M0001' ) then sales else null end ) /   SUM(sales)*100,2) 매출합계비율
    
FROM order_info ;
--------------------
--4 상품별 매출 분석
select o.item_id, i.product_name, sum(o.sales) 매출합계 
from order_info o
left join item i on o.item_id = i.item_id
group by o.item_id, i.product_name
order by 매출합계 DESC;

------------------------------------------
--5 월별 상품 매출 분석 
SELECT substr(r.reserv_date,1,6) 년월, 
    sum(case when (i.product_name = 'SPECIAL_SET') then o.sales else 0 end ) SPECIAL_SET,
    sum(case when (i.product_name = 'PASTA') then o.sales else 0 end ) PASTA,
    sum(case when (i.product_name = 'PIZZA') then o.sales else 0 end ) PIZZA,
    sum(case when (i.product_name = 'SEA_FOOD') then o.sales else 0 end ) SEA_FOOD,
    sum(case when (i.product_name = 'STEAK') then o.sales else 0 end ) STEAK,
    sum(case when (i.product_name = 'SALAD_BAR') then o.sales else 0 end ) SALAD_BAR,
    sum(case when (i.product_name = 'SALAD') then o.sales else 0 end ) SALAD,
    sum(case when (i.product_name = 'SANDWICH') then o.sales else 0 end ) SANDWICH,
    sum(case when (i.product_name = 'WINE') then o.sales else 0 end ) WINE,
    sum(case when (i.product_name = 'JUICE') then o.sales else 0 end ) JUICE
FROM order_info o
LEFT JOIN reservation r 
    ON o.reserv_no = r.reserv_no 
LEFT JOIN item i
    ON o.item_id = i.item_id
group by substr(r.reserv_date,1,6)
order by 년월;

-------------------------------------------
--6
SELECT substr(r.reserv_date,1,6) 년월, SUM(sales), 
        sum(case when (i.product_name = 'SPECIAL_SET') then o.sales else 0 end ) SPECIAL_SET
FROM order_info o
LEFT JOIN reservation r 
    ON o.reserv_no = r.reserv_no 
LEFT JOIN item i
    ON o.item_id = i.item_id
group by substr(r.reserv_date,1,6)
order by 년월;
---------------------------------------
-- 7. 
SELECT substr(r.reserv_date,1,6) 년월, SUM(sales) -  sum(case when (i.product_name = 'SPECIAL_SET') then o.sales else 0 end ) ETC , 
        sum(case when (i.product_name = 'SPECIAL_SET') then o.sales else 0 end ) SPECIAL_SET,
        round(sum(case when (i.product_name = 'SPECIAL_SET') then o.sales else 0 end ) / sum(sales) *100,1) 매출기여율
FROM order_info o
LEFT JOIN reservation r 
    ON o.reserv_no = r.reserv_no 
LEFT JOIN item i
    ON o.item_id = i.item_id
group by substr(r.reserv_date,1,6)
order by 년월;

---------------------------------------
--8.
SELECT substr(r.reserv_date,1,6) 년월, SUM(sales) -  sum(case when (i.product_name = 'SPECIAL_SET') then o.sales else 0 end ) ETC , 
        sum(case when (i.product_name = 'SPECIAL_SET') then o.sales else 0 end ) SPECIAL_SET,
        round(sum(case when (i.product_name = 'SPECIAL_SET') then o.sales else 0 end ) / sum(sales) *100,1) 매출기여율,
        count(*) 총주문건,
        count( case when(r.cancel = 'N') then 1 else null end ) 예약완료건,
        count( case when(r.cancel = 'Y') then 1 else null end ) 예약취소건
FROM order_info o
right JOIN reservation r 
    ON o.reserv_no = r.reserv_no 
LEFT JOIN item i
    ON o.item_id = i.item_id
group by substr(r.reserv_date,1,6)
order by 년월;


--------------------------------
--9
SELECT substr(r.reserv_date,1,6) 년월,
        count(*) 총주문건,
        count( case when(r.cancel = 'N') then 1 else null end ) 예약완료건,
        count( case when(r.cancel = 'Y') then 1 else null end ) 예약취소건,
        round((count( case when(r.cancel = 'Y') then 1 else null end ) / count(*))*100,1)||'%' 예약취소율
FROM order_info o
right JOIN reservation r 
    ON o.reserv_no = r.reserv_no 
LEFT JOIN item i
    ON o.item_id = i.item_id
group by substr(r.reserv_date,1,6)
order by 년월;

---------------
--10

SELECT substr(r.reserv_date,1,6) 년월,
    i.product_name,
    sum( case when(to_char(to_date(r.reserv_date,'yyyymmdd'),'DY')='일') then o.sales else 0 end  )일요일,
    sum( case when(to_char(to_date(r.reserv_date,'yyyymmdd'),'DY')='월') then o.sales else 0 end  )월요일,
    sum( case when(to_char(to_date(r.reserv_date,'yyyymmdd'),'DY')='화') then o.sales else 0 end  )화요일,
    sum( case when(to_char(to_date(r.reserv_date,'yyyymmdd'),'DY')='수') then o.sales else 0 end  )수요일,
    sum( case when(to_char(to_date(r.reserv_date,'yyyymmdd'),'DY')='목') then o.sales else 0 end  )목요일,
    sum( case when(to_char(to_date(r.reserv_date,'yyyymmdd'),'DY')='금') then o.sales else 0 end  )금요일,
    sum( case when(to_char(to_date(r.reserv_date,'yyyymmdd'),'DY')='토') then o.sales else 0 end  )토요일
FROM order_info o
right JOIN reservation r 
    ON o.reserv_no = r.reserv_no 
LEFT JOIN item i
    ON o.item_id = i.item_id
group by substr(r.reserv_date,1,6), product_name
having product_name = 'SPECIAL_SET'
order by 년월;

-------------------------------------------------------------
--11

SELECT substr(r.reserv_date,1,6) 년월, SUM(sales), 
        sum(case when (i.product_name = 'SPECIAL_SET') then o.sales else 0 end ) SPECIAL_SET
FROM order_info o
LEFT JOIN reservation r 
    ON o.reserv_no = r.reserv_no 
LEFT JOIN item i
    ON o.item_id = i.item_id
group by substr(r.reserv_date,1,6)
order by 년월;






