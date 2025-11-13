-- union 
-- 5-30 
select empno, ename, sal, deptno 
from emp 
where deptno = 10
union 
--select empno, ename, sal, deptno
--from emp 
--where deptno=20
--order by deptno;
select empno, ename, sal, 1
from emp 
where deptno=20
order by deptno;
--위에 결과는 deptno==20인 것에 1의 값이 찍힘 
-- 스칼라 
select 1, ename from emp; -- 1이라는 열이 아니라 값을 쓴거임. -> 따라서 테이블의 있는 행의 개수만큼 나옴.
-- union에서 열 개수와 각 열의 자료형의 순번이 같아야 해서, 1자리에 comm이나 sal은 가능하나, hiredate를 넣으면 오류가 나옴, 

select empno, ename, sal, deptno
from emp 
where deptno in (10,20);


-- 5-34
select empno, ename, sal, deptno
from emp
where deptno =10
union all
--union 
select empno, ename, sal, deptno 
from emp 
where deptno = 10;

-- 되새김 문제
/*
어디서 / 어떻게/ 무엇을 
*/
--1 
select * from emp 
where ename like '%S';

--2 
select empno, ename, job, sal, deptno
from emp 
where deptno = 30 and job = 'SALESMAN';

--3
select empno, ename, job, sal, deptno 
from emp 
where deptno in (30,20) and sal >2000;

--3-2
select empno, ename, job, sal, deptno 
from emp 
where deptno= 20 and sal > 2000
union all 
select empno, ename, job, sal, deptno 
from emp 
where deptno= 30 and sal > 2000;

--4
select * from emp
where sal <2000 or sal >3000;

select * from emp 
where not (sal >=2000 and sal <=3000);

--5
select ename, empno, sal, deptno 
from emp 
where ename like '%E%' and deptno =30 and sal not between 1000 and 2000;

--6 -> %랑 _ 활용 잘하기 _는 한 글자 -> 2번째가 L로 끝나는
-- 초기 수당이 없는 거니까 -> null 또는 0 
select * from emp 
where (comm is null or comm =0) and MGR is not null and job in ('MANAGER','CLERK') AND ename not like '_L%';

/*
single-row function (단일행함수) : 한 행 입력 한 행 결과 
multi-row function (다중행함수) : 여러 행 입력 한 행 결과 
*/

-- 6-1
select ename, upper(ename) , lower(ename), initcap(ename)
from emp;
-- 6-2
select * from emp
where upper(ename) = upper('scott');
-- 6-4
select ename, length(ename), length('홍길동'), lengthb('홍길동') from emp;
-- 함수 확인 및 테스트 시 사용하는 테이블 
select length('홍길동'), lengthb('홍길동') from dual;

-- 6-7
--시작 인덱스가 1
select job, substr(job, 1, 2), substr(job, 3, 2), substr(job,5) from emp;

-- 6-8
select job,
substr(job, -length(job)),
substr(job, -length(job),2),
substr(job, -3)
from emp;

-- instr 함수 : 들어 있으면 인덱스, 없으면 0 
select instr(ename, 'A') from emp;

-- 6-12
select '010-1234-5678' replace_before,
replace('010-1234-5678', '-',' ') replace_1,
replace('010-1234-5678', '-') replace_2,
replace('010-1234-5678', '-','') replace_3
from dual;

-- 6-15
select concat(empno, ename),
    concat(empno, concat(':',ename)),
    --concat(empno, ':', ename) -> 오라클 X 
    concat(concat(':',ename),empno)
from emp;   

select ename||empno,
    ename||':'||empno --MySQL X
from emp;

-- 6-16
select '[' || trim('  __Oracle__  ') || ']' as trim,
'[' || trim(leading from '  __Oracle__   ') || ']' as trim_leading,
'[' || trim(trailing from '  __Oracle__  ') || ']' as trim_trailing,
'[' || trim(both from '  __Oracle__  ') || ']' as trim_trim
from dual;

-- 6-19
select round(1234.5678) as round, 
round(1234.5678, 0) as round_0,
round(1234.5678, 1) as round_1,
round(1234.5678, 2) as round_2,
round(1234.5678, -1) as round_minus,
round(1234.5678, -2) as round_minus2
from dual;

-- 6-20
select trunc(1234.5678) as trunc,
trunc(1234.5678,0) as trunc_0,
trunc(1234.5678,1) as trunc_1,
trunc(1234.5678,2) as trunc_2,
trunc(1234.5678,-1) as trunc_minus,
trunc(1234.5678,-2) as trunc_minus2
from dual;

/*
ceil : 주어진 값보다 더 큰 정수 중에 가장 작은 정수 : 올림 
floor : 주어진 값보다 더 작은 정수 중에 가장 큰 정수 : 내림
*/

-- 6-23
select 
    sysdate as now, 
    sysdate -1 as yesterday,
    sysdate +1 as tomorrow
from dual;

--to_date() : 날짜 타입으로 변환 해주는 함수 => 하루를 1로 보고, 시간을 소숫점 이하 자리로 표현. 정오 = 0.5 
select 
    trunc(sysdate - to_date('2025-10-23')) 
from dual;

-- 6-24
select sysdate,
add_months(sysdate, 3)
from dual;

-- 6-27
select empno, ename, hiredate, sysdate,
months_between(hiredate, sysdate) as months1,
months_between(sysdate, hiredate) as months2,
trunc(months_between(sysdate, hiredate)) as months3
from emp;

-- 6-28
-- 문자 타입으로 변환 해주는 함수 to_char -> 날짜를 원하는대로 포맷팅할 수 있음.  
select to_char(sysdate, 'YYYY-mm-dd HH:miw:ss'),
next_day(sysdate, '월요일'),
last_day(sysdate)
from dual;

-- 6-31
-- 숫자가 들어 있는 문자열 경우, 자동 형변환 문자 -> 숫자 
select empno, ename, empno+'500' from emp where ename ='SCOTT';
-- 문자 -> 날짜
select * from emp where hiredate between '1987-01-01' and '1987-12-31';

-- 6-33 
select to_char(sysdate, 'YYYY/MM/DD HH24:MI:SS') from dual; -- 24
select to_char(sysdate, 'YYYY/MM/DD HH:MI:SS') from dual; --12

-- 6-39
select 
    1300 - '1500',
    '1300' - 1500,
    '1300'+1500,
    1300+'1500'
from dual;

--문자는 숫자로 다 바뀜 -> 자바에서 문자로 데이터 넣어도 DB는 다 숫자로 변환해서 넣음.
select '1300' + '1300' from dual;
select * from emp where deptno = '30' ;

/*
- 함수(값, 출력포맷) -> to_char
- 함수(값, 입력포맷) -> to_number('1,300','999,999'), to_date
*/

-- 6-42 to_date도 입력 포맷을 알려주고 값을 날짜 타입으로 변환 
select to_date('2024-08-14', 'yyyy-mm-dd') as todate1,
to_date('2024/08/14', 'yyyy/mm/dd') as todate2
from dual;

-- 6-43
select * from emp 
where hiredate > to_date('1981/06/01','YYYY/MM/DD');
select * from emp 
where hiredate > '1981/06/01'; -- 날짜 비교 시, 시간을 명시하지 않아도 실제 데이터에는 존재하니 주의

/*
랭킹함수  : 순서를 나타내는 함수
- row_number() : 행 넘버링 
- rank() : 순위 -> 동등할 시 그 다음 순위는 없음. 등수 1 22 4
- dense_rank() : 다음 순위까지 다 표시해서 나타내는 등수. 1 22 3 ->순위 개수가 적음 
*/

select ename, sal, 
    row_number() over(order by sal desc) as rank
from emp;

select ename, sal, 
    rank() over(order by sal desc) as rank
from emp;

select ename, sal, 
    dense_rank() over(order by sal desc) as rank
from emp;

/*
- nvl (컬럼, 널일 때 반환할 )
- nvl2 (컬럼, 널이 아닐 때 반환할 , 널일 때 반환할 )
*/
-- 6-46
select empno, ename, comm,
    nvl2(comm,'O','X'), -- 2, 3번째 인자는 같은 타입의 인자를 넣어줘야함. 
    nvl2(comm,sal*12+comm, sal*12) as annsal
from emp;

-- 6-47 decode
select empno, ename, job, sal, 
decode(job, 
        'MANAGER', sal*1.1,
        'SALESMAN', sal*1.05,
        'ANALYST', sal, 
         sal*1.03) as upsal
from emp;

-- 6-48
select empno, ename, job, sal,
    case job
        when 'MANAGER' then sal*1.1
        when 'SALESMAN' then sal*1.05
        when 'ANALYST' then sal
        else sal*1.03
    end as upsal
from emp;    

select empno, ename, job, sal,
    case 
        when comm is null then '해당 사항 없음'
        when comm =0 then '수당 없음'
        --숫자는 오른쪽 정렬 문자는 왼쪽 정렬임 
        when comm >0 then '수당 : ' || comm
--        when comm >0 then to_char(comm) 
    end as comm_text
from emp;    

-- 6장 되새김 문제 
--1
select  empno,
        rpad(substr(empno,1,2),length(empno),'*')as masking_empno,
        ename, 
        rpad(substr(ename,1,1),length(ename),'*')as masking_ename
from emp 
where length(ename)=5 ;

--강사님 풀이 
--select empno,substr(empno,1,2 )||'**' as masking_empno
--        ,ename,substr(ename,1,1)||'****' as masking_ename
--from emp 
--where length(ename)=5 ;


--2
/*
평균 근무 일수 : 21.5일 가정 
하루 근무 시간 : 8시간 가정 

급여/ 일수 = 일급 (소수점 3자리 버림 -> 2까지 출력) 
급여/일수/시간 = 시급 (소수점 2자리에서 반올림-> 1까지 출력)
*/
select  empno, ename, sal, 
        trunc(sal/21.5, 2) as day_pay, 
        round(sal/21.5/8,1) as time_pay 
from emp ;

--3
/*
입사일 3개월 후의 첫 월요일 -> 해당 날짜 이후의 요일을 찾을 때는 next_day(날짜,요일)
추가 수당 (없는 사람은 N/A로 출력) 
*/
select  empno, ename, 
        to_char(hiredate,'yy/mm/dd')as hiredate,
        next_day( add_months(hiredate,3),'월') as r_job, 
        nvl2(comm,to_char(comm),'N/A')as comm
from emp ;

--4
select empno, ename, mgr, 
    case 
        when mgr is null then '0000'
        when substr(mgr,1,2)=75 then '5555'
        when to_char(mgr) like '%76' then '6666'
        when substr(mgr,1,2)=77 then '7777'
        else to_char(mgr) 
    end as chg_mgr
from emp;

/*
다중행 함수 
    - 여러행이 입력 -> 하나의 행으로 출력
    - null은 제외함. -> 집계 함수 사용 시 값이 달라질 수 있음. => nvl로 null을 0으로 지정해줘야 함. 
*/

-- 7-1 
select sum(sal) from emp; 
select avg(comm), sum(comm), 2200/14, 2200/4, avg(nvl(comm,0)) from emp; 
select count(comm) from emp;
select count(*) from emp;

/*
group by
- ~별 
- 같은 값끼리 묶는 것
- 그룹바이 사용하면 열 자리에는 그룹핑한 컬럼 이름 또는 집계함수만 가능., 
*/

-- 7-17
-- 그룹핑 한 그룹 별로 집계를 함. 
select avg(sal), deptno
from emp 
group by deptno;

-- 부서별 그룹핑한 결과에서 또 직업별로 그룹핑 
select deptno, job, avg(sal)
from emp 
group by deptno, job
order by deptno, job;
































