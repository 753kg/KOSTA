-- 1. 뉴욕에서 근무하는 사원의 이름과 급여를 출력하시오.
select * from emp;
select * from dept;
-- subquery
select ename, sal
from EMP 
where deptno = (
                select deptno from dept
                where loc = 'NEW YORK' );

-- equi join : oracle 문법                
select ename, sal
from emp, dept
where emp.deptno = dept.deptno and dept.loc = 'NEW YORK';

-- equi join : 표준문법. using 사용. 컬럼 이름이 같을 경우
select ename, sal
from EMP join DEPT using(deptno)
where loc = 'NEW YORK';

-- equi join : 표준문법. on 사용. 컬럼 이름이 다를 경우
select ename, sal
from EMP join DEPT on (emp.deptno = dept.deptno)
where loc = 'NEW YORK';

-- 2. ACCOUNTING 부서 소속 사원의 이름과 입사일을 출력하시오
select ename, hiredate
from EMP join DEPT using(deptno)
where dname = 'ACCOUNTING';


-- 3. 직급이 MANAGER인 사원의 이름, 부서명을 출력하시오.
select ename, dname
from emp join dept using(deptno)
where job = 'MANAGER';

-- ppt 7장 Non-equi join
select * from emp;
select * from salgrade;

select ename, sal, grade
from emp, salgrade
where emp.sal between losal and hisal;

-- ppt 7장 self join
select 직원.ename, 매니저.ename
from emp 직원, emp 매니저
where 직원.mgr = 매니저.empno;

