create table EMPLOYEES_shinhan(
    id number primary key ,
    NAME VARCHAR(20) not null,
    SALARY number(20,0) not null,
    BRANCH_ID NUMERIC  not null);

insert into EMPLOYEES_shinhan values(1015, 'Vex', 900, 1);
insert into EMPLOYEES_shinhan values(3317, 'Stephanie', 250, 3);
insert into EMPLOYEES_shinhan values(3884 , 'Audrina',470, 1);
insert into EMPLOYEES_shinhan values(3912, 'Courtney', 300, 2);

create table SELLINGS_shinhan (
CAR_ID number not null,
EMPLOYEE_ID number not null,
CREATED_AT date not null,
PRICE NUMERIC(20,0) not null);

insert into SELLINGS_shinhan values(306, 3317,  to_date('2016-07-19 12:40:54','yyyy-mm-dd hh24:mi:ss'), 500);
insert into SELLINGS_shinhan values(414, 3884 , to_date('2016-07-17 07:53:19','yyyy-mm-dd hh24:mi:ss'), 1700);
insert into SELLINGS_shinhan values(537, 3317,  to_date('2016-07-22 18:47:05','yyyy-mm-dd hh24:mi:ss'), 1600);
insert into SELLINGS_shinhan values(594, 3884,  to_date('2016-12-02 19:33:28','yyyy-mm-dd hh24:mi:ss'), 700);
insert into SELLINGS_shinhan values(810, 3912,  to_date('2016-07-09 03:09:21','yyyy-mm-dd hh24:mi:ss'), 4100);
insert into SELLINGS_shinhan values(900, 1015,  to_date('2016-08-14 13:20:56','yyyy-mm-dd hh24:mi:ss'), 15300);

commit;

------------------------------------
SELECT e.name, e.salary
FROM employees_shinhan e
JOIN (
    SELECT employee_id,TO_CHAR(created_at,'yyyy-mm'), SUM(price) 매출액
    FROM sellings_shinhan
    WHERE price IS NOT NULL 
        AND price > 0 and TO_CHAR(created_at,'yyyy-mm')='2016-07'
    GROUP BY TO_CHAR(created_at,'yyyy-mm'), employee_id
) m
    ON e.id = m.employee_id
WHERE ROUND(매출액/e.salary,0) <= 10
ORDER BY salary DESC, name ASC;





























