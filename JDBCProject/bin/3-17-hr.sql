--------수업--------
-- ppt 9장 DDL(데이터 정의어) : create, alter, drop, truncate, rename 
--10장 DML
drop table customer;

-- number : 자동으로 38글자
-- varchar2(20) : 한글이면 6자까지
create table customer(
    cust_id number,
    cust_name varchar2(20),
    gender char(1),
    gender2 char(10),
    birthday date,
    year01 interval year(3) to month, 
    day01 interval day(3) to second
);

select interval '3' year(3)
from dual;
                                                            -- 3년
insert into customer values(1, '홍길동', 'M', '남자', sysdate, interval '36' month(3), interval '100' day(3) );
insert into customer values(2, '홍길동2', 'F','여자',  sysdate, interval '36' month(3), interval '100' day(3) );
insert into customer values(3, '홍길동3', 'M', '남자 ', sysdate, interval '36' month(3), interval '100' day(3) );
insert into customer values(3, '홍길동4      ', 'M', '남자   ', sysdate, interval '36' month(3), interval '100' day(3) );

-- char: 고정길이, varchar2 : 가변길이
select * from customer
where cust_name = '홍길동4';   -- 공백도 값이라서 조회가 안된다.
                              -- 가변길이는 공백에 영향받음
select * from customer
where trim(cust_name) = '홍길동4';     -- 공백 없애기

select * from customer
where gender2 = '남자        ';   -- 고정길이라서 공백 상관 없음

-- year01, day01 => 간격을 저장
select cust_name, birthday, birthday+year01 "36개월후", birthday+day01 "100일후" 
from customer;

-- interval 쓰는 이유? 컬럼  값만 수정하면 돼서. 
-- interval 안쓰면 수정해야할 때 프로그램을 수정해야함
-- sql 문장을 안 건드릴 수 있도록
select cust_name, birthday, add_months(birthday, 36) "36개월후", birthday+100 "100일후" 
from customer;

--===================================================
-- number(9, 2) : 전체 9자리, 소수 밑 2자리
drop table emp2;

create table emp2(
    empid number(3),
    empname varchar2(20),
    salary number(9, 2)
);

insert into emp2 values(1, '김길동01234567890', 1000000.12);
insert into emp2 values(2, '김길동01234567890', 1000000.123);  -- 오류X 자동으로 소수 2자리 밑에 짤림
insert into emp2 values(3, '김길동01234567890', 21000000.12);  -- 정수 자리수 넘치면 오류

select * from emp2;

--===================================================
-- 백업하기
select * from employees;

-- 구조와 데이터 모두 가져오기
create table emp3
as
select * from employees;

select * from emp3;

-- 80번 부서만 복사
create table emp4
as
select * from employees
where department_id = 80;

select * from emp4;

-- 구조만 복사하기. 데이터는 X
create table emp5
as
select * from employees
where 1 = 0;

select * from emp5;

--원하는 행으로 구성된 복제 테이블 생성
create table emp6
as
select employee_id, first_name, salary, hire_date from employees
where 1 = 0;

select * from emp6;

--==============================================
-- 컬럼 추가하기

desc emp6;

alter table emp6
add ( deptid number, address varchar2(100) );

select * from emp6;

-- 컬럼 수정하기... 이름은 수정 못함
-- 데이터가 이미 들어가있는 경우엔 안될수도있다.
alter table emp6
modify ( deptid number(3), address varchar2(50) );

-- 컬럼 삭제
alter table emp6
drop column deptid;

-- 컬럼 다시 추가
alter table emp6
add ( dept_id number(3) );

alter table emp6
drop ( dept_id );

-- 테이블 삭제.. 복구 불가
drop table emp6;

--================================================
-- 테이블의 모든 로우(데이터) 제거 ==> truncate
-- 구조는 그대로 남기고 데이터만  삭제
select * from emp4;

truncate table emp4;

--===============================================
-- 테이블 이름 변경 ==> rename
rename emp4 to tbl_emp4;

select * from tbl_emp4;

desc tbl_emp4;

--===========================================
--USER_TABLES 데이터 딕셔너리 뷰 살피기
-- hr 계정에 있는 테이블들 
desc user_tables;
show user;

select *
from user_tables;

-- 모든 계정에 있는 테이블
desc all_tables;

select *
from all_tables;

-- DBA만 접근 가능한 table
select *
from dba_tables;

--===========================================
drop table customer2;

create table customer2(
    cust_id number,
    cust_name varchar2(20),
    gender char(1),
    gender2 char(10),
    birthday date
);

-- 순서대로 데이터타입 맞춰서 넣기
insert into customer2 values ( 1, 'aa', 'M', '남자', sysdate );
-- 컬럼 명시하기
insert into customer2(cust_id, cust_name, gender, gender2) values( 2, 'aa', 'M', '남자' );
insert into customer2(cust_id, cust_name) values( 3, 'aa'  );
insert into customer2(cust_name, cust_id) values( 'aa', 4 );
insert into customer2 values ( 5, 'aa', null, null, null );     -- 명시적으로 null값 주기
insert into customer2 values ( 6, 'aa', '', '', null );         -- '' 도 명시적으로 null값을 준것이다.
insert into customer2 values ( 7, 'aa', '', '', '' );           -- 날짜도 '' 가능
insert into customer2 values ( '', 'aa', '', '', '' );          -- 숫자도 '' 가능

-- 입력되지 않은 컬럼은 암시적으로(자동으로, 묵시적으로) null값이 들어감
select * from customer2;

select * from customer2 
where gender is null;

--================================================================
-- create table문의 subquery 
drop table emp_backup;

create table emp_backup
as
select employee_id, first_name, salary, hire_date
from employees
where department_id = 10;

desc emp_backup;
select * from emp_backup;

-- insert문의 subquery
insert into emp_backup
select employee_id, first_name, salary, hire_date
from employees
where department_id = 100;

-- 데이터 타입만 맞으면 넣을 수 있다.
insert into emp_backup
select location_id, department_name, 0, sysdate
from departments;

--===============================================
-- 다중 테이블에 다중 행 입력 ==> insert all
drop table emp_basic;
drop table emp_addinfo;

create table emp_basic
as
select employee_id, first_name, salary
from employees
where 1=0;          -- 구조만 만들기

create table emp_addinfo
as
select employee_id, first_name, hire_date
from employees
where 1=0;

insert all
into emp_basic values(employee_id, first_name, salary)
into emp_addinfo values(employee_id, first_name, hire_date)
select employee_id, first_name, salary, hire_date
from employees;

select * from emp_basic;
select * from emp_addinfo;

truncate table emp_basic;       -- 데이터만 날리기
truncate table emp_addinfo;

-- 조건(WHEN)에 의해 다중 테이블에 다중 행 입력
insert all
when employee_id < 110 then into emp_basic values(employee_id, first_name, salary)
when salary > 10000 then into emp_addinfo values(employee_id, first_name, hire_date)
select employee_id, first_name, salary, hire_date
from employees;

--================================================
-- pivoting에 의해 다중 테이블에 다중행 입력하기

-- 월~금까지 매일매일의 판매실적 기록하는 테이블
create table sales(
    sales_id number(4),
    week_id number(4),
    mon_sales number(8, 2),
    tue_sales number(8, 2),
    wed_sales number(8, 2),
    thu_sales number(8, 2),
    fri_sales number(8, 2)
);

insert into sales values(1001, 1, 200, 100, 300, 400, 500);
insert into sales values(1002, 2, 100, 300, 200, 500, 350);

-- pivoting insert문 결과를 저장할 테이블
create table sales_data(
    sales_id number(4),
    week_id number(4),
    daily_id number(4),
    sales number(8,2)
);

select * from sales;

-- 요일을 구분할 수 있는 컬럼을 추가하여 매일 매일의 판매 실적 기록
insert all
into sales_data values(sales_id, week_id, 1, mon_sales)
into sales_data values(sales_id, week_id, 2, tue_sales)
into sales_data values(sales_id, week_id, 3, wed_sales)
into sales_data values(sales_id, week_id, 4, thu_sales)
into sales_data values(sales_id, week_id, 5, fri_sales)
select sales_id, week_id, mon_sales, tue_sales, wed_sales, thu_sales, fri_sales
from sales;

select * from sales_data;

--================================================
select * from emp_basic;

update emp_basic
set salary = salary * 1.1, first_name = '수정'
where employee_id <= 102;

select * from emp_basic;
select * from emp_backup;

update emp_backup
set hire_date = sysdate
where salary  > 0;

update emp_backup
set hire_date = '2022-12-31'
where salary  = 0;

-- Luis의 급여는 Jennifer의 급여와 같다
update emp_backup
set salary = (select salary
            from emp_backup
            where first_name = 'Jennifer')
where first_name = 'Luis';


-- Luis의 급여와 입사날짜는 Nancy와 같다
update emp_backup
set (salary, hire_date) = (select salary, hire_date
                        from emp_backup
                        where first_name = 'Nancy')
where first_name = 'Luis';

commit;

-- delete : 테이블에 저장되어있는 데이터를 삭제
delete from emp_backup;
select * from emp_backup;

drop table emp_backup;
--select emp_backup;
insert into emp_backup
select employee_id, first_name, salary, hire_date
from employees;

create table emp_backup
as
select employee_id, first_name, salary, hire_date, department_id
from employees;

select * from emp_backup;

-- IT 부서의 직원들 모두 삭제하기
delete from emp_backup
where department_id = ( select department_id
                        from departments
                        where department_name = 'IT');
                        
--===========================================================
--테이블을 합병하는 MERGE
drop table emp01;
drop table emp02;

create table emp01
as
select employee_id, first_name, salary, hire_date 
from employees;

create table emp02
as
select employee_id, first_name, salary, hire_date 
from employees
where department_id = 60;

select * from emp02;

update emp02
set first_name = '수정';

insert into emp02 values(99, '김채연', 1000, sysdate);

-- emp01 : 107건
-- emp02 : 5건 + 1건

-- emp01 테이블에 emp02테이블을 합병
merge into emp01 using emp02
on(EMP01.EMPLOYEE_ID = emp02.employee_id)
when matched then
update set 
emp01.first_name = emp02.first_name
when not matched then
insert values(emp02.employee_id, emp02.first_name, emp02.salary, emp02.hire_date);

select * from emp01;

-- 이클립스 EmpDAO
desc employees;
insert into employees values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
select * from employees;

--==========================================================
-- 트랜잭션
-- DML(insert, update, delete)

select * from emp02;

-- 작업 시작
delete from emp02 where employee_id = 103; 
delete from emp02 where employee_id = 104;
delete from emp02 where employee_id = 105;
--> 다른 세션에서는 지워지지 않음
-- commit 해야 다른 세션에서도 지워짐
-- rollback : 원상복귀, 변경사항 취소
rollback;
-- 작업 끝 -- > 하나의 트랜잭션

-- 작업 시작
delete from emp02 where employee_id = 103; 
delete from emp02 where employee_id = 104;
delete from emp02 where employee_id = 105;
commit;
-- 작업 끝
-- commit -> DB에 반영됨

-- 작업 시작
delete from emp02 where employee_id = 106;
-- commit이나 rollback으로 작업을 끝내기 전까지 106번에 lock이 걸림
rollback;
-- 작업 끝, lock 풀림

delete from emp02 where employee_id = 106;
commit;

--====================================================
-- 무결성 제약조건

desc departments;

-- 10번이 존재하는데 10번을 또 넣으면 에러
insert into departments(department_id, department_name) values(10, 'aa');

insert into departments(department_id, department_name) values(11, 'aa');

-- NOT NULL 제약조건
insert into departments(department_id) values(22);
select * from departments;

-- 제약조건 확인
desc user_constraints;

-- 현재 계정의 제약조건 확인
-- constraint_name, constraint_type, search_condition, r_constraint_name
select * from user_constraints
where table_name = 'EMPLOYEES';

-- constraint_name, column_name
select * from user_cons_columns
where table_name = 'EMPLOYEES';

select column_name, constraint_type, search_condition, r_constraint_name
from user_cons_columns join user_constraints using(constraint_name)
where user_cons_columns.table_name = 'EMPLOYEES';
-- P(Primary key, 기본키) :  유일값, null불가, 필수컬럼, 테이블에 딱 하나만 있어야 한다.
-- U(Unique) : 유일값, null가능
-- R(Foreign key, 참조키, 외래키) : 일반적으로 다른 테이블의 PK를 참조한다. 
--                                같은 테이블의 컬럼 참조도 가능. PK 아닌 컬럼도 참조 가능.
-- C(Check) : 조건에 맞는 데이터만 가능

-- 특정 컬럼이 어떤 컬럼을 참조하고있는지
select aa.constraint_name, aa.table_name, aa.constraint_type , bb.table_name
from  user_constraints aa, user_constraints bb
where aa.constraint_name  = bb.r_constraint_name;


--=====================================================================
-- 제약조건있는 table 만들기
-- 컬럼 레벨에서 제약조건 주기
drop table customer;

create table customer(
    cust_id number constraint customer_cust_id_pk primary key,
    cust_name varchar2(30) not null,
    email varchar2(20) constraint customer_email_unique unique,
    address varchar2(100),
    gender char(1) constraint customer_gender_check check (gender in ('M', 'F')),
    dept_id number constraint customer_dept_id_FK references departments(department_id),
    loc varchar2(20) default 'SEOUL'
);

insert into customer(cust_id, cust_name) values(1, '김길동');
insert into customer(cust_id, cust_name) values(2, 'aa');
insert into customer(cust_id, cust_name, email) values(3, 'aa', 'efaf');
insert into customer(cust_id, cust_name, email) values(4, 'aa', 'bnmb');
insert into customer(cust_id, cust_name, email, gender) values(5, 'aa', 'oim', 'M');
insert into customer(cust_id, cust_name, email, gender, dept_id) values(6, 'aa', 'tw', 'M', 100);
insert into customer(cust_id, cust_name, email, gender, dept_id, loc) values(7, 'aa', 'zqcf', 'M', 100, '대전');

select * from customer;

--==================================================================
-- 컬럼 여러개로 PK 잡기
-- 테이블 레벨 제약조건
select column_name, constraint_type, search_condition
from user_cons_columns join user_constraints using(constraint_name)
where user_cons_columns.table_name = 'JOB_HISTORY';

-- 상품정보 : 상품번호, 상품이름, 상품가격
-- 고객정보 : 고객번호, 고객이름...
-- 주문테이블 : 고객번호, 주문일자, 순서, 상품번호, 수량

create table 상품정보(
    상품번호 number constraint 상품정보_상품번호_PK primary key,
    상품이름 varchar2(100),
    상품가격 number(9)
);

-- 고객번호,주문일자,순서 ==> 3개를 PK로
create table 주문(
    고객번호 number,
    주문일자 date,
    순서 number,
    상품번호 number constraint 주문_상품번호_FK references 상품정보(상품번호),
    수량 number,
    constraint 주문_PK primary key(고객번호, 주문일자, 순서)
);

insert into 상품정보 values(1, '노트북', 100);
insert into 상품정보 values(2, '스마트폰', 100);

-- 고객
select * from customer;
insert into 주문 values(4, '2001/03/17', 1, 2, 10);
insert into 주문 values(4, '2001/03/17', 2, 2, 10);
insert into 주문 values(4, '2001/03/17', 3, 2, 10);
insert into 주문 values(4, '2001/03/17', 4, 5, 10);

select * from 주문;

--=========================================================
select * from employees;

select * from departments;

-- 100번을 참조한 자식이 있어서 100번을 지울 수 없다.
delete from departments where department_id = 100;

-- 그래도 지우고 싶다면
-- 제약조건 비활성화
alter table employees
disable constraint EMP_DEPT_FK;

alter table customer
disable constraint CUSTOMER_DEPT_ID_FK;

-- 다시 지울 수 없게 바꾸기
insert into departments values(100, 'FINANCE', null,1700);
select * from departments;

alter table employees
enable constraint EMP_DEPT_FK;

alter table customer
enable constraint CUSTOMER_DEPT_ID_FK;

--====================================================================
-- LAB
1. 
2007년 입사한(hire_date) 직원들의 사번(employee_id), 이름(first_name), 
성(last_name), 부서명(department_name)을 조회하려 합니다.
임시 테이블 용도로 사용하는 Object를 생성합니다.
==>emp_2007_details

이때, 부서에 배치되지 않은 직원의 경우, '<NOT ASSIGNED>'로 보여줍니다.
create table emp_2007_details
as
select hire_date, employee_id, first_name, last_name, nvl(department_name, '<NOT ASSIGNED>') department_name
from employees left outer join departments using(department_id)
where hire_date between '07/01/01' and '07/12/31';

select * from emp_2007_details;
  
========================================

2.
기존 EMPLOYEES 테이블에 있는 레코드들 중, 'Marketing'부서에 근무하는 직원 레코드를
  이용하여 EMPLOYEES_MARKETING 테이블을   만들기 위한 DDL을 작성하십시오. 
  단, EMPLOYEES_MARKETING 테이블의 키는   없어도 관계없습니다.
  
create table employees_marketing
as
select employees.*
from employees, departments 
where employees.department_id = departments.department_id
and department_name = 'Marketing';

select * from employees_marketing;

========================================

3.
인사관리를 위하여 현재 직원정보에 대한 백업테이블을 생성하여 보관하기로 합니다. 
새로 생성하는 백업테이블명은 "EMPLOYEES_BACKUP" 이며 기존테이블(EMPLOYEES)의 Index, 
Constraint는 필요로 하지 않습니다. 단 급여(Salary)가 5000을 초과하는 직원만 백업테이블 내에 존재해야 합니다.
위 설명에 해당하는 테이블을 생성하기 위한 sql 스크립트를 작성하시오. 
create table EMPLOYEES_BACKUP
as
select * from employees
where salary > 5000;

select * from EMPLOYEES_BACKUP;

 
========================================

4.
인사관리를 위한 시스템 구축중 지역(Regions), 국가(Countries), 
위치(Locations)에 대한 전체 리스트 정보를 빈번하게 사용할 경우가 생겼다. 
여러 프로그램에서 매번 반복적으로 사용되며 일부 개발자의 경우 잘못된 
조인으로 올바른 결과를 가져오지 못하는 경우가 발생하였다. 
이를 해결하기 위해 복잡한 질의를 숨기기 위한 논리적 테이블의 용도로 
쓰이는 DB Object 를 생성하기로 하였다. 
DB Object 이름은 LOC_DETAILS_{DB OBJECT명} 을 사용한다.
위 설명에 해당하는 DB Object를 생성하기 위한 sql 스크립트를 작성하라.

create table LOC_DETAILS
as
select *
from locations join countries using(country_id)
                join regions using(region_id);

 
======================================
5.
사원이 한 명 이상인 부서들에 대해 부서 번호, 부서 이름, 사원 수, 
최고 급여, 최저 급여, 평균 급여, 급여 총액을 빈번하게 조회하여야 
할 필요가 있어, VIEW를 생성하여 사용하고자 합니다. 
생성된 DB Object(VIEW)의 전체 레코드에 대한 조회 결과가 아래와 같이 출력되도록 
"DEPT_SAL_INFO"라는 VIEW 를 생성하는 sql 스크립트를 작성하십시오. 
단, 평균 급여의 소수점 이하는 절사합니다.

출력 : DEPT_ID | DEPT_NAME | NUM_EMP | MAX_SAL | MIN_SAL | AVG_SAL | SUM _SAL

drop table DEPT_SAL_INFO;

create table DEPT_SAL_INFO
as
select department_id DEPT_ID, department_name DEPT_NAME, count(*) NUM_EMP, 
    max(salary) MAX_SAL, min(salary) MIN_SAL, avg(salary) AVG_SAL, sum(salary) SUM_SAL
from employees join departments using(department_id)
group by department_id, department_name
having count(*) >= 1;

select * from DEPT_SAL_INFO;

========================================
6.
Sales 부서에서 Gerald Cambrault 라는 관리자(Manager_id)를 가지는 
직원의 정보를 조회하여 employee_sales_Gerald 라는 view를 생성하십시오.

사원번호  |  사원명  |  부서명  |  관리자명

create table employee_sales_Gerald
as
select 사원.employee_id 사원번호, 사원.first_name 사원명, 
    부서.department_name 부서명, 관리자.first_name 관리자명
from employees 사원, employees 관리자, departments 부서
where 사원.department_id = 부서.department_id
and 사원.manager_id = 관리자.employee_id
and 부서.department_name = 'Sales'
and 관리자.first_name = 'Gerald';

select * from employee_sales_Gerald;


 
=====================================
7.
다음 조건을 만족하는 테이블 생성 DDL을 작성하십시오. 

테이블 명 : board

테이블에 대한 이해 : 게시판 정보를 가지는 테이블

칼럼명: 
board_seq	    (게시물 번호) 정수 최대 10자리,
board_title	    (게시물 제목) 문자 가변 자릿수 255자리,
board_contents   (게시물 내용) 문자 가변 자릿수 4000자리
board_writer     (게시물 작성자) 문자 가변 자릿수 100자리,
board_date       (게시물 작성시간) 날짜,	
board_viewcount  (게시물 조회수) 정수 최대 6자리,
board_password   (게시물 암호) 문자 가변 자릿수 20자리,	

제약조건 :  board_seq : 기본 키(Primary Key)  제약 조건명은 BOARD_SEQ_PK
 board_title :  값이 반드시 존재(NOT NULL) 
 board_writer : Member 테이블의 member_id 컬럼 참조

(Member  테이블
member_id 문자 가변 자릿수 100자리
           primary key 라고 가정합니다)
           
create table member(
    member_id varchar2(100) constraint member_id_pk primary key
);
           
create table board(
    board_seq number(10) constraint BOARD_SEQ_PK primary key,
    board_title varchar2(255) not null,
    board_contents varchar2(4000),
    board_writer varchar2(100) constraint board_writer_fk references member(member_id),
    board_date date,
    board_viewcount number(6),
    board_password varchar2(20)
);


====================================

8.locations 테이블에서 2000번 이상의 도시코드, 도시명, 국가명, 그 도시에 있는
 부서명을 조회하여 citycode_gt_2000 라는 이름의 view를  생성하는 SQL 문장을 작성하시오.
단, citycode_gt_2000 view는 변경 가능하도록 생성합니다.

LOCATION_ID	  CITY	  COUNTRY_NAME	  DEPARTMENT_NAME

 

