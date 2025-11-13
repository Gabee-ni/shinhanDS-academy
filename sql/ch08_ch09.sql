/*
having
    - group by와 함께 사용
    - 그룹핑 후 조건 (where은 그룹핑 전 조건)
*/

-- 7-20 
select deptno, job, avg(sal)
from emp 
group by deptno, job
having avg(sal) >= 2000  --부서 별 직업 별로 묶었을 때 연봉이 2000 이상인 부서  
order by deptno, job;


select deptno, avg(sal)
from emp 
where sal >= 2000       -- 연봉이 2000 이상인 사람들을 부서별로 그루핑 한 것. 
group by deptno
order by deptno;

------------------되새김 문제-----------------
-----------------1--------------------
select deptno, trunc(avg(sal)) avg_sal, max(sal) max_sal, min(sal) min_sal, count(*) cnt
from emp 
group by deptno;

-----------------2----------------------
select job, count(*)
from emp 
group by job
having count(*) >= 3; -- having에는 alias 넣으면 안됨

-----------------3----------------------
-- 원래는 DB에 전체 날짜/연/월/일 각각 컬럼을 지정 -> 성능 좋음. 
select to_char(hiredate,'yyyy') hire_year, deptno, count(*) cnt 
from emp 
group by to_char(hiredate,'yyyy'), deptno;
--다른 방식
select substr(hiredate,1,4) hire_year, deptno, count(*) cnt
from emp 
group by substr(hiredate,1,4), deptno;

------------------4 ----------------------
select nvl2(comm, 'O','X') exist_comm, count(*) cnt
from emp 
group by nvl2(comm, 'O','X');

/*
집계함수 
    - null을 제외하고 연산을 함.
*/

---------------8장-----------------
-- 8-1
-- cross join : emp(14) * dept(4) = 56개의 결과가 출력 
select * from emp, dept
order by empno;

-- 8-2
select * from emp, dept
where emp.deptno = dept.deptno --FK (emp) == PK (dept) 등가 조인 
order by empno;

--alias 
select e.ename, e.deptno 
from emp e, dept d
where e.deptno = d.deptno
order by empno;

/*
등가조인(equi join)
    = Inner join (내부조인)   <-> Outer join (외부조인)    
*/
-- 8-6
select e.empno, e.ename, e.sal, d.deptno, d.dname, d.loc
from emp e, dept d
where e.deptno = d.deptno
and sal >= 3000;

-- 조인 조건 수 = 테이블 수 -1

--비등가조인
-- 8-7 
select *
from emp e, salgrade s 
where e.sal between s.losal and s.hisal;

--자체조인
-- 직원의 상사 번호 : 상사의 직원 번호 
-- 8-8
select e.empno, e.ename 직원명, e.mgr , m.empno, m.ename 상사명
from emp e, emp m 
where e.mgr = m.empno;



--외부조인 Outer join
/*
ANSI : 표준 방식 
조인
- , (컴마)를 join으로 
- where를 on으로 
*/
select 
    e.ename, e.deptno
from emp e join dept d
on e.deptno = d.deptno
order by e.empno;

-- 상사가 없는 직원도 포함 
-- 직원 테이블 e가 왼쪽 -> 따라서 left join
-- left (outer) join -> outer 생략 가능. left나 right가 있으면 무조건 outer, 없고 그냥 join이면 inner
select e.empno, e.ename 직원명, e.mgr , m.empno, m.ename 상사명
from emp e left join emp m 
on e.mgr = m.empno;

--right -> 부하직원이 없는 직원도 포함 
select e.empno, e.ename 직원명, e.mgr , m.empno, m.ename 상사명
from emp e right join emp m 
on e.mgr = m.empno;

--오라클 방식 
--조건문에 기준으로 join할 테이블이 아닌 다른 테이블에 (+)
select e.empno, e.ename 직원명, e.mgr , m.empno, m.ename 상사명
from emp e, emp m
where e.mgr = m.empno(+);



-- 8-14 
select e1.empno, e1.ename, e1.mgr, e2.empno mgr_empno, e2.ename mgr_ename
from emp e1 
left join emp e2 on e1.mgr = e2.empno
order by e1.empno;


------------------------되새김 문제------------------------
--1. 
select d.deptno, d.dname, e.ename, e.sal
from emp e 
join dept d on e.deptno = d.deptno
where e.sal >2000
order by d.deptno;

--오라클
select d.deptno, d.dname, e.ename, e.sal
from emp e , dept d
where e.deptno = d.deptno and e.sal >2000
order by d.deptno;

--2. 
select d.deptno, d.dname, TRUNC(AVG(NVL(sal,0))) avg_sal, MAX(sal) max_sal, MIN(sal) min_sal, count(*) cnt
from emp e 
join dept d
on e.deptno = d.deptno
group by d.deptno, d.dname
order by d.deptno;

--오라클
select d.deptno, d.dname, TRUNC(AVG(NVL(sal,0))) avg_sal, MAX(sal) max_sal, MIN(sal) min_sal, count(*) cnt
from emp e , dept d
where e.deptno = d.deptno
group by d.deptno, d.dname
order by d.deptno;


--3. 
select d.deptno, d.dname, e.ename,e.job, e.sal
from emp e 
right join dept d
on e.deptno = d.deptno
order by d.deptno;

--오라클
select d.deptno, d.dname, e.ename,e.job, e.sal
from emp e , dept d
where e.deptno(+) = d.deptno
order by d.deptno;



--4. ------------------------
select t2.deptno, t2.dname, t2.empno, t2.ename, t2.mgr, t2.sal, t2.deptno_1, t2.losal, t2.hisal, t2.grade, e2.empno mgr_empno, e2.ename mgr_ename
from (
        select t1.deptno, t1.dname, t1.empno, t1.ename, t1.mgr, t1.sal, t1.deptno_1, s.losal, s.hisal, s.grade
        from (
                select d.deptno deptno, d.dname, e.empno, e.ename, e.mgr, e.sal, e.deptno deptno_1
                from dept d left join emp e 
                on d.deptno = e.deptno
        )t1 left join salgrade s
        on t1.sal between s.losal and s.hisal
)t2 left join emp e2
on t2.mgr = e2.empno 
order by t2.deptno, t2.empno;

--오라클--------
--실행 순서 주의해서 (+) 붙이기 => 작성 순서에 따라 결과가 달라질 수 있음.  
select 
    d.deptno, d.dname, e1.ename, e1.mgr, e1.sal, e1.deptno, s.losal, s.hisal, s.grade, e2.empno mgr_empno, e2.ename mgr_ename
from dept d, emp e1, salgrade s, emp e2
where d.deptno = e1.deptno(+) -- d와 e1 먼저 left join
and e1.sal between s.losal(+) and s.hisal(+) -- 앞에서 JOIN된 전체 중간 결과 테이블을 기준으로 s를 left join -> 모든 s에 (+) 
and e1.mgr = e2.empno(+)  -- 앞에서 JOIN된 전체 중간 결과 테이블을 기준으로 e2 left join
order by d.deptno, e1.empno;


------강사님 풀이 --------
select 
    d.deptno, d.dname, e1.ename, e1.mgr, e1.sal, e1.deptno, s.losal, s.hisal, s.grade, e2.empno mgr_empno, e2.ename mgr_ename
from dept d 
left join emp e1
    on d.deptno = e1.deptno
left join salgrade s
    on e1.sal between s.losal and s.hisal
left join emp e2
    on e1.mgr = e2.empno 
order by d.deptno, e1.empno;


-- 9---------------------------
-- 9-1
select sal from emp where ename = 'JONES';

select * from emp where sal > (select sal from emp where ename = 'JONES');
--select * from emp where sal > (select sal from emp where ename like '%J%'); 
select * from emp where sal > (select max(sal) from emp where ename like '%J%'); 
                
-- 9-5
select e.empno, e.ename, e.job, e.sal, d.deptno, d.dname, d.loc
from emp e, dept d
where e.deptno = d.deptno
and e.deptno = 20
and e.sal > (select avg(sal) from emp);


-- in
select * from emp where deptno in (10);
select * from emp where deptno in (select deptno from dept where deptno<=20); --값이 10,20 여러개

select * from emp where sal > any (2000,3000); -- = min
select * from emp where sal > all (2000,3000); -- = max

-- 9-7 
select *
from emp 
where sal in (select max(sal) from emp group by deptno);

-- 9-19 인라인 뷰
select e10.empno, e10.ename, e10.deptno, d.dname, d.loc
from ( select * from emp where deptno =10) e10,
    (select * from dept) d
where e10.deptno = d.deptno;

select e10.empno, e10.ename, e10.deptno, d.dname, d.loc
from ( select * from emp where deptno =10) e10
join  (select * from dept) d
on e10.deptno = d.deptno;

-- with
-- 9-20
with 
e10 as ( select * from emp where deptno =10),
d as (select * from dept)
select e10.empno, e10.ename, e10.deptno, d.dname, d.loc
from e10,
    d
where e10.deptno = d.deptno;


-- 9-21
-- select 절에 있는 서브쿼리 (스칼라 서브쿼리)
-- 외곽 from 절의 테이블을 이용해서 서브쿼리에서 연산을 하고 있기에 해당 서브쿼리만 실행하면 오류남. 
-- 따라서 sql 실행이 길어짐. -> 조건이 각기 다르면 캐싱 효과가 떨어져서 성능이 저하됨. 
select empno, ename, job, sal,
    ( select grade 
    from salgrade
    where e.sal between losal and hisal) as salgrade,
    deptno,
    ( select dname
    from dept
    where e.deptno = dept.deptno) as dept
from emp e;

---------------되새김 문제-------
--1 
select e.job, e.empno, e.ename, e.sal, e.deptno, d.dname
from emp e 
join dept d
    on e.deptno = d.deptno 
where e.job = ( select job from emp where ename = 'ALLEN');

--2
select e.empno, e.ename, d.dname, e.hiredate, d.loc, e.sal, s.grade
from emp e ,dept d, salgrade s
where e.deptno = d.deptno 
and e.sal between s.losal and s.hisal 
and e.sal > (select AVG(NVL(sal,0)) from emp ) 
order by e.sal DESC, e.empno;

--3
select e.empno, e.ename, e.job, e.deptno, d.dname, d.loc
from emp e, dept d
where e.deptno = d.deptno 
and e.deptno = 10
and e.job not in (select job from emp where deptno =30);

--4 집계함수 사용
select e.empno, e.ename, e.sal, s.grade
from emp e, salgrade s
where e.sal between s.losal and s.hisal
and e.sal > (select MAX(sal) from emp where job = 'SALESMAN')
order by e.empno;

--4-1 다중행 함수 사용
select e.empno, e.ename, e.sal, s.grade
from emp e, salgrade s
where e.sal between s.losal and s.hisal
and e.sal > all (select sal from emp where job = 'SALESMAN')
order by e.empno;


