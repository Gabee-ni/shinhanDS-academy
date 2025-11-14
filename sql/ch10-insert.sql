-- rownum 
-- 페이징 처리 
select *
from(
    select 
    a.empno, a.ename, rownum
    from (
        select empno, ename
        from emp 
    order by hiredate DESC
    )a
)b
where b.rn between 11 and 20;

/*
1 페이지 : between 1 and 10
2 페이지 : between 11 and 20

시작 값 : (페이지 번호 -1) * 페이징 당 개수 + 1
끝 값 : 페이지 당 개수 * 페이지 번호 
*/

-----------------------insert-------------------------------------------

--10-1
create table dept_temp as select * from dept; -- 데이터만 복사가 되고 제약조건은 복사가 안 됨. 

insert into dept_temp (deptno, dname, loc) values(50,'DATABASE','SEOUL'); -- 컬럼명은 생략 가능. values 순서 중요 
insert into dept_temp values(60,'DATABASE','SEOUL');
insert into dept_temp (dname,loc, deptno) values('DATABASE','SEOUL',70); -- 컬럼명 지정 시 values 순서 중요X

desc dept_temp;

insert into dept_temp(deptno, dname, loc)
values (90,'MOBILE','');

select * from dept_temp;

insert into dept_temp(deptno, dname, loc) --자바와 달리 빈 문자열도 null로 인식
values (90,'WEB',null);

-- 10-7
insert into dept_temp (deptno, loc) values (91,'INCHEON');

--insert into dept(deptno, loc) values (null,'INCHEON'); -- deptno가 pk여서 null 허용 X

-- 10-8
create table emp_temp as select * from emp where 1 <> 1; -- emp와 스키마 구조는 같지만, 데이터는 복사하고 싶지 않을 때 사용 <>  -> 각 행을 조건식에 대입한 결괏값이 항상 false 가 되어 입력 X

select * from emp_temp;

-- 10-9
insert into emp_temp (empno, ename, job, mgr, hiredate, sal, comm, deptno) 
values(9999,'홍길동', 'PRESIDENT', null, '2001/01/01', 5000, 1000, 10);

insert into emp_temp (empno, ename, job, mgr, hiredate, sal, comm, deptno) 
values(1111,'성춘향', 'MANAGER', 9999, '2001-01-05', 4000,null , 20);

-- 10-13
insert into emp_temp (empno, ename, job, mgr, hiredate, sal, comm, deptno) -- 입력 값이 들어올 때의 시간을 저장 -> sysdate 
values(3111,'심청이', 'MANAGER', 9999, sysdate, 4000, null, 30);


select to_char(hiredate, 'yyyy-mm-dd hh24:mi:ss') from emp_temp;

-- 서브쿼리로 여러 데이터를 한 번에 insert
-- insert into 테이블 명 (컬럼명,,,) 서브쿼리(select ...~ ) -> values 절은 사용하지 않음. 

/*
insert 문의 구조 
insert into 테이블명 (컬럼명, ...) values(값, ...) 
*/

create table dept_temp2  as select * from dept;
select * from dept_temp2;

------------------update-----------------

/*
update 문의 구조
update 테이블명 set 컬럼명= 값, 컬럼명=값, .... where 조건 
-> update로 데이터 유실되는 것을 방지하기 위해 조건 필수!!!!!! 

*/

-- 10-16
update dept_temp2 set loc='SEOUL'; -- where 조건 X -> 모든 행에 적용 
--트랜잭션 실행됨. -> 화면에서는 변경되었지만 커밋 전이라서 실제 db 데이터는 남아 있음. 

rollback; -- 작업취소. 실제 DB를 되돌리기 보다는 작업 취소~ 

select * from dept_temp2;

-- 10-18
update dept_temp2 set loc='SEOUL', dname = 'DATABASE' where deptno = 40;

-- 10-19 -- 서브쿼리로 업데이트 가능 
update dept_temp2 set(dname, loc) = (select dname, loc from dept where deptno=40)
where deptno = 40;
-- 10-20
update dept_temp2
    set dname = (select dname from dept where deptno=40),
        loc = (select loc from dept where deptno=40)
where deptno=40;


------------------delete-----------------
create table emp_temp2 as select * from emp; 
select * from emp_temp2;

/*
delete 구조 
delete [from] 테이블 명 where 조건;
*/

-- 10-23
delete from emp_temp2
where job = 'MANAGER'; -- -> manager가 다 삭제 됨. => pk로 하는게 정확

select * from emp_temp2;



--------------------되새김 문제----------------------
create table ch10_emp as select * from emp;
create table ch10_dept as select * from dept;
create table ch10_salgrade as select * from salgrade;

--1 
insert into ch10_dept (deptno, dname, loc)
values (50,'ORACLE','BUSAN');

insert into ch10_dept (deptno, dname, loc)
values (60,'SQL','ILSAN');

insert into ch10_dept (deptno, dname, loc)
values (70,'SELECT','INCHEON');

insert into ch10_dept (deptno, dname, loc)
values (80,'DML','BUNDANG');

select * from ch10_dept;

--2
insert into ch10_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
values(7201,'TEST_USER1', 'MANAGER', 7788, '2016/01/02', 4500,null, 50);

insert into ch10_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
values(7202,'TEST_USER2', 'CLERK', 7201, '2016/02/21', 1800,null, 50);

insert into ch10_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
values(7203,'TEST_USER3', 'ANALYST', 7201, '2016/04/11', 3400,null, 60);

insert into ch10_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
values(7204,'TEST_USER4', 'SALSEMAN', 7201, '2016/05/31', 2700,300, 60);

insert into ch10_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
values(7205,'TEST_USER5', 'CLERK', 7201, '2016/07/20', 2600,null, 70);

insert into ch10_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
values(7206,'TEST_USER6', 'CLERK', 7201, '2016/09/08', 2600,null, 70);

insert into ch10_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
values(7207,'TEST_USER7', 'LECTURER', 7201, '2016/10/28', 2300,null, 80);

insert into ch10_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
values(7208,'TEST_USER8', 'STUDENT', 7201, '2016/03/09', 1200,null, 80);

select * from ch10_emp;

--3
update ch10_emp set deptno = 70
where empno in  (
      select empno 
        from ch10_emp
        where sal > (select AVG(sal) from ch10_emp where deptno=50)
);

--4;
update ch10_emp set
    deptno = 80,
    sal = sal * 1.1
where 
    empno in (
        select empno
        from ch10_emp
        where hiredate > (select min(hiredate) from ch10_emp where deptno=60)
    );

--5.
delete from ch10_emp
where empno in (
    select empno
    from ch10_emp e join salgrade s 
    on e.sal between s.losal and s.hisal
    and s.grade = 5
    );

select *  from ch10_emp;



















