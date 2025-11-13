-- SQL 실행 방법 : ctrl + enter -> 현재 커서가 위치한 실행문 실행. 또는 드래그 한 실행문. 
/*
sql 작성 
- 대소문자 구분 X -> 팀 별로 작성 규칙 정하고 맞춰서 구현
- 띄어쓰기, 줄바꿈 제한 X 
- 여러 실행문이 있는 경우 -> 실행문 끝에 세미콜론으로 구분 . 
- 문자열은 홑따옴표 ' 로 감쌈. 
*/

SELECT * FROM emp;
SELECT * FROM dept;

--스키마
desc emp;
desc dept;
desc salgrade;

-- 전체 열 select
select * from emp;
select * from dept;
select * from salgrade;

-- 부분 열 
select empno, ename, deptno from emp;

-- 중복 제거
select DISTINCT job, deptno from emp;

-- alias
select ename, sal, sal*12+comm, comm from emp;
select ename, sal, sal*12+comm as y_sal, comm from emp;

/*
order by 컬럼명[, 컬럼명 여러개 가능,....] ASC/DESC
ASC : ascending - 오름차순 - default 
DESC : descending - 내림차순 

각각 오름차순, 내림차순 
order by 컬럼1 ASC, 컬럼2 DESC -> 1순위는 컬럼 1, 2순위는 컬럼 2

가장 마지막에 위치하고 가장 나중에 실행됨. 
속도 저하가 심함.
*/

select * from emp order by sal;
select * from emp order by sal asc;
select * from emp order by sal desc;
-- 급여가 높은 순, 입사일 최신 순으로 
select * from emp order by sal asc, hiredate desc; -- sql은 중첩-> sal을 우선 작업한 뒤 그것을 가지고 hiredate 작업. sal이 같은 게 없으며 뒤에는 작업 X

--확인문제
select distinct job from emp;

select empno as EMPLOYEE_NO, ename as EMPLOYEE_NAME, mgr as MANAGER , sal as SALARY , comm  as COMMISION, deptno  as DEPARTMENT_NO
from emp
order by deptno desc, ename asc;


-- 5-2
select * from emp where deptno = 30; 

-- 5-3
select * from emp where deptno = 30 and job = 'SALESMAN';
-- 5-4
select * from emp where deptno =30 or job = 'CLERK';

-- 5-5
select * from emp where sal*12 = 36000;
-- comm이 null 값인 경우 연산 결과도 null이 나옴. null은 어떤 연산도 불가
-- nvl(컬럼명, 기본값) 
select ename, sal,comm, sal*12, sal*12+comm as y_sal from emp;  
select ename, sal, sal*12, comm, nvl(comm,0), sal*12+nvl(comm,1) as y_sal from emp; 
--null은 비교 연산도 안됨
select * from emp where comm=null; 
--특정 값이 null인 경우만 필터링 
select * from emp where comm is null;
select * from emp where comm is not null;

-- 5-6
select * from emp where sal >=3000;

-- 5-9 A랑 B 값이 다를 때 
select * from emp where sal != 3000;
select * from emp where sal <> 3000; 
select * from emp where sal ^= 3000; 

-- 5-14 
-- IN
select * from emp where job in ('MANAGER','SALESMAN','CLERK');
-- not(부정, 반대)
select * from emp where job not in ('MANAGER','SALESMAN','CLERK');

-- 5-17 between
select * from emp where sal >= 2000 and sal <= 3000;
select * from emp where sal between 2000 and 3000; 
-- 기간 조회
select * from emp where hiredate between '1981-05-01' and '1981-06-09';
/*
시간까지 포함된 데이터 ex) 주문일자
조회 : 주문일자 between '2025-01-01' and '2025-01-31' XXXXX
    => 이유 : '2025-01-01 00:00:00' and '2025-01-31 00:00:00'가 원래 형식이기에 1월 31일날 결제한 데이터가 안 나옴. 
해결방법 
    1. 조회 시, '2025-01-01 00:00:00' and '2025-01-31 23:59:59'
    2. 주문일자를 동일한 형태로 변환 (YYYY-MM-DD) 
*/

--like 연산
-- ~% : ~로 시작하는 값
select * from emp where ename like 'S%';
-- %~ : ~로 끝나는 값
select * from emp where ename like '%N';
-- %~% : ~을 포함하는 값
select * from emp where ename like '%A%';
/*
like 연산 시 사용하는 와일드 카드
- % : 0개 이상 
- _ : 뒤에 무조건 1개
*/
select * from emp where ename like 'WAR_';













