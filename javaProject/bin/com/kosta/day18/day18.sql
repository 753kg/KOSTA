-- 예약어 : 대소문자 구별X
-- rownum : select 하고 number 부여
-- 10000 <= salary <= 20000 (X)
select rownum, first_name, last_name, salary, hire_date
from EMPLOYEES
where salary >= 10000 and salary <= 20000
order by salary asc;

-- 연산자 우선순위 : NOT > AND > OR
select rownum, first_name, last_name, salary, hire_date, commission_pct
from EMPLOYEES
where (salary between 10000 and 20000)
			and (commission_pct = 0.3 or commission_pct = 0.2)
order by salary asc;

-- where employee_id = 101 or employee_id = 105 or employee_id = 110;
select *
from EMPLOYEES
where employee_id in (101, 105, 110);

-- 날짜 포맷 보기 => RR/MM/DD
select * from nls_session_parameters where parameter='NLS_DATE_FORMAT';

-- 2005년이후 2007년 사이에 입사원 조회
-- 이전, 이후 : 포함
select *
from EMPLOYEES
where hire_date >= '2005/01/01' and hire_date <= '2007/12/31';

select first_name, hire_date
from EMPLOYEES
where hire_date between '05-01-01' and '07-12-31';

select *
from EMPLOYEES
where department_id <> 100 and department_id <> 60

select *
from EMPLOYEES
where department_id not in (100, 60);

-- % : 0개 이상 아무문자나 가능
-- _ : 1문자 아무거나 가능
-- '' : 대소문자 구별한다.
select *
from EMPLOYEES
where first_name like 'S%';

select *
from EMPLOYEES
where first_name like '%s%';

-- 이름이 4자리인 사람
select *
from EMPLOYEES
where first_name like '____';

select *
from EMPLOYEES
where length(first_name) = 4;

-- 이름의 3번째 자리가 s인 사람
select *
from EMPLOYEES
where first_name like '__s%';

-- 이름이 n으로 끝나는 사람
select *
from EMPLOYEES
where first_name like '%n';

-- 이름이 n으로 끝나지 않는 사람
select *
from EMPLOYEES
where first_name not like '%n';

-- where commission_pct = null; (X)
select *
from EMPLOYEES
where commission_pct is null;

select *
from EMPLOYEES
where commission_pct is not null;

select *
from EMPLOYEES
where department_id is null;

-- MANAGER_ID : 상사 ID
-- MANAGER_ID가 null이면 사장님
select *
from EMPLOYEES
where manager_id is null;

select * from jobs;

-- sort
-- asc : null 마지막에 나옴
-- desc : null 먼저 나옴
select *
from EMPLOYEES
order by commission_pct desc;

-- desc 하되 null이 마지막에 나오게하기
select *
from EMPLOYEES
order by commission_pct desc nulls last;

-- 실행순서 : from > where > select > order by
-- order by는 select에서 만든 tax 컬럼을 가져다 쓸 수 있다.
select first_name, salary, department_id, hire_date, salary*0.1 tax
from EMPLOYEES
where department_id in (30, 60, 80)
order by tax desc, department_id asc, hire_date desc;

-- 이름 대신 select 컬럼 순서를 이용
-- 오라클은 1부터 센다.
select first_name, salary, department_id, hire_date, salary*0.1 tax
from EMPLOYEES
where department_id in (30, 60, 80)
order by 5 desc, 3 asc, 4 desc;

-- 1+2가 employee 건수만큼 나옴 -> 107번 나옴
-- sysdate : 시스템날짜 구하기 -> 107번 나옴
select 1+2, sysdate
from EMPLOYEES;

-- 한번만 보려면..
select distinct 1+2, sysdate
from EMPLOYEES;

-- DUAL : 뭔가를 한번만 보기 위한 TABLE
select 1+2, sysdate
from dual;

-- 정수
select abs(-100) 절대값, 
		ceil(10.1) 무조건올림, 
		floor(10.9) 무조건내림, 
		round(10.5) 반올림,
		round(10.4) 반올림2
from dual;

-- 소수점 자릿수 주기
select round(10.4567, 2) 반올림,
	trunc(10.4567, 2) 내림
from dual;

-- 문자처리함수
-- concate 연산자 ||는 여러개가능 
-- cancat()는 2개밖에 안됨
-- substr(문자, 어디서부터, 몇개)
-- lengthb : byte로 길이 읽음, 한글은 1글자가 3byte -> 15byte됨
-- varchar(30) : 30byte 길이
select lower('HELLO') 소문자로, upper('hello') 대문자로,
		initcap('hello world') 첫문자를대문자로,
		'hello'||'kosta'||'gasan' 문자열연결,
		concat('hello', 'kosta') 문자열연결함수,
		substr('hello world', 1, 5) 일부문자추출,
		length('hello world') 문자열길이,
		lengthb('hello world') 문자열길이2,
		length('안녕하세요') 문자열길이한글,
		lengthb('안녕하세요') 문자열길이한글2
from dual;

/* SQL*PLUS
insert into kosta_student values(1, '123456789012345678901234567890');
insert into kosta_student values(1, '배고파요배고파요요요');
commit;
커밋 안하면 세션에서만 보이고 커밋해야 다른곳에서도 볼 수 있다.
*/
select * from KOSTA_STUDENT;

-- 컬럼이름 숫자로 시작하려면 "3자리자르기"
-- 오류남
select first_name, 
	length(first_name) 자릿수, 
	substr(first_name, 1, 3) "첨부터3자리",
	substr(first_name, 2) "2부터끝까지",
	substr(first_name, -3, 3) "뒤3번째부터3",
	substr(first_name, -3) "뒤3번째부터끝"
from EMPLOYEES;

-----------------------1번째부터 2자리
select substr(hire_date, 1, 2) 년도,
		substr(hire_date, 4, 2) 월,
		to_char(hire_date, 'yyyy') 년도4자리,
		to_char(hire_date, 'mm') 월
from EMPLOYEES

-- 9월에 입사한 사원 조회
select first_name, hire_date
from EMPLOYEES
where substr(hire_date, 4, 2) = '09';

select first_name, hire_date
from EMPLOYEES
where to_char(hire_date, 'mm') = '09';

select first_name, hire_date
from EMPLOYEES
where hire_date like '__/09/__';

-- instr : 특정 문자가 어디에 위치하는지?
select first_name, instr(first_name, 's')
from EMPLOYEES;

-- 이름에 's' 문자가 포함된 직원을 조회
select first_name
from EMPLOYEES
where instr(first_name, 's') > 0;

select first_name
from EMPLOYEES
where first_name like '%s%';

-- first_name을 10자리로. 빈부분은 왼쪽부터 #으로 채움
-- 자릿수를 넘으면 원래 값이 나옴 안잘림
select first_name, 
		lpad(first_name, 10, '#') 왼쪽채우기,
		rpad(first_name, 10, '#') 오른쪽채우기,
		'*'||ltrim('     Oracle     ')||'*' 왼쪽공백지우기,
		'*'||rtrim('     Oracle     ')||'*' 오른쪽공백지우기,
		'*'||trim('     Oracle     ')||'*' 양쪽공백지우기
from EMPLOYEES

-- 날짜
select sysdate 오늘, sysdate-1 어제, sysdate+1 내일
from dual;

select hire_date 입사일, hire_date-7 입사일주일전
from EMPLOYEES;

-- round : 15일 넘으면 다음달로 반올림됨, 안넘으면 1일로 내림
select hire_date, 
		round(hire_date, 'mm') 월반올림,
		trunc(hire_date, 'mm') 월버림
from EMPLOYEES;

select hire_date,
		months_between(sysdate, hire_date) 입사월수,
		months_between(sysdate, hire_date)/12 입사연수
from EMPLOYEES;

select to_char(hire_date, 'yyyy/mm/dd MON DAY DY hh:mi:ss') "일자를 문자로 변경"
from employees;

-- 숫자 -> 문자
-- 자바 포맷 #, 오라클 9
-- L -> 지역별 통화 기호, 우리는 원 표시
select first_name, salary, to_char(salary, 'L999,999,999.99') 급여,
        to_char(salary, '000,000,000,000'),
        to_char(salary, '999,999,999,999')
from employees;

-- 오류, 날짜 포맷 맞춰야함
select hire_date
from employees
where hire_date >= '01012004';

select hire_date
from employees
where hire_date >= to_date('01012004', 'mmddyyyy');

-- nvl : null인 값 다른 값으로 바꾸기
-- manager_id는 int타입이라 문자가 들어갈 수 없음.
-- manager_id를 문자형으로 바꿈.
-- nvl2(타깃, null이아닐때줄값, null일때줄값)
-- nullif : 어떤조건에 맞으면 null을 반환
-- coalesce : null이 아닌 컬럼 중 제일 처음 만난 컬럼 값
select first_name, 
    nvl(to_char(manager_id), '사장님') 매니저, 
    nvl(commission_pct, 0) commission, 
    nvl(to_char(department_id), '부서없음') 부서,
    nvl2(department_id, to_char(department_id), '부서없음') 부서2,
    nullif(department_id, 60) "부서가60번이면null",
    coalesce(commission_pct, department_id, manager_id) "null이아닌처음값찾기"
from employees;

where nullif(department_id, 60) is null;
-- where nullif(department_id, 60) is null ===> 부서가 60번인 것만 조회

/*
decode : 자바의 3항연산자, if
단점 : 조건이 "같다" 만 된다.  
DECODE (표현식, 조건1, 결과1, 
                조건2, 결과2, 
                조건3, 결과3, 
                기본결과n 
)*/
select first_name, DEPARTMENT_ID,
        decode(DEPARTMENT_ID, 10, '개발부',
                             20, '판매부',
                             30, '마케팅부',
                              '나머지') 조건에따른결과,
        case when DEPARTMENT_ID <= 30 then '30보다작다'
            when DEPARTMENT_ID <= 50 then '50보다작다'
            when DEPARTMENT_ID <= 100 then '100보다작다'
            else '기타'
        end "case연습"             
from employees;

/*
CASE 표현식  WHEN 조건1 THEN 결과1 
                     WHEN 조건2 THEN 결과2 
                     WHEN 조건3 THEN 결과3 
                     ELSE 결과n 
END
*/

-- ''값
-- "" 컬럼 이름








