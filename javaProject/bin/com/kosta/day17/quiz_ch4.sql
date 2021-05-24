-- ppt ch3 scott
-- 1. 급여가 1500 이하인 사원의 사원번호, 사원 이름, 급여를 출력하는 SQL 문을 작성해 보시오.
-- <힌트> 사원 정보가 저장된 테이블의 이름은 EMP이고, 사원번호 컬럼은 EMPNO, 사원이름 칼럼은 ENAME, 급여 칼럼은 SAL입니다.
select empno, ename, sal
from emp
where sal <= 1500;

-- 2. 사원이름이 SCOTT 인 사원의 사원번호, 사원 이름, 급여를 출력하는 SQL 문을 작성해 보시오.
select empno, ename, sal
from emp
where ename = 'SCOTT';

-- 3. 부서번호는 DEPTNO로, 부서명은 DNAME으로 정해져 있으므로 
-- 다음과 같은 쿼리문의 결과는 왼쪽 그림과 같이 컬럼 헤딩에도 역시 DEPTNO, DNAME으로 출력됩니다. 
-- 7521 이거나 7654 이거나 7844 인 사원들의 사원 번호와 급여를 검색하는 쿼리문을 비교 연산자와 OR 논리 연산자 사용하여 작성하시오.
select empno 사원번호, sal 급여
from emp
where empno = 7521 or deptno = 7654 or deptno = 7844;