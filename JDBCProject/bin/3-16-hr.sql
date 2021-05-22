-----review------------------------------------------------------
-- join : cross join, equi join, non-equi join, inner join, outer join, self join
-- join = inner join
-- 1. equi join
--  1) oracle 문법
select first_name, salary, job_title, min_salary, department_name, departments.department_id
from employees, jobs, departments
where employees.job_id = jobs.job_id
and employees.department_id = departments.department_id;

--  2) 표준문법(ANSI 표준)
select first_name, salary, job_title, min_salary, department_name, department_id
from employees join jobs using(job_id)
                join departments using(department_id);
                
select first_name, salary, job_title, min_salary, department_name, departments.department_id
from employees join jobs on employees.job_id = jobs.job_id
                join departments on employees.department_id = departments.department_id;
                
-- outer join
-- nvl(대상, null일때출력값) : 아닐 땐 그대로 나옴
-- nvl(대상, null아닐때, null일때)
select first_name, salary, job_title, min_salary, 
    nvl(department_name, '부서없음') 부서이름, 
    nvl2(departments.department_id, to_char(departments.department_id), '부서없음') 부서번호,
    nvl(to_char(departments.department_id), '부서없음') 부서번호2
from employees inner join jobs on employees.job_id = jobs.job_id
                left outer join departments on employees.department_id = departments.department_id;
                
select first_name, salary, job_title, min_salary, 
    nvl(department_name, '부서없음') 부서이름, 
    nvl2(departments.department_id, to_char(departments.department_id), '부서없음') 부서번호,
    nvl(to_char(departments.department_id), '부서없음') 부서번호2
from employees inner join jobs on employees.job_id = jobs.job_id
                full outer join departments on employees.department_id = departments.department_id;
            
            
select * from departments;    

-- 부서의 부서장 정보를 알고싶다 : 이름, 급여, 입사일
-- 부서가 기준 -> 부서가 참조했으니까 부서 건수만큼 나온다.
-- 부서장이 없는 부서도 나오게 -> 부서가 기준
select departments.*, employees.first_name, employees.salary, employees.hire_date
from departments left outer join employees on departments.MANAGER_ID = employees.EMPLOYEE_ID;

-- self join
select 직원.first_name, 직원.salary, 
    nvl(매니저.first_name, '매니저없음') 매니저이름, 
    nvl(매니저.salary, 0) 매니저급여
from employees 직원, employees 매니저
where 직원.manager_id = 매니저.employee_id(+);

select 직원.first_name, 직원.salary, 
    nvl(매니저.first_name, '매니저없음') 매니저이름, 
    nvl(매니저.salary, 0) 매니저급여
from employees 직원 left outer join employees 매니저
on 직원.manager_id = 매니저.employee_id;


-------수업---------------------
-- ppt 8장 서브쿼리
-- 서브쿼리 : select 안에 또 다른 select가 담겨있는 것

-- steven과 같은 부서에 근무하는 직원 조회
-- steven이 두명임
select *
from employees
where department_id in ( select department_id
                        from employees
                        where first_name = 'Steven' );
                        
-- Lex와 동일한 직급을 가진 사원을 출력
select *
from employees
where job_id = (
            select job_id
            from employees
            where first_name = 'Lex');
            
--Lex의 급여와 동일하거나 더 많이 받는 사원 명과 급여를 출력  
select *
from employees
where salary >= (
            select salary
            from employees
            where first_name = 'Lex')
and first_name != 'Lex';

-- 직속상관이 Steven인 사원의 이름과 급여를 출력
-- 다치불가 : 한건의 하나의 컬럼이 값을 여러개 가질 수 없다.
-- 다중행연산자 : in
select * from employees;

select *
from employees
where manager_id in (
                select employee_id
                from employees
                where first_name = 'Steven');
                
select 사원.*
from employees 사원 join employees 상관
on 사원.manager_id = 상관.employee_id
where 상관.first_name = 'Steven';
                
select *
from employees
where manager_id = 128;

-- 평균 급여보다 더 많은 급여를 받는 사원을 검색
select *
from employees
where salary >= (
            select avg(salary)
            from employees );
            
-- 급여가 10000 이상인 사람들의 부서에 근무하는 직원
-- in, = any : 아무거나 하나라도 같으면 된다.
select *
from employees
where department_id in (
                    select distinct department_id
                    from employees
                    where salary >= 10000 );
                    
select *
from employees
where department_id = any (
                    select distinct department_id
                    from employees
                    where salary >= 10000 );

-- = all : 모두 일치
select *
from employees
where department_id = all (
                    select distinct department_id
                    from employees
                    where salary >= 10000 );
                    
-- 부서별로 가장 급여를 많이 받는 사원의 정보(사원 번호, 사원이름, 급여, 부서번호)를 출력하시오.(IN 연산자 이용)
-- multi column subquery ==> in 연산자
select *
from employees
where ( department_id, salary ) in (
                                    select department_id, max(salary)
                                    from employees
                                    group by department_id );
            
-- 직급(JOB)이 MANAGER인 사람의 속한 부서의 부서 번호와 부서명과 지역을 출력
-- job_id = IT_PROG
-- 서브쿼리의 output이 한개
select * 
from departments
where department_id = (
                    select distinct department_id
                    from employees
                    where job_id = 'IT_PROG' );
-- 서브쿼리의 output이 여러개       
select * 
from departments
where department_id in (
                    select department_id
                    from employees
                    where job_id = 'IT_PROG' );
                    
select * 
from departments
where department_id = any (
                    select department_id
                    from employees
                    where job_id = 'IT_PROG' );
                    
-- > all : 최대보다 크다.
select *
from employees
where salary > all (
            select salary
            from employees
            where department_id = 60 ); 
            
-- > any : 최소보다 크다.
select *
from employees
where salary > any (
            select salary
            from employees
            where department_id = 60 ); 
            
-- 상관형 서브쿼리
-- 본인이 받는 급여가 본인이 속한 부서의 평균 급여보다 적은 급여를 받는 직원의 이름, 부서번호, 급여를 조회하시오.
select *
from employees aa
where salary < (
                select avg(salary)
                from employees
                where department_id = aa.department_id);

-- 가상의 테이블 만들기 (inline view) : from절에 select가 들어감
select *
from employees aa , ( select department_id, avg(salary) avg_sal
                    from employees
                    group by department_id) bb
where aa.department_id = bb.department_id
and aa.salary < bb.avg_sal;


-- 평균 급여보다 높고 최대 급여보다 낮은 원급을 받는 사원들을 조회하시오.
-- 스칼라 서브쿼리 : select 절에 select 쓰면 스칼라 서브쿼리
select employees.*, (select avg(salary) from employees), (select max(salary) from employees)
from employees
where salary > (select avg(salary) from employees)
and salary < (select max(salary) from employees);

-- inline view : from절에 select
select *
from employees, (select avg(salary) sal from employees) aa, (select max(salary) sal from employees) bb
where salary > aa.sal
and salary < bb.sal;

select *
from employees aa, (select avg(salary) 평균급여, max(salary) 최대급여
                    from employees) bb
where aa.salary between bb.평균급여 and bb.최대급여;

/* --------------------------------
            LAB
    ------------------------------ */
-- 1. 'IT'부서에서 근무하는 직원들의 이름, 급여, 입사일을 조회하시오.
-- 단일행서브쿼리
select first_name, salary, hire_date
from employees
where department_id = (
                        select department_id
                        from departments
                        where department_name = 'IT');

-- 2. 'Alexander' 와 같은 부서에서 근무하는 직원의 이름과 부서id를 조회하시오.
-- 다중행서브쿼리
select first_name, department_id
from employees
where department_id in (
                        select department_id
                        from employees
                        where first_name = 'Alexander');

-- 3. 직원들의 이름, 입사일, 부서명을 조회하시오.
-- 단, 부서가 없는 직원이 있다면 그 직원정보도 출력결과에 포함시킨다.
-- 그리고 부서가 없는 직원에 대해서는 '<부서없음>' 이 출력되도록 한다.
select first_name, hire_date, nvl(department_name, '<부서없음>')
from employees left outer join departments using(department_id);

-- 4. 직원의 직책에 따라 월급을 다르게 지급하려고 한다.
-- 직책에 'Manager'가 포함된 직원은 급여에 0.5를 곱하고
-- 나머지 직원들에 대해서는 원래의 급여를 지급하도록 한다. 
-- 적절하게 조회하시오.
select first_name, job_title, salary,
        decode(substr(job_title, -7, 7), 'Manager', salary*0.5, salary) 급여
from employees join jobs using(job_id);

select first_name, job_title, salary,
        case when job_title like '%Manager%' then salary*0.5
        else salary end as 급여
from employees join jobs using(job_id);

select first_name, job_title, salary,
        case when substr(job_title, -7, 7) = 'Manager' then salary*0.5
        else salary end as 급여
from employees join jobs using(job_id);


-- 5. 각 부서별로 최저급여를 받는 직원의 이름과 부서id, 급여를 조회하시오.
-- 다중컬럼 서브쿼리
select first_name, department_id, salary
from employees
where (department_id , salary) in (select department_id, min(salary)
                                    from employees
                                    group by department_id);
                        
-- inline view
select first_name, e.department_id, salary
from employees e, (select department_id, min(salary) 최저급여
                from employees
                group by department_id) aa
where e.department_id = aa.department_id
and e.salary = aa.최저급여;

-- 연습문제
-- 1. 80번부서의 평균급여보다 많은 급여를 받는 직원의 이름, 부서id, 급여를 조회하시오.
select first_name, department_id, salary
from employees
where salary >= (
                select avg(salary)
                from employees
                where department_id = 80);

--2. 'South San Francisco'에 근무하는 직원의 최소급여보다 급여를 많이 받으면서 
--50 번부서의 평균급여보다 많은 급여를 받는 직원의 이름, 급여, 부서명, 
--부서id를 조회하시오.
select * from locations;

select first_name, salary, department_name, department_id
from employees left outer join departments using(department_id)
where salary >= (
                select min(salary)
                from employees
                where department_id = (
                                        select department_id
                                        from departments join locations using(location_id)
                                        where city = 'South San Francisco'))
and salary >= (
                select avg(salary)
                from employees
                where department_id = 50);

--3. 각 직급별(job_title) 인원수를 조회하되 사용되지 않은 직급이 있다면 해당 직급도
--출력결과에 포함시키시오. 그리고 직급별 인원수가 3명 이상인 직급만 출력결과에 포함시키시오.
select * from jobs;

select job_title, count(employee_id)
from employees right outer join jobs using(job_id)
group by job_title
having count(employee_id) >= 3;


--4. 각 부서별 최대급여를 받는 직원의 이름, 부서명, 급여를 조회하시오.
select first_name, department_id, department_name, salary
from employees join departments using(department_id)
where (department_id, salary) in (
                                    select department_id, max(salary)
                                    from employees
                                    group by department_id);

--5. 직원의 이름, 부서id, 급여를 조회하시오. 그리고 직원이 속한 해당 부서의 
--최소급여를 마지막에 포함시켜 출력 하시오.
-- inline
select first_name, department_id, salary, bb.최소급여
from employees left outer join (select department_id ,min(salary) 최소급여
                    from employees
                    group  by department_id) bb using(department_id);

-- scala
select first_name, department_id, salary,
       (select min(salary)
        from employees
        where department_id = emp.department_id)
from employees emp;


==========================================
	Inline View 와 Top-N SubQuery
==========================================

1. 급여를 가장 많이 받는 상위 5명의 직원 정보를 조회하시오
select rownum, aa.*
from (select first_name, salary
    from employees
    order by salary desc) aa
where rownum <= 5;

select *
from(
    select rownum rr, aa.*
    from (select first_name, salary
        from employees
        order by salary desc) aa
    where rownum <= 5 )
where rr = 3;


2. 커미션을 가장 많이 받는 상위 3명의 직원 정보를 조회하시오.

select *
from (
    select first_name, commission_pct
    from employees
    order by commission_pct desc nulls last)
where rownum <= 3;


3. 월별 입사자 수를 조회하되, 입사자 수가 10명 이상인 월만 출력하시오.

select to_char(hire_date, 'mm') 월, count(*)
from employees
group by to_char(hire_date, 'mm')
having count(employee_id) >= 10
order by 1;

-- 인원수가 상위 3개만 조회
select *
from(
    select to_char(hire_date, 'mm') 월, count(*)
    from employees
    group by to_char(hire_date, 'mm')
    order by 2 desc)
where rownum <= 3;

4. 년도별 입사자 수를 조회하시오. 
단, 입사자수가 많은 년도부터 출력되도록 합니다.

select to_char(hire_date, 'yyyy') 년도, count(*)
from employees
group by to_char(hire_date, 'yyyy')
order by 2 desc;

-- 상위 3개만
select *
from (
    select to_char(hire_date, 'yyyy') 년도, count(*)
    from employees
    group by to_char(hire_date, 'yyyy')
    order by 2 desc)
where rownum <= 3;


<< 연습문제 >>
1. 'Southlake'에서 근무하는 직원의 이름, 급여, 직책(job_title)을 조회하시오.
select city from locations;

select first_name, salary, job_title
from employees join jobs using(job_id)
where employee_id in (
                select employee_id
                from employees join departments using(department_id) 
                                join locations using(location_id)
                where city = 'Southlake');

2. 국가별 근무 인원수를 조회하시오. 단, 인원수가 3명 이상인 국가정보만 출력되어야함.

select country_name, count(*)
from countries join locations using(country_id) 
                join departments using(location_id)
                join employees using(department_id)
group by country_name
having count(*) >= 3;


3. 직원의 이름, 급여, 직원의 관리자 이름을 조회하시오. 단, 관리자가 없는 직원은
   '<관리자 없음>'이 출력되도록 해야 한다.
select 직원.first_name, 직원.salary, nvl(관리자.first_name, '<관리자 없음>')
from employees 직원 left outer join employees 관리자 
on 직원.manager_id = 관리자.employee_id;


4. 직원의 이름, 부서명, 근무년수를 조회하되, 20년 이상 장기 근속자만 출력되록한다.
select first_name, department_name, hire_date, 
    months_between(sysdate, hire_date)/12 근무년수
from employees join departments using(department_id)
where  months_between(sysdate, hire_date)/12 >= 20;



5. 각 부서 이름별로 최대급여와 최소급여를 조회하시오. 단, 최대/최소급여가 동일한
   부서는 출력결과에서 제외시킨다.
select department_name, max(salary), min(salary)
from employees join departments using(department_id)
group by department_name
having max(salary) <> min(salary);


6. 자신이 속한 부서의 평균급여보다 많은 급여를 받는 직원정보만 조회하시오.
   단, 출력결과에 자신이 속한 부서의 평균 급여정보도 출력되어야한다. 

select e1.*, e2.평균급여
from employees e1 , (select department_id, avg(salary) 평균급여
                from employees
                group by department_id) e2
where e1.department_id = e2.department_id
and e1.salary > e2.평균급여


7. '월'별 최대급여자의 이름, 급여를 조회하시오.
select to_char(hire_date, 'mm') 월, first_name, salary
from employees
where (to_char(hire_date, 'mm'), salary) in ( select to_char(hire_date, 'mm'), max(salary)
                                            from employees
                                            group by to_char(hire_date, 'mm') )
order by 1;


8. 부서별, 직급별, 평균급여를 조회하시오. 
   단, 평균급여가 50번부서의 평균보다 많은 부서만 출력되어야 합니다.
select department_name, job_title, avg(salary)
from employees join jobs using(job_id)
                 join departments using(department_id)
group by department_name, job_title
having avg(salary) > (select avg(salary)
                        from employees
                        where department_id = 50)
order by 1, 2;


9. 자신의 관리자보다 많은 급여를 받는 직원의 이름과 급여를 조회하시오.
-- self join
select 직원.first_name 직원이름, 직원.salary 직원급여, 관리자.first_name 관리자이름, 관리자.salary 관리자급여
from employees 직원 join employees 관리자 on (직원.manager_id = 관리자.employee_id)
where 직원.salary > 관리자.salary

-- 상관 subquery
select first_name, salary
from employees e1
where salary > (select salary
                from employees
                where employee_id = e1.manager_id);

10. 급여가 가장 많은 직원 6번째부터 10번째 직원만 출력하시오.
select *
from( 
    select rownum rr, ee.*
    from (
        select *
        from employees
        order by salary desc) ee )
where rr between 6 and 10;

-- 6번째와 10번째만 가져오기
select *
from( 
    select rownum rr, ee.*
    from (
        select *
        from employees
        order by salary desc) ee )
where rr = 6 or rr = 10;


