-- hr

-- 1. 급여가 1500 이상인 직원들의 이름, 급여, 부서id를 조회
select last_name 이름, salary 급여, department_id 부서id
from employees
where salary >= 1500;

-- 2. 직원 중에서 연봉이 170000 이상인 직원들의 이름, 연봉 조회
--    연봉은 급여에 12를 곱한 값
select last_name 이름, salary*12 연봉
from EMPLOYEES
where salary*12 >= 170000;

-- 3. 직원 중에서 부서id가 없는 직원의 이름, 급여 조회
select last_name 이름, salary 급여
from EMPLOYEES
where department_id is null;

-- 4. 2004년 이전에 입사한 직원의 이름, 급여, 입사일 조회
--    이전은 기준 날짜 포함
select last_name 이름, salary 급여, HIRE_DATE 입사일
from EMPLOYEES
where HIRE_DATE <= '04-12-31';
