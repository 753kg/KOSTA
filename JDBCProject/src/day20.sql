-- 단일행함수 : 숫자관련, 문자관련, 날짜관련, 변환함수 (to_char, to_date, to_number)
select first_name, substr(first_name, 1, 3)
from employees;

select commission_pct, salary, salary+salary*nvl(commission_pct, 0) 급여
from employees;

-- 다중행함수 ..... null 무시한다.
select count(department_id) 건수3,count(commission_pct) 건수2, count(first_name) 건수, sum(salary) 급여총액, sum(commission_pct) 커미션합계
from employees;

select sum(salary), avg(salary), sum(salary)/count(salary), max(salary), min(salary)
from employees;

select salary
from employees
order by salary desc;

-- 가장 최근 입사일, 가장 오래된 입사일
select max(hire_date) 최근입사, min(hire_date) 오래된입사
from employees;

select hire_date
from employees
order by hire_date;

select count(*) "null포함", count(commission_pct) "null무시"
from employees;

select count(commission_pct), count(*)
from employees
where department_id = 80;

select *
from employees
where department_id is null and commission_pct is not null;

select *
from departments;

-- 직원들이 근무하는 부서들
-- distinct : 중복제외
-- count : null 제외
select count(distinct department_id)
from employees;

select count(distinct job_id)
from employees;

-- 그룹함수
-- 그룹함수를 사용하지않은 컬럼은 반드시 group by 절에 참여한다.
select department_id, max(first_name), sum(salary)
from employees
group by department_id
order by 1;
-- 첫번째 컬럼으로 정렬, null은 마지막에 나옴

select first_name, salary
from employees
where department_id = 20
order by 1 desc;

-- department_id는 107개, max, sum은 1개라 같이 출력할수없음
-- 집계함수를 사용하지 않은 컬럼은 반드시 group by에 들어가야한다.
select department_id, max(first_name), sum(salary)
from employees;

-----------------------------------------------------------------------------
/* 7. 각 부서별 인원수를 조회하되 인원수가 5명 이상인 부서만 출력되도록 하시오. */
-- 작성순서 : select -> from -> where -> group by -> having -> order by
-- 해석순서 : from -> where -> group by -> having -> select -> order by
select department_id, count(*)
from employees
where department_id <= 100
group by department_id
having count(*) >= 5
order by 1;

-- 부서별 급여 평균 구하기
select department_id, avg(salary) sal_avg
from employees
group by department_id
having avg(salary) >= 10000
order by sal_avg desc;
-- having에 sal_avg는 불가능.
-- 순서가 having -> select 이기 때문이다. 

select department_id, max(salary) sal_max, min(salary) sal_min
from employees
group by department_id
having max(salary) >= 10000 and min(salary) >= 10000;

/* 8. 각 부서별 최대급여와 최소급여를 조회하시오.
   단, 최대급여와 최소급여가 같은 부서는 직원이 한명일 가능성이 높기때문에 
   조회결과에서 제외시킨다. */
select department_id, max(salary) sal_max, min(salary) sal_min
from employees
group by department_id
having max(salary) <> min(salary);

select *
from employees
where department_id in (10, 40) or department_id is null;


   
/* 9. 부서가 50, 80, 110 번인 직원들 중에서 급여를 5000 이상 24000 이하를 받는
   직원들을 대상으로 부서별 평균 급여를 조회하시오.
   다, 평균급여가 8000 이상인 부서만 출력되어야 하며, 출력결과를 평균급여가 높은
   부서면저 출력되도록 해야 한다. */
select department_id, avg(salary)
from employees
where department_id in (50, 80, 110) and salary between 5000 and 24000
group by department_id
having avg(salary) >= 8000
order by 2 desc;

----------------------------------------------------------------------

-- 1) 부서아이디 찾기
select department_id
from employees
where first_name = 'Steven' and last_name = 'King';
-- 2) 찾은 아이디로 부서이름 찾기
select *
from departments
where department_id = 90;

-- 서브쿼리
select *
from departments
where department_id = (select department_id
                        from employees
                        where first_name = 'Steven' and last_name = 'King');
                        
-- 조인
select *
from employees, departments;
-- employees의 건수 * departments의 건수 => 107 * 27 만큼의 행이 인출됨

-- null 제외하고 인출됨
-- 1) 가장 일반적인 문법, DB 벤더 문법
select first_name, salary, department_name
from employees, departments
where employees.department_id = departments.department_id;

-- 2) 표준문법
select first_name, salary, department_name
from employees join departments using(department_id);


-- employees 컬럼 11개, 건수 107개
-- departments 컬럼 4개, 건수 27개
-- cross join => 컬럼 15개, 건수 107*27개 
select *
from departments, employees;

-- equi join
select department_id
from departments join employees using(department_id);

-- 모호하다
select department_id
from departments, employees
where departments.department_id = employees.department_id;

select employees.*, departments.department_name
from departments, employees
where departments.department_id = employees.department_id;

------------------------------------------------------------
[customer정보]
id (cust_id)
name
address

[orderInfo정보]
id (주문아이디)
title
price
cust_id

[틀림] 컬럼 이름이 같은 경우에만 이렇게 사용
select *
from customer join orderInfo using(id);

[맞는 표준문법] 컬럼이 다른 경우 using 대신 사용.
select *
from customer join orderInfo on (customer.id = orderInfo.cust_id);

[벤더문법] 이렇게 많이 쓴다.
select *
from customer, orderInfo
where customer.id = orderInfo.cust_id;
-----------------------------------------------------------------------

[employees, departments]
[벤더문법]
select employees.*, department_name
from employees, departments
where employees.department_id = departments.department_id;

[잘못] employees.* => department_id는 employees 거라고 할 수 없어서
select employees.*, department_name
from employees join departments using(department_id);

[맞음]
select department_id, first_name, salary, department_name
from employees join departments using(department_id);

-- table 이름에 별명 지정 (Alias)
select e.*, department_name, d.department_id
from employees e join departments d
on e.department_id = d.department_id
where salary >= 15000;


/*---------------- L A B -----------------------
========================================
		JOIN
========================================*/

1.직원들의 이름과 직급명(job_title)을 조회하시오.
-- 벤더 문법
select employees.first_name, jobs.job_title
from employees, jobs
where employees.job_id = jobs.job_id;

-- 표준 문법
select first_name, last_name, job_title
from employees join jobs using(job_id);

select employees.first_name, jobs.job_title
from employees join jobs
on employees.job_id = jobs.job_id;


2.부서이름과 부서가 속한 도시명(city)을 조회하시오.
select department_name, city
from departments ,locations 
where departments.location_id = locations.location_id;              

-- ANSI 표준 문법
select department_name, city
from departments join locations using(location_id);
-- 부서가 location을 참조했으므로 부서 건수 만큼 나와야한다.

3. 직원의 이름과 근무국가명을 조회하시오. (employees, departments, locations,countries)
select first_name, country_name
from employees, departments, locations, countries
where employees.department_id = departments.department_id
and departments.location_id = locations.location_id
and locations.country_id = countries.country_id;
-- 직원이 참조하므로 직원 수 만큼, department_id 가 null 인 것은 제외됨.

select first_name, country_name
from employees join departments using(department_id)
    join locations using(location_id)
    join countries using(country_id);
    
select first_name, country_name
from employees join departments on (employees.department_id = departments.department_id)
    join locations on (departments.location_id = locations.location_id)
    join countries on (locations.country_id = countries.country_id);


4. 직책(job_title)이 'manager' 인 사람의 이름, 직책, 부서명을 조회하시오.
 select first_name, department_name, job_title
 from employees, jobs, departments
 where employees.job_id = jobs.job_id
 and employees.department_id = departments.department_id
  and lower(job_title) like '%manager';
  --and substr(jobs.job_title, -7) = initcap('manager');
 --
 -- like보다 = 이 빠르다.
 -- 연산자는 =이 좋다.
 -- 컬럼에 함수 안쓰는게좋다.
 
 -- 입사연도 조회 to_char(hire_date, 'yyyy')
 
select first_name, department_name
 from employees join jobs using(job_id)
    join departments using(department_id)
 where instr(job_title, initcap('manager')) > 0;      


5. 직원들의 이름, 입사일, 부서명을 조회하시오.
select first_name, hire_date, department_name
 from employees, departments
 where employees.department_id = departments.department_id
 and hire_date >= '2005/01/01';                 -- 인덱스 쓴거 ==> 더 좋다.
 -- and to_char(hire_date, 'yyyy') >= 2005      -- 인덱스 안쓴거

 select first_name, hire_date, department_name
 from employees join departments using(department_id);


6. 직원들의 이름, 입사일, 부서명을 조회하시오.
단, 부서가 없는 직원이 있다면 그 직원정보도 출력결과에 포함시킨다.
-- 벤더 문법
-- outer join ==? oracle 문법 ==> (+) : 없는 곳에 보태준다.
-- 직원에는 있는데 부서에 없으니까
select first_name, hire_date, department_name
from employees, departments
where employees.department_id = departments.department_id(+);

-- 표준문법
-- join = inner join    ==> inner 생략 가능
select first_name, hire_date, department_name
from employees inner join departments
on employees.department_id = departments.department_id;

-- outer join : left, right 기준을 정한다. 기준으로 나머지는 없어도 나온다.
-- 조건에 안맞아도 employees에 있으면 나온다.
-- employees가 기준이면 left
select first_name, hire_date, department_name
from employees left outer join departments
on employees.department_id = departments.department_id;
-- right
select first_name, hire_date, department_name
from departments right outer join employees
on employees.department_id = departments.department_id;

-- 양쪽 다 기준. 어느 한 쪽에라도 있었으면 나옴
select first_name, hire_date, department_name
from departments full outer join employees using(department_id);
-- on employees.department_id = departments.department_id;

select first_name, hire_date, department_name
from departments join employees
on employees.employee_id = departments.manager_id;
-- manager_id : 부서장이 있다.
-- manager_id는 employee_id 이므로 manager_id가 employee_id를 참조했다.
-- 부서가 직원을 참조함 ==> 건수는 부서 건수와 같다.
-- ==> 부서장만 인출됨????
select * from employees;
select * from departments;

-- 부서장이 없어도 인출됨
select first_name, hire_date, department_name
from departments join employees
on employees.employee_id(+) = departments.manager_id;

select first_name, hire_date, department_name
from departments left outer join employees
on employees.employee_id = departments.manager_id;

-- 직원정보 : 직원번호, 직원이름, 부서번호 ( 직원이 부서에 근무한다는 관계, 부서를 참조한다)
-- employee 테이블의 manager_id = 상사 (직원아이디를 참조)
-- 부서정보 : 부서번호, 부서이름, 위치, 대표번호, 부서장(직원번호, 직원의 id를 참조한다)

7. 직원의 이름과 직책(job_title)을 출력하시오.
단, 사용되지 않는 직책이 있다면 그 직책정보도 출력결과에 포함시키시오.
-- employees가 jobs를 참조
-- jobs 테이블에는 있는데 employees에서 한번도 참조하지 않았던 것을 출력
select first_name, job_title
from employees right outer join jobs using(job_id);

select * from jobs;

insert into jobs values('play', '매일매일 놀아요', 5000, 10000);

-------------------------------------------------------------------
select first_name, salary from employees;

create table salgrade ( grade char(1), minsal number, maxsal number);
insert into salgrade values( 'A', 0, 5000 );
insert into salgrade values( 'B', 5001, 8000 );
insert into salgrade values( 'C', 8001, 10000 );
insert into salgrade values( 'D', 10001, 15000 );
insert into salgrade values( 'E', 15001, 25000 );

select * from salgrade;
select * from employees order by salary desc;

-- non-equi join
select *
from employees join salgrade
on employees.salary between salgrade.minsal and salgrade.maxsal; 

-- self join
select 직원.manager_id, 직원.first_name, 매니저.employee_id, 매니저.first_name
from employees 직원 left outer join employees 매니저
on 직원.manager_id = 매니저.employee_id;

---------self join lab --------------
1. 직원의 이름과 관리자 이름을 조회하시오.
select 직원.first_name 직원, 관리자.first_name 관리자
from employees 직원, employees 관리자
where 직원.manager_id = 관리자.employees_id



2. 직원의 이름과 관리자 이름을 조회하시오.
관리자가 없는 직원정보도 모두 출력하시오.
select 직원.first_name 직원, 관리자.first_name 관리자
from employees 직원 left outer join employees 관리자
on 직원.manager_id = 관리자.employee_id;


3. 관리자 이름과 관리자가 관리하는 직원의 수를 조회하시오.
단, 관리직원수가 3명 이상인 관리자만 출력되도록 하시오.
select employee_id,first_name  from employees;

select 관리자.first_name, count(직원.employee_id)
from employees 직원, employees 관리자
where 직원.manager_id = 관리자.employee_id
group by 관리자.first_name
having count(직원.employee_id) >= 3;




