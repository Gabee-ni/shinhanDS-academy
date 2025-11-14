create table MERCHANTS(
	id number primary key,
	name varchar2(50),
	BUSINESS_ID  varchar2(30),
	TAX_TYPE varchar2(30),
	CATEGORY_ID  number
);

create table CARD_USAGES (
	id number,
	CREATED_AT date,
	CATEGORY number,
	AMOUNT number,
	MERCHANT_ID number
);

insert into MERCHANTS values(3907, 'KFC학동역', '201-81-89723', '일반과세자', 1);
insert into MERCHANTS values(4989, '미켈 (Mikelle)고깃집', '785-49-00298' , '일반과세자', 1);
insert into MERCHANTS values(6297, '뉴발란스 강남점' , '214-85-50334' , '일반과세자', 6);
insert into MERCHANTS values(27052, '주식회사이마트몰-주식회사이마트몰' , '104-86-50432', '일반과세자', 2);
insert into MERCHANTS values(118009, '플라이앤컴퍼니(주)' ,'211-88-57343', '일반과세자', 1);

insert into CARD_USAGES values('195772', to_date('2018-05-02 18:54:43','yyyy-mm-dd hh24:mi:ss'), 0, 2700, 3907);
insert into CARD_USAGES values('2530342', to_date('2019-01-28 09:47:33','yyyy-mm-dd hh24:mi:ss'), 0, 12300, 3907);
insert into CARD_USAGES values('899325', to_date('2018-08-03 16:57:36','yyyy-mm-dd hh24:mi:ss'), 0, 45000, 4989);
insert into CARD_USAGES values('400811', to_date('2018-05-28 12:45:34','yyyy-mm-dd hh24:mi:ss'), 0, 4000, 6297);
insert into CARD_USAGES values('743640', to_date('2018-07-07 11:47:17','yyyy-mm-dd hh24:mi:ss'), 0, 299000, 27052);
insert into CARD_USAGES values('1052039', to_date('2018-08-15 13:40:01','yyyy-mm-dd hh24:mi:ss'), 1, -12900, 118009);
insert into CARD_USAGES values('1120840', to_date('2018-08-21 06:58:55','yyyy-mm-dd hh24:mi:ss'), 0, 20800, 118009);
commit;

-----------------------------------------------------

--

SELECT  id, name, 결제금액
FROM (
    SELECT id, name, 결제금액, rownum
    FROM (
        SELECT m.id id, m.name name, SUM(c.amount) 결제금액 
        FROM merchants m
        JOIN card_usages c 
            ON m.id = c.merchant_id 
        WHERE amount >0
        GROUP BY m.id, m.name
        ORDER BY 결제금액 DESC
    )
)WHERE rownum <=5;



















