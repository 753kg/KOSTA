-- =============== review =========================
-- DDL(Data Definition Language, 데이터 정의어) : create, alter, drop, rename ...
-- DML(Data Manipulation Language, 데이터 조작어) : insert, delete, update, merge
-- DQL(Data Query Language) : select
-- table의 제약조건 : not null, primary key, unique, check, reference key(foreign key)

------------------- DDL 예제 -------------------------------
/* 7. 다음 조건을 만족하는 테이블 생성 DDL을 작성하십시오. 

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
               primary key 라고 가정합니다) */
           
drop table member;

create table member(
    member_id number(3) constraint member_member_id_pk primary key,
    member_name varchar2(20) not null
);

drop table board;

create table board(
    board_seq number(10) constraint BOARD_SEQ_PK primary key,
    board_title varchar2(255) not null,
    board_contents varchar2(4000),
    board_writer number(3) constraint board_writer_fk references member(member_id),
    board_date date default sysdate,
    board_viewcount number(6) constraint board_viewcount_ck check (board_viewcount > 0),
    board_password varchar2(20),
    board_image varchar2(100) constraint board_image_unique unique
);

insert into board(board_seq, board_title) values(1, '목요일');
insert into board(board_seq, board_title, board_contents ) values(2, 'aa', '날씨가좋아요');
insert into board(board_seq, board_title, board_contents) values(3, 'aa', '날씨가좋아요');
-- member테이블의 member_id에 100번이 있어야 된다.
insert into member values(100, '강성빈');
insert into board(board_seq, board_title, board_contents, board_writer) values(4, 'aa', '날씨가좋아요', 100);
insert into board(board_seq, board_title, board_contents, board_writer, board_date) values(5, 'aa', '날씨가좋아요', 100, '2020-12-31');
insert into board(board_seq, board_title, board_contents, board_writer, board_date, board_viewcount) 
    values(6, 'aa', '날씨가좋아요', 100, '2020-12-31', 1);
insert into board(board_seq, board_title, board_contents, board_writer, board_date, board_viewcount, board_password) 
    values(7, 'aa', '날씨가좋아요', 100, '2020-12-31', 1, '비밀번호1234');
insert into board values(8, 'aa', '날씨가좋아요', 100, '2020-12-31', 1, '비밀번호1234', 'images/logo.png');
insert into board values(9, 'aa', '날씨가좋아요', 100, '2020-12-31', 1, '비밀번호1234', 'images/logo2.png');

-- 조회된 순서 = insert한 순서
select * from board;

select * 
from user_constraints
where table_name = 'BOARD';

select *
from user_cons_columns
where table_name = 'BOARD';

--------------------- DML --------------------------------
insert into 테이블이름(컬럼리스트) values(값리스트);

update 테이블이름 
set 컬럼1 = 값1, 컬럼2 = 값2, 컬럼3 = 값3
where 조건문;

delect from 테이블이름 where 조건문;

-- 이클립스
desc employees;

update employees set 
    FIRST_NAME = ?,
    LAST_NAME = ?,
    EMAIL = ?,
    PHONE_NUMBER = ?,
    HIRE_DATE = ?,       
    JOB_ID = ?,
    SALARY = ?,
    COMMISSION_PCT = ?,
    MANAGER_ID = ?,
    DEPARTMENT_ID = ?
where EMPLOYEE_ID = ?;

-- delete : row를 지움, column은 못지움
delete from employees
where EMPLOYEE_ID = ?;

select * from employees;

-- ================= 수업 =======================
-- VIEW : table을 보기 위한 창의 역할을 한다.
-- TABLE 안쓰고 VIEW 쓰는 이유
-- 1. 보안 : 실제 테이블에 접근을 못하게. 몇 개의 컬럼만 보여주려고
-- 2. 복잡한 SQL 문장을 간단하게 하려고
-- 테이블은 or replace 할 수 없다.
drop table emp_backup;

create table emp_backup
as
select * 
from employees;

select * from emp_backup;

-- or replace : 없으면 만들고 있으면 수정
create or replace view emp_backup_view
as
select * from emp_backup
where department_id = 60;

-- 테이블처럼 사용
select * from emp_backup_view;

-- user가 만든 view들이 보인다.
select * from user_views;

create or replace view emp_backup_view2
as
select employee_id, first_name, salary from emp_backup
where department_id = 60;

select * from emp_backup_view2;

-- view로 볼 수 있는 데이터에만 접근 가능
-- emp_backup_view2에는 department_id 컬럼이 없으므로 조회할 수 없음.
select * from emp_backup_view2
where department_id = 60;

select * from emp_backup_view2
where salary > 5000;

update emp_backup_view2 
set salary = 10000
where salary > 5000;

-- view를 통해 테이블에 접근해서 값을 수정.
select * from emp_backup;

-- 컬럼 이름 정하기
create or replace view emp_backup_view3(직원번호, 직원이름, 급여)
as
select employee_id, first_name, salary 
from emp_backup
where department_id = 60;

select * from emp_backup_view3;

-- salary라고 하면 안됨.
select * from emp_backup_view3
where 급여 >= 5000;

-- 단순뷰 : DML 가능
update emp_backup_view3
set 급여 = 20000
where 급여 >= 5000;

select * from emp_backup;

create or replace view emp_backup_view_groupby
as
select department_id, avg(salary) sal_avg
from emp_backup
group by department_id;

-- sql 문장이 단순해짐
select * from emp_backup_view_groupby;

select department_name, sal_avg
from emp_backup_view_groupby join departments using(department_id);

-- group by 사용한 (집계함수 사용한) view는 DML 불가
-- 원본 테이블을 찾아갈 수 없기 때문이다.
update emp_backup_view_groupby
set sal_avg = sal_avg * 1.1;

-- 복합VIEW : 조회가 목적. (단순,재사용)

-- 테이블이 존재하지 않아도 view 생성 가능 ==> FORCE
-- 실행은 불가. 나중에 테이블이 생성되면 실행 가능.
create or replace force view emp_backup_view_groupby
as
select department_id, avg(salary) sal_avg
from emp_backup2
group by department_id; 

-- 하지만 select는 할수없다. table이 실제로 존재하지 않기 때문
-- 테이블 만들면 괜찮아짐
select * from emp_backup_view_groupby;

create table emp_backup2
as
select * from employees;

-------------- with check option ----------------------------
create or replace view emp_backup_60
as
select * 
from emp_backup
where department_id = 60;

select * from emp_backup_60;

update emp_backup_60
set department_id = 30;

-- 60번을 다 30번으로 바꿔서 볼 게 없음
select * from emp_backup_60;

-- with check option ==> 30번 부서를 다른 걸로 못바꾸게함
create or replace view emp_backup_30
as
select * 
from emp_backup
where department_id = 30 with check option;

select * from emp_backup_30;

-- 부서 업데이트 불가능
update emp_backup_30
set department_id = 60;

-- 가능
update emp_backup_30
set salary = 10000;

-------------------with read only ---------------------------
create or replace view emp_backup_30
as
select * 
from emp_backup
where department_id = 30 with read only;

-- 읽기 전용이라 수정 불가능
update emp_backup_30
set department_id = 60;


-- 자신의 부서의 평균보다 적은 급여를 받는 직원 조회
-- view 만들어서 사용 => 문장이 간단해짐
create or replace view emp_dept_avg
as
select department_id, avg(salary) sal_avg
from employees
group by department_id;

select first_name, salary, round(sal_avg)
from employees join emp_dept_avg using(department_id)
where salary < sal_avg;

-- inline view : from절에 select
-- sql 문장이 복잡
-- 자주 사용하면 view로 만들어서 사용하기
select first_name, salary, round(sal_avg)
from employees join (select department_id, avg(salary) sal_avg
                    from employees
                    group by department_id)
    using(department_id)
where salary < sal_avg;

-- ============== LAB =============================
/* 1. 2007년 입사한(hire_date) 직원들의 사번(employee_id), 이름(first_name), 
    성(last_name), 부서명(department_name)을 조회하려 합니다.
    임시 테이블(=VIEW) 용도로 사용하는 Object를 생성합니다.
    ==>emp_2007_details
    
    이때, 부서에 배치되지 않은 직원의 경우, '<NOT ASSIGNED>'로 보여줍니다.
    drop table emp_2007_details; */

create or replace view emp_2007_details
as
select hire_date, employee_id, first_name, last_name, nvl(department_name, '<NOT ASSIGNED>') department_name
from employees left outer join departments using(department_id)
where hire_date between '07/01/01' and '07/12/31';

select * from emp_2007_details;

  
/* 2. 기존 EMPLOYEES 테이블에 있는 레코드들 중, 'Marketing'부서에 근무하는 직원 레코드를
    이용하여 EMPLOYEES_MARKETING 테이블을   만들기 위한 DDL을 작성하십시오. 
    단, EMPLOYEES_MARKETING 테이블의 키는   없어도 관계없습니다.  */

create table employees_marketing
as
select *
from employees
where department_id = ( select department_id
                        from departments
                        where department_name = 'Marketing');

-- 제약조건은 복사가 안된다. (NOT NULL은 복사됨)
-- not null 제약조건을 제외한 다른 제약조건은 복사되지 않는다.
select * from user_constraints
where table_name = 'EMPLOYEES_MARKETING';

select * from employees_marketing;

-- 원래 테이블의 employee_id는 PK
-- email은 UNIQUE
-- JOB_ID는 FK 이지만 
-- 제약조건이 복사되지 않기 때문에 insert가 된다.
insert into employees_marketing(employee_id, last_name, email, hire_date, job_id) 
    values( 201, 'aaa', 'PFAY', sysdate, 'AA');

/* 3. 인사관리를 위하여 현재 직원정보에 대한 백업테이블을 생성하여 보관하기로 합니다. 
    새로 생성하는 백업테이블명은 "EMPLOYEES_BACKUP" 이며 기존테이블(EMPLOYEES)의 Index, 
    Constraint는 필요로 하지 않습니다. 단 급여(Salary)가 5000을 초과하는 직원만 백업테이블 내에 존재해야 합니다.
    위 설명에 해당하는 테이블을 생성하기 위한 sql 스크립트를 작성하시오. */
drop table EMPLOYEES_BACKUP;
create table EMPLOYEES_BACKUP
as
select * from employees
where salary > 5000;

select * from EMPLOYEES_BACKUP;

/* 4. 인사관리를 위한 시스템 구축중 지역(Regions), 국가(Countries), 
    위치(Locations)에 대한 전체 리스트 정보를 빈번하게 사용할 경우가 생겼다. 
    여러 프로그램에서 매번 반복적으로 사용되며 일부 개발자의 경우 잘못된 
    조인으로 올바른 결과를 가져오지 못하는 경우가 발생하였다. 
    이를 해결하기 위해 복잡한 질의를 숨기기 위한 논리적 테이블의 용도로 
    쓰이는 DB Object(=VIEW) 를 생성하기로 하였다. 
    DB Object 이름은 LOC_DETAILS_{DB OBJECT명} 을 사용한다.
    위 설명에 해당하는 DB Object를 생성하기 위한 sql 스크립트를 작성하라. */
drop table LOC_DETAILS;

create or replace view LOC_DETAILS_VIEW
as
select city, country_name, region_name
from locations join countries using(country_id)
                join regions using(region_id);
                
select * from LOC_DETAILS_VIEW;

/* 5.  사원이 한 명 초과인 부서들에 대해 부서 번호, 부서 이름, 사원 수, 
    최고 급여, 최저 급여, 평균 급여, 급여 총액을 빈번하게 조회하여야 
    할 필요가 있어, VIEW를 생성하여 사용하고자 합니다. 
    생성된 DB Object(VIEW)의 전체 레코드에 대한 조회 결과가 아래와 같이 출력되도록 
    "DEPT_SAL_INFO"라는 VIEW 를 생성하는 sql 스크립트를 작성하십시오. 
    단, 평균 급여의 소수점 이하는 절사합니다.

    출력 : DEPT_ID | DEPT_NAME | NUM_EMP | MAX_SAL | MIN_SAL | AVG_SAL | SUM _SAL */

drop table DEPT_SAL_INFO;

create or replace view DEPT_SAL_INFO
as
select department_id DEPT_ID, department_name DEPT_NAME, count(*) NUM_EMP, 
    max(salary) MAX_SAL, min(salary) MIN_SAL, floor(avg(salary)) AVG_SAL, sum(salary) SUM_SAL
from employees join departments using(department_id)
group by department_id, department_name
having count(*) > 1;

select * from DEPT_SAL_INFO;

create or replace view DEPT_SAL_INFO(dept_id,dept_name,num_emp,max_sal,avg_sal,sum_sal) 
as
select department_id ,department_name,count(*),max(salary) maxsal,trunc(avg(salary)) avgsal, sum(salary) salsum
from employees join departments using (department_id)
group by department_id ,department_name
having count(*)>1;


/* 6.Sales 부서에서 Gerald Cambrault 라는 관리자(Manager_id)를 가지는 
    직원의 정보를 조회하여 employee_sales_Gerald 라는 view를 생성하십시오.

    사원번호  |  사원명  |  부서명  |  관리자명 */
drop table employee_sales_Gerald;

create view employee_sales_Gerald
as
select 사원.employee_id 사원번호, 사원.first_name 사원명, 
    부서.department_name 부서명, 관리자.first_name||' '||관리자.last_name 관리자명
from employees 사원, employees 관리자, departments 부서
where 사원.department_id = 부서.department_id
and 사원.manager_id = 관리자.employee_id
and 부서.department_name = 'Sales'
and 관리자.first_name||' '||관리자.last_name = 'Gerald Cambrault';

select * from employee_sales_Gerald;

select *
from employees
where manager_id = ( select employee_id
                    from employees
                    where first_name||' '||last_name = 'Gerald Cambrault');


/* 7. 다음 조건을 만족하는 테이블 생성 DDL을 작성하십시오. 

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
               primary key 라고 가정합니다) */




/* 8.locations 테이블에서 2000번 이상의 도시코드, 도시명, 국가명, 그 도시에 있는
    부서명을 조회하여 citycode_gt_2000 라는 이름의 view를  생성하는 SQL 문장을 작성하시오.
    단, citycode_gt_2000 view는 변경 가능하도록 생성(=or replace 하기)합니다.

    LOCATION_ID	  CITY	  COUNTRY_NAME	  DEPARTMENT_NAME */

select * from locations;

create or replace view citycode_gt_2000 (LOCATION_ID, CITY, COUNTRY_NAME, DEPARTMENT_NAME)
as
select location_id, city, country_name, department_name
from locations join countries using(country_id)
                join departments using(location_id)
where location_id >= 2000;
-- join 했기 때문에 DML은 불가능

-- ==================== 수업 ============================
---------------------- sequence ------------------------------
-- 시퀀스: 테이블 내의 유일한 숫자를 자동으로 생성하는 "자동 번호 발생기"
-- 의미를 갖지 않는 번호를 만들고자 할 때 시퀀스 사용
-- table과 무관하다. 즉, 여러 table이 공유 가능

select * from board;

create sequence board_no_sequence
    start with 10;
    
select board_no_sequence.nextval from dual;
select board_no_sequence.currval from dual;

desc board;

insert into board(board_seq, board_title) 
    values(board_no_sequence.nextval, '게시물이름');

-- cache : cache에 미리 n개씩 만들어놓고 가져다 쓴다. 메모리상으로 더 효율적??
drop sequence board_no_sequence;

create sequence board_no_sequence
    start with 100
    cache 10;
    
insert into board(board_seq, board_title) 
    values(board_no_sequence.nextval, '게시물이름');

select * from board;

select * from user_sequences;

-- MySQL 에서는 Auto Increment : 자동으로 증가한다.
-- Oracle 에서는 Sequence 사용
create table board2(
    board_seq number auto increment
);

-------------------- index -------------------------------
-- 빠른 검색을 위해서 인덱스를 사용 = 성능 향상 = 조회 속도
-- 인덱스란 SQL 명령문의 처리 속도를 향상시키기 위해서 컬럼에 대해서 생성하는 오라클 객체
-- DML 작업이 많은 경우 오히려 성능 저하 초래됨. 적절하게 만들기

-- index : oracle이 primary key, unique로 설정된 컬럼인 경우 자동으로 index 생성시킴
-- index 추가 가능
select * from user_ind_columns
where table_name in ('EMPLOYEES', 'DEPARTMENTS', 'BOARD');

-- index를 쓰는지 = index가 걸려있는지 = index를 탄다
-- 속도가 향상 되었는지
-- 계획설명 -> options -> full -> 인덱스를 안탔다. cost가 낮음
-- = 연산자를 써야 인덱스가 사용됨
-- like 는 인덱스 안씀
-- 빈번하게 조회하는 경우 컬럼을 새로 만드는 게 좋다.
select * 
from employees
where employee_id/10 = 100;

select *
from employees
where substr(email, 1, 5) = 'SKING';

select *
from board
where board_seq = 8;

-- 인덱스 만들기
create index board_title_idx 
on board(board_title);

select *
from board
where board_title = 'aa';

drop index board_title_idx;

select *
from board
where board_title = 'aa';

------------------ 사용자 관리 --------------------------------
-- sql*plus에서
SQL> conn hr/hr
SQL> create user user1
  2  identified by 1234;
--> hr계정은 사용자 생성 권한이 없다

SQL> conn system/1234
SQL> create user user01
  2  identified by 1234;
--> User created.

SQL> conn user01/1234
user01은 connect 권한이 없다.

SQL> conn system/1234
SQL> grant create session to user01
--> connect 권한 주기

SQL> conn user01/1234;
SQL> create table aa( id number );
--> connect만 되고 create 는 못함

SQL> conn system/1234
SQL> create user user02
  2  identified by 1234;
SQL> grant create session to user02 
    with admin option;
--  with admin option : 내가 받은 권한을 다른 사람한테 줄 수 있다.

SQL> conn user02/1234;
SQL> grant create session to user01;
--> Grant succeeded.

SQL> conn SCOTT/TIGER
SQL> grant select on emp to user01;

SQL> conn user01/1234
SQL> select * from SCOTT.emp;
--> SCOTT이 가지고있는 emp를 조회

SQL> conn SCOTT/TIGER
SQL> revoke select on emp from user01;

SQL> conn user01/1234
SQL> select * from SCOTT.emp;
--> 권한이 없어서 select 불가능

------------------ 데이터베이스 롤 권한 제어 ------------------
-- 롤 : 권한을 여러 개 묶어 놓은 것

SQL> conn system/1234
SQL> create user user04
  2  identified by 1234;
SQL> grant connect, resource to user04;

SQL> conn user04/1234;
SQL> create table aa ( id number );
SQL> select * from aa;
--> create, select... 가능

-------------------- 동의어 --------------------------
-- ppt 14장~ 19장 : Object
-- 동의어를 정의하면 긴 이름대신 간단한 이름으로 접근가능

SQL> conn SCOTT/TIGER
SQL> grant select on emp to user01;

SQL> conn user01/1234
SQL> select * from SCOTT.emp;
SQL> create synonym s_emp for SCOTT.emp;
--> create synonym 권한이 없음 ..;;

SQL> conn SCOTT/TIGER
SQL> grant select on emp to user04;

SQL> conn user04/1234
SQL> create synonym s_emp for SCOTT.emp;
-- 왜안돼

SQL> conn system/1234
Connected.
SQL> grant connect, resource to SCOTT;
SQL> conn SCOTT/TIGER
SQL> create synonym s_emp for SCOTT.emp;
-- 왜안돼~?~~

SQL> conn system/1234
SQL> grant create synonym to SCOTT;
--> connect 롤에 create synonym이 없다.
--  별도로 부여해야한다.

SQL> conn SCOTT/TIGER
SQL> create synonym s_emp for SCOTT.emp;
--> Synonym created!!!!!
--> 비공개 동의어
--  공개동의어는 DBA 권한을 가진 사용자만 만들 수 있다.

SQL> select * from s_emp;
--> SCOTT에서 된다

-------------------------다시 정리
SQL> conn system/1234;

SQL> create user user05
  2  identified by 1234;
  
SQL> grant connect, resource to user05;
SQL> grant create synonym to user05;

-- SCOTT이 가진 테이블을 user05에서 조회하고싶음
SQL> conn SCOTT/TIGER
SQL> grant select on emp to user05;

SQL> conn user05/1234;
SQL> select * from SCOTT.emp;

SQL> create synonym semp for SCOTT.emp;

SQL> select * from semp;    -- 비공개 동의어

--- 공개동의어 : DBA만 만들 수 있다.
SQL> conn system/1234
SQL> create table adminTBL( id number );
SQL> grant select on adminTBL to SCOTT;

SQL> conn SCOTT/TIGER
SQL> select * from system.adminTBL;

SQL> conn system/1234
SQL> create public synonym pubTBL for system.adminTBL;

SQL> conn SCOTT/TIGER
SQL> select * from pubTBL;

------------이클립스 JDBC
drop table member;

create table member(
    member_id number(3) constraint member_id_pk primary key,
    member_name varchar(20)
);

drop table board;

create table board(
    board_seq number(10) constraint BOARD_SEQ_PK primary key,
    board_title varchar2(255) not null,
    board_contents varchar2(4000),
    board_writer number(3) constraint board_writer_fk references member(member_id),
    board_date date default sysdate,
    board_viewcount number(6) constraint board_viewcount_ck check (board_viewcount >= 0),
    board_password varchar2(20),
    board_image varchar2(100) constraint board_image_unique unique
);

desc board;

-- 제약조건 지우기
alter table board
drop constraints board_viewcount_ck;

drop sequence board_no_sequence;

create sequence board_no_sequence;

insert into member values(101, '짱구');
insert into member values(102, '철수');
insert into member values(103, '유리');
insert into member values(104, '훈이');
insert into member values(105, '맹구');
    
insert into board values(board_no_sequence.nextval, '짱구예요', '안녕하세요', 101, sysdate, 0, '짱구12', 'images/logo1.png');
insert into board values(board_no_sequence.nextval, '철수예요', '안녕하세요', 102, sysdate, 0, '철수12', 'images/logo2.png');
insert into board values(board_no_sequence.nextval, '짱짱', '우와', 101, sysdate, 0, '짱구12', 'images/logo11.png');
insert into board values(board_no_sequence.nextval, '철철', '에잇', 102, sysdate, 0, '철수12', 'images/logo22.png');

select * from board;

delete from board
where board_seq = 4 and BOARD_PASSWORD = '짱구12';

delete from board
where board_seq = 5 and BOARD_PASSWORD = '짱구12';

commit;

update board
set board_viewcount = board_viewcount + 1
where board_seq = 4;

update board
set board_title = ?,
board_contents = ?,
board_image = ?,
board_date = sysdate
where board_seq = ?
and board_password = ?

update board
set board_title = '(수정)철철',
board_contents = '수정했습니다',
board_image = 'images/logo222.png',
board_date = sysdate
where board_seq = 5
and board_password = '철수12';