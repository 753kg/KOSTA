--부서정보 모두 보기
select * from DEPARTMENTS;
--직원정보 모두보기
--HR거
--한문장씩 실행
select * from EMPLOYEES;
select * from DEPARTMENTS;
--SCOTT꺼
select * from EMP;	

-- 컬럼 2개짜리 테이블 만들기
create table kosta_student(
	id number,
	name varchar2(30)
	-- 최대 30byte
);

select * from tab;

-- desc : 내림차순, asc : 오름차순
select * from departments order by department_id desc;
select * from departments order by department_id asc;

select to_char(HIRE_DATE,'yyyy-mm-dd') from employees;

-- distinct : 중복 제거
select distinct DEPARTMENT_ID from employees;

-- * : 모든컬럼
select * from employees;
-- null : 값이 없다.
select * from employees where department_id is null;

-- 특정 컬럼 나열
select employee_id, first_name from employees;
-- 특정 컬럼 나열.. 별명 부여
select employee_id 직원번호, first_name 성 from employees;

-- 연산식
select employee_id 직원번호, first_name 성, 10+20 계산 from employees;
-- || : concate 연산자
select employee_id 직원번호, first_name||last_name "전체 이름" from employees;

-- 자바
-- 'A' : char, 		"자바" : String

-- ORACLE
-- "" : 컬럼이름 or 테이블 이름,		'':값
-- "" -> 대소문자 구별한다.
select first_name from "employees";
select "first_name" from employees;

-- ORACLE dictionary table의 내용은 대문자
select first_name from "EMPLOYEES";

-- "" 안쓰면 대소문자 구분 안함 ==> "" 안쓰는게 가장 좋다.
select first_name from eMPLOYEES;

-- ''는 값을 의미
select first_name from 'eMPLOYEES';

-- || : + 같은 느낌 
select employee_id 직원번호, first_name||' '||last_name "전체 이름" from employees;

-- invalid identifier : 유효하지 않은 식별자(컬럼이름, 테이블이름)
select employee_id 직원번호, first_name||" "||last_name "전체 이름" from employees;

-- 조건 : first_name이 Steven인 사람
-- 조건 ==> where
-- ''안쓰면 식별자가 됨. 값은 ''를 꼭 붙이기
select 
* from EMPLOYEES 
where first_name = 'Steven';

-- nvl() : null인지? null값을 변경.
-- commission_pct가 null이면 0으로 바꾼다.
-- as 써도되고 안써도됨
select salary, salary * 0.1 세금, 
		commission_pct, salary+salary*nvl(commission_pct, 0) as "내가 받을 수령액"
from EMPLOYEES;

select distinct job_id from EMPLOYEES;

-- 작성 순서 : select -> from -> where -> order by
-- 해석 순서 : from -> where -> select -> order by
-- sudo : 가짜컬럼. 실제로 존재하지 않음. ex) rownum
-- 같지 않다 : != or <> or ^=
-- 같다 : =
select rownum, first_name, hire_date, salary, department_id
from EMPLOYEES
where salary = 17000 and department_id != 80
order by salary;

-- table 조회 ==> desc emp;
select EMPNO, ENAME, SAL
from EMP
where SAL <= 1500;

select EMPNO, ENAME, SAL
from EMP
where ENAME = 'FORD';

select EMPNO, ENAME, SAL, HIREDATE
from EMP
where HIREDATE <= '82-01-01';


-- defualt date format : RR/MM/DD
-- RR : 50 이상이면 1900년대, 미만이면 2000년대
-- 파라미터값 확인
select * from nls_session_parameters;

-- date format 바꾸기 --> session 끝나면 유지가 안된다. --> SQL*Plus에서 실습
alter session set nls_date_format = 'yyyy-mm-dd';

select EMPNO, ENAME, SAL, HIREDATE
from EMP
where to_char(HIREDATE, 'RR/MM/DD') <= '82-01-01';

-- oracle 계정 확인하기
select * from all_users;