-- ppt ch2 scott
-- 1. 사원에 관련된 정보를 모두 살펴보기 위한 쿼리문을 작성해 보시오.
-- <힌트> 사원 테이블의 이름은 emp입니다
select * from emp;

-- 2. 사원의 이름과 급여와 입사일자만을 출력하는 SQL 문을 작성해 보시오.
-- <힌트> 사원 정보가 저장된 테이블의 이름은 EMP이고, 사원이름 칼럼은 ENAME, 급여 칼럼은 SAL, 입사일자 칼럼은 HIREDATE입니다.
select ename, sal, hiredate
from EMP;

-- 3. 별칭 지정
select deptno 부서번호, dname 부서명
from dept;

-- 4. 중복 제거
select distinct job
from emp;