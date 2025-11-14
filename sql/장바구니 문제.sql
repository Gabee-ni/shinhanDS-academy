CREATE TABLE CARTS 
(
  ID NUMBER 
, USER_ID NUMBER 
, PAYED_AT DATE 
, PRODUCT_COUNT NUMBER 
);


insert into CARTS values (636, 3, to_date('2001-02-23 00:00:00','yyyy-mm-dd hh24:mi:ss'), 5);
insert into CARTS values (287, 4, to_date('2000-05-27 00:00:00','yyyy-mm-dd hh24:mi:ss'), 13);
insert into CARTS values (448, 4, to_date('2000-08-17 00:00:00','yyyy-mm-dd hh24:mi:ss'), 17);
insert into CARTS values (578, 4, to_date('2001-01-29 00:00:00','yyyy-mm-dd hh24:mi:ss'), 9);
insert into CARTS values (734, 11, to_date('2001-04-10 00:00:00','yyyy-mm-dd hh24:mi:ss'), 10);
insert into CARTS values (195, 11, to_date('2000-04-12 00:00:00','yyyy-mm-dd hh24:mi:ss'), 11);
commit;

------------------------------
SELECT user_id, COUNT(user_id) payed_count 
FROM carts 
WHERE product_count >= 10
group by user_id
ORDER BY payed_count ASC, user_id DESC;