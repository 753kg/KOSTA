========================================
		SELECT 기본
========================================


1. 급여가 15000 이상인 직원들의 이름, 급여, 부서id를 조회하시오.
 select first_name, salary, department_id
 from employees
 where salary >= 15000;

2. 직원 중에서 연봉이 170000 이상인 직원들의 이름, 연봉을 조회하시오.
   연봉은 급여(salary)에 12를 곱한 값입니다.
 select first_name, salary*12 연봉
 from employees
 where salary*12 >= 170000;

3. 직원 중에서 부서id가 없는 직원의 이름과 급여를 조회하시오.
 select first_name, salary
 from employees
 where department_id is null;

4. 2007년 이전에 입사한 직원의 이름, 급여, 입사일을 조회하시오.
 select first_name, salary, hire_date
 from employees
 where hire_date < '2007/01/01';


-- 논리연산자 --
1. 80, 50 번 부서에 속해있으면서 급여가 13000 이상인 직원의 이름, 급여, 부서id
를 조회하시오.
 select first_name, salary, department_id
 from employees
 where department_id in (80, 50) and salary >= 13000;


2. 95년 이후에 입사한 직원들 중에서 급여가 1300 이상 20000 이하인 직원들의 
이름, 급여, 부서id, 입사일을 조회하시오.
select first_name, salary, department_id, hire_date
from employees
where hire_date >= '95/01/01' and salary between 1300 and 20000;


-- SQL 비교연산자 --
1. 80, 50 번 부서에 속해있으면서 급여가 13000 이상인 직원의 이름, 급여, 부서id
를 조회하시오.
 select first_name, salary, department_id
 from employees
 where department_id in (80, 50) and salary >= 13000;

2. 2005년 이후에 입사한 직원들 중에서 급여가 1300 이상 20000 이하인 직원들의 
이름, 급여, 부서id, 입사일을 조회하시오.
 select first_name, salary, department_id, hire_date
 from employees
 where hire_date >= '05/01/01' and salary between 1300 and 20000;


3. 2005년도 입사한 직원의 정보만 출력하시오.
 select *
 from employees
 where hire_date between '05/01/01' and '05/12/31';

4. 이름이 D로 시작하는 직원의 이름, 급여, 입사일을 조회하시오.
 select first_name, salary, hire_date
 from employees
 where first_name like 'D%';

5. 12월에 입사한 직원의 이름, 급여, 입사일을 조회하시오.
 select first_name, salary, hire_date
 from employees
 where to_char(hire_date, 'mm') = '12';

6. 이름에 le 가 들어간 직원의 이름, 급여, 입사일을 조회하시오.
 select first_name, salary, hire_date
 from employees
 where first_name like '%le%';

7. 이름이 m으로 끝나는 직원의 이름, 급여, 입사일을 조회하시오.
  select first_name, salary, hire_date
 from employees
 where first_name like '%m';

8. 이름의 세번째 글자가 d인 이름, 급여, 입사일을 조회하시오.
 select first_name, salary, hire_date
 from employees
 where first_name like '__d%';

9. 커미션을 받는 직원의 이름, 커미션, 급여를 조회하시오.
 select first_name, commission_pct, salary
 from employees
 where commission_pct is not null;

10. 커미션을 받지 않는 직원의 이름, 커미션, 급여를 조회하시오.
 select first_name, commission_pct, salary
 from employees
 where commission_pct is null;

11. 2000년대에 입사해서 30, 50, 80 번 부서에 속해있으면서, 
급여를 5000 이상 17000 이하를 받는 직원을 조회하시오. 
단, 커미션을 받지 않는 직원들은 검색 대상에서 제외시키며, 먼저 입사한 직원이 
먼저 출력되어야 하며 입사일이 같은 경우 급여가 많은 직원이 먼저 출력되록 하시오.
select *
from employees
where hire_date between '00/01/01' and '00/12/31'
and department_id in (30, 50, 80)
and salary between 5000 and 17000
and commission_pct is not null
order by hire_date asc, salary desc;



 ========================================
		단일행 함수
========================================

1. 이름이 'adam' 인 직원의 급여와 입사일을 조회하시오.
select salary, hire_date
from employees
where first_name = initcap('adam');

 
2. 나라 명이 'united states of america' 인 나라의 국가 코드를 조회하시오.
select country_id 
from countries 
where lower(country_name) = 'united states of america';

3. 'Adam의 입사일은 95/11/02 이고, 급여는 7000 입니다.' 이런 식으로 직원
정보를 조회하시오.
select first_name||'의 입사일은 '||hire_date||' 이고, 급여는 '||salary||' 입니다.'
from employees 

 
4. 이름이 5글자 이하인 직원들의 이름, 급여, 입사일을 조회하시오.
select first_name, salary, hire_date
from employees
where length(first_name) <= 5;
 
5. 96년도에 입사한 직원의 이름, 입사일을 조회하시오.
select first_name, hire_date
from employees
where hire_date between '96/01/01' and '96/12/31';


6. 20년 이상 장기 근속한 직원들의 이름, 입사일, 급여, 근무년차를 조회하시오.
select first_name, hire_date, salary, months_between(sysdate, hire_date)/12 근무년차
from employees
where months_between(sysdate, hire_date)/12 >= 20;




7. 각 부서별 인원수를 조회하되 인원수가 5명 이상인 부서만 출력되도록 하시오.
select department_name, count(department_id)
from departments
group by department_name
having count(department_id) >= 5;


8. 각 부서별 최대급여와 최소급여를 조회하시오.
   단, 최대급여와 최소급여가 같은 부서는 직원이 한명일 가능성이 높기때문에 
   조회결과에서 제외시킨다.
select department_id, min(salary), max(salary)
from employees
group by department_id
having min(salary) != max(salary);

   
9. 부서가 50, 80, 110 번인 직원들 중에서 급여를 5000 이상 24000 이하를 받는
   직원들을 대상으로 부서별 평균 급여를 조회하시오.
   다, 평균급여가 8000 이상인 부서만 출력되어야 하며, 출력결과를 평균급여가 높은
   부서면저 출력되도록 해야 한다.
select department_id, avg(salary)
from employees
group by department_id
having avg(salary) >= 8000
order by avg(salary) desc;


========================================
		JOIN
========================================

1.직원들의 이름과 직급명(job_title)을 조회하시오.
select first_name, job_title
from employees join jobs using(job_id);

2.부서이름과 부서가 속한 도시명(city)을 조회하시오.
select department_name, city
from departments join locations using(location_id);


3. 직원의 이름과 근무국가명을 조회하시오.
select first_name, country_name
from employees join departments using(department_id)
                join locations using(location_id)
                join countries using(country_id);


4. 직책(job_title)이 'manager' 인 사람의 이름, 직책, 부서명을 조회하시오.
select job_title from jobs;

select first_name, job_title, department_name
from employees, jobs, departments
where employees.job_id = jobs.job_id
and employees.department_id = departments.department_id
and lower(job_title) like '%manager';


5. 직원들의 이름, 입사일, 부서명을 조회하시오.
select first_name, hire_date, department_name
from employees join departments using(department_id);


6. 직원들의 이름, 입사일, 부서명을 조회하시오.
단, 부서가 없는 직원이 있다면 그 직원정보도 출력결과에 포함시킨다.
select first_name, hire_date, department_name
from employees left outer join departments using(department_id);

7. 직원의 이름과 직책(job_title)을 출력하시오.
단, 사용되지 않는 직책이 있다면 그 직책정보도 출력결과에 포함시키시오.
select first_name, job_title
from employees right outer join jobs using(job_id);


-- SELF JOIN
8. 직원의 이름과 관리자 이름을 조회하시오.
select 직원.first_name, 관리자.first_name
from employees 직원, employees 관리자
where 직원.manager_id = 관리자.employee_id;

9. 직원의 이름과 관리자 이름을 조회하시오.
관리자가 없는 직원정보도 모두 출력하시오.
select 직원.first_name, 관리자.first_name
from employees 직원 left outer join employees 관리자
on 직원.manager_id = 관리자.employee_id;


10. 관리자 이름과 관리자가 관리하는 직원의 수를 조회하시오.
단, 관리직원수가 3명 이상인 관리자만 출력되도록 하시오.
select * from employees;

select 관리자.first_name, count(직원.employee_id)
from employees 직원, employees 관리자
where 직원.manager_id = 관리자.employee_id
group by 관리자.first_name
having count(직원.employee_id) >= 3;


========================================
		SubQuery
========================================
1. 'IT'부서에서 근무하는 직원들의 이름, 급여, 입사일을 조회하시오.
select first_name, salary, hire_date
from employees
where department_id = (select department_id
                        from departments
                        where department_name = 'IT');  


2. 'Alexander' 와 같은 부서에서 근무하는 직원의 이름과 부서id를 조회하시오.
select first_name, department_id
from employees
where department_id in ( select department_id
                        from employees
                        where first_name = 'Alexander');

3. 직원들의 이름, 입사일, 부서명을 조회하시오.
단, 부서가 없는 직원이 있다면 그 직원정보도 출력결과에 포함시킨다.
그리고 부서가 없는 직원에 대해서는 '<부서없음>' 이 출력되도록 한다.
select first_name, hire_date, nvl(department_name, '<부서없음>')
from employees left outer join departments using(department_id);


4. 직원의 직책에 따라 월급을 다르게 지급하려고 한다.
직책에 'Manager'가 포함된 직원은 급여에 0.5를 곱하고
나머지 직원들에 대해서는 원래의 급여를 지급하도록 한다. 
적절하게 조회하시오.
select first_name, job_title, salary,
        case when job_title like '%Manager%' then salary*0.5
        else salary end as 급여
from employees join jobs using(job_id);

5. 각 부서별로 최저급여를 받는 직원의 이름과 부서id, 급여를 조회하시오.
select first_name, department_id, salary
from employees
where (department_id , salary) in (select department_id, min(salary)
                                    from employees
                                    group by department_id);


-- 연습문제
1. 80번부서의 평균급여보다 많은 급여를 받는 직원의 이름, 부서id, 급여를 조회하시오.
select first_name, department_id, salary
from employees
where salary >= (
                select avg(salary)
                from employees
                where department_id = 80 );

2. 'South San Francisco'에 근무하는 직원의 최소급여보다 급여를 많이 받으면서 
50 번부서의 평균급여보다 많은 급여를 받는 직원의 이름, 급여, 부서명, 
부서id를 조회하시오.


3. 각 직급별(job_title) 인원수를 조회하되 사용되지 않은 직급이 있다면 해당 직급도
출력결과에 포함시키시오. 그리고 직급별 인원수가 3명 이상인 직급만 출력결과에 포함시키시오.



4. 각 부서별 최대급여를 받는 직원의 이름, 부서명, 급여를 조회하시오.


5. 직원의 이름, 부서id, 급여를 조회하시오. 그리고 직원이 속한 해당 부서의 
최소급여를 마지막에 포함시켜 출력 하시오.

