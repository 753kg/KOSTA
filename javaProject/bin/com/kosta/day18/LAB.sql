
hr/hr
========================================
		SELECT 기본
========================================
select * from employees;

1. 급여가 15000 이상인 직원들의 이름, 급여, 부서id를 조회하시오.
select first_name, last_name, salary, department_id
from employees
where salary >= 15000;

2. 직원 중에서 연봉이 170000 이상인 직원들의 이름, 연봉을 조회하시오.
   연봉은 급여(salary)에 12를 곱한 값입니다.
select first_name, last_name, salary*12 연봉
from employees
where salary*12 >= 170000;

3. 직원 중에서 부서id가 없는 직원의 이름과 급여를 조회하시오.
select first_name, last_name, salary
from employees
where department_id is null;

4. 2004년 이전에 입사한 직원의 이름, 급여, 입사일을 조회하시오.
select first_name, last_name, salary, hire_date
from employees
where hire_date <= '2004/12/31';
--> 가장좋은방법 : hire_date index(목차)를 사용해서 찾기때문에 가장 빠르다.
-- index가 있다면(목차로 만들어져있다면) 조작하지 않는 것이 바람직하다.
-- 함수를 이용해서 조작하면 index 미사용 --> 검색속도 느려짐.
-- 다른방법
-- where substr(hire_date, 1, 2) <= '04';
-- where to_char(hire_date, 'yyyy') <= '2004';

-- 논리연산자 -- 
1. 80, 50 번 부서에 속해있으면서 급여가 13000 이상인 직원의 이름, 급여, 부서id
를 조회하시오.
select first_name, last_name, salary, department_id
from employees
where department_id in (80, 50) and salary >= 13000;

2. 2005년 이후에 입사한 직원들 중에서 급여가 1300 이상 20000 이하인 직원들의 
이름, 급여, 부서id, 입사일을 조회하시오.
-- where 연산 순서는 oracle이 정한다. 성능과 상관없다.
select first_name, last_name, salary, department_id
from employees
where hire_date >= '2005/01/01' and salary between 1300 and 20000;

3. 2005년도 입사한 직원의 정보만 출력하시오.
select *
from employees
where hire_date between '2005/01/01' and '2005/12/31';
-- where to_char(hire_date, 'yyyy') = 2005;

4. 이름이 D로 시작하는 직원의 이름, 급여, 입사일을 조회하시오.
select first_name, last_name, salary, hire_date
from employees
where last_name like 'D%';

5. 12월에 입사한 직원의 이름, 급여, 입사일을 조회하시오.
select first_name, last_name, salary, hire_date
from employees
where hire_date like '__/12/__';
-- where to_char(hire_date, 'mm') = '12';

6. 이름에 le 가 들어간 직원의 이름, 급여, 입사일을 조회하시오.
select first_name, last_name, salary, hire_date
from employees
where last_name like '%le%';

7. 이름이 m으로 끝나는 직원의 이름, 급여, 입사일을 조회하시오.
select first_name, last_name, salary, hire_date
from employees
where last_name like '%m';

8. 이름의 세번째 글자가 r인 이름, 급여, 입사일을 조회하시오.
select first_name, last_name, salary, hire_date
from employees
where last_name like '__r%';

9. 커미션을 받는 직원의 이름, 커미션, 급여를 조회하시오.
select first_name, last_name, commission_pct, salary
from employees
where commission_pct is not null;

10. 커미션을 받지 않는 직원의 이름, 커미션, 급여를 조회하시오.
select first_name, last_name, commission_pct, salary
from employees
where commission_pct is null;

-- 2000년대 : 2000 ~ 2009년
11. 2000년대에 입사해서 30, 50, 80 번 부서에 속해있으면서, 
급여를 5000 이상 17000 이하를 받는 직원을 조회하시오. 
단, 커미션을 받지 않는 직원들은 검색 대상에서 제외시키며, 먼저 입사한 직원이 
먼저 출력되어야 하며 입사일이 같은 경우 급여가 많은 직원이 먼저 출력되록 하시오.
-- 'cc' : 세기
select *
from employees
where to_char(hire_date, 'yyyy') between '2000' and '2009'
and department_id in (30, 50, 80)
and salary between 5000 and 17000
and commission_pct is not null
order by hire_date, salary desc;




========================================
		단일행 함수
========================================

1. 이름이 'adam' 인 직원의 급여와 입사일을 조회하시오.
select salary, hire_date, first_name
from employees
where first_name = initcap('adam');
-- initcap : 첫번째자리를 대문자로

select salary, hire_date, first_name
from employees
where lower(first_name) = 'adam';
-- lower : 소문자로


2. 나라 명이 'united states of america' 인 나라의 국가 코드를 조회하시오.
select country_id
from countries
where lower(country_name) = 'united states of america';


3. 'Adam의 입사일은 95/11/02 이고, 급여는 7000 입니다.' 이런 식으로 직원
정보를 조회하시오.
select first_name||'의 입사일은 '||hire_date||' 이고, 급여는 '||salary||' 입니다.'
from employees;

4. 이름이 5글자 이하인 직원들의 이름, 급여, 입사일을 조회하시오.
select first_name, salary, hire_date
from employees
where length(first_name) <= 5;
-- like는 5글자인것만 나오게되서 안된다.

5.2006년도에 입사한 직원의 이름, 입사일을 조회하시오.
select first_name, hire_date
from employees
where to_char(hire_date, 'yyyy') = '2006';

6. 15년 이상 장기 근속한 직원들의 이름, 입사일, 급여, 근무년차를 조회하시오.
select first_name, hire_date, salary, 
        (sysdate - hire_date)/365 일자계산,
        months_between(sysdate, hire_date)/12 근무년차
from employees
where months_between(sysdate, hire_date)/12 >= 15;

select first_name, last_name, salary
from employees
where employee_id = 100;

select * from employees;

