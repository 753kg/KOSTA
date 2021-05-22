-------수업---------------------
-- ppt 8장 서브쿼리

-- smith의 부서이름을 알고싶다.
-- join 이용
select dname
from emp join dept using(deptno)
where ename = 'SMITH';

-- subquery 이용
select dname
from dept
where deptno = ( select deptno
                from emp
                where ename = 'SMITH' );
                
-- smith와 같은 부서에 근무하는 직원을 알고싶다.
-- subquery
select *
from emp
where deptno = ( select deptno
                from emp
                where ename = 'SMITH' );
                
-- join
select 동료.*
from emp 스미스 join emp 동료 on 스미스.deptno = 동료.deptno
where 스미스.ename = 'SMITH';

-- SMITH와 동일한 직급을 가진 사원을 출력
select * from emp;
select * from dept;

select * 
from emp
where job = ( select job
            from emp
            where ename = 'SMITH');

-- SMITH의 급여와 동일하거나 더 많이 받는 사원 명과 급여를 출력      
select ename, sal
from emp
where sal >= (
            select sal
            from emp
            where ename = 'SMITH');
            
-- DALLAS에서 근무하는 사원의 이름, 부서 번호를 출력
-- subquery : output이 emp만 가능
select ename, deptno
from emp
where deptno = (
            select deptno
            from dept
            where loc = 'DALLAS');
-- join : output이 emp, dept 모두 가능
select ename, deptno
from emp join dept using(deptno)
where loc = 'DALLAS';
                
-- 직속상관이 KING인 사원의 이름과 급여를 출력
select *
from emp
where mgr = (
            select empno
            from emp
            where ename = 'KING');
            
select 사원.*
from emp 사원 join emp 상관 on 사원.mgr = 상관.empno
where 상관.ename = 'KING';
                
                
-- 영업 사원들 보다 급여를 많이 받는 사원들의 이름과 급여와 직급(담당 업무)를 출력하되 영업 사원은 출력하지 않습니다
select * from emp;
select * from dept;

select *
from emp
where sal > any (
                select sal
                from emp
                where job = 'SALESMAN' )
and job <> 'SALESMAN';

select *
from emp
where sal >= all (
                select sal
                from emp
                where deptno = (
                                select deptno
                                from dept
                                where dname = 'SALES'))
and deptno <> (
                select deptno
                from dept
                where dname = 'SALES');
                
--영업 사원들의 최소 급여를 많이 받는 사원들의 이름과 급여와 직급(담당 업무)를 출력하되 영업 사원은 출력하지 않습니다.
select ename, sal, job
from emp
where sal >= (
            select min(sal)
            from emp
            where job = 'SALESMAN')
and job <> 'SALESMAN';