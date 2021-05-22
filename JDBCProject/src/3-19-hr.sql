-- ====================== PL/SQL ======================
-- ppt 20장 PL/SQL
-- SQL 언어에 절차적인 프로그래밍 언어를 가미해 만든 것
-- if, loop while, for 등을 지원
-- 선언부(declare), 실행부(executable), 예외처리부(exception)
-- PL/SQL 문법 --> 함수,프로시저 작성
-- 여러 DML문장을 한꺼번에 실행하고싶을 때
-- 미리 컴파일해놓기 때문에 속도가 빠르다
-- 한번 만들어놓으면 재사용이 좋다

---------------------- 프로시저 작성 --------------------
-- 실행 : /
set serveroutput on;    -- 서버에 설정 : 출력을 보여주겠다는 의미
declare
    /* 변수 선언 */
    /* 스칼라변수 */
    v_empno number(4);
    v_empname varchar2(20);
    /* 레퍼런스 변수 */
    v_empno2 employees.employee_id%type;    -- employee_id 컬럼과 type이 같다
    v_empname2 employees.first_name%type;
    v_emp employees%rowtype;      -- recode : 컬럼 여러개를 묶어놓은 것
                                  --employees table의 모든 컬럼을 쓸 수 있다.
begin
    /* 할당 := 으로 */
    v_empno := 100;          
    v_empname := '홍길동';
    v_empno2 := 200;
    v_empname2 := '홍길동2';
    
    v_emp.salary := 10000;
    v_emp.first_name := '홍길동3';
    
    
    dbms_output.put_line('Hello!');     -- ""는 안됨
    dbms_output.put_line('아이디는 '||v_empno);
    dbms_output.put_line('이름은 '||v_empname);
    dbms_output.put_line('2아이디는 '||v_empno2);
    dbms_output.put_line('2이름은 '||v_empname2);
    dbms_output.put_line('salary '||v_emp.salary);
    dbms_output.put_line('first_name '||v_emp.first_name);
end;
/

------------- PL/SQL select, table, record --------------------
declare
    v_empid number := 200;
    v_fname employees.first_name%type;
    v_salary employees.salary%type;
    
    /* PL/SQL table */
    -- 타입을 선언
    TYPE  ENAME_TABLE_TYPE IS TABLE OF employees.first_name%TYPE
        INDEX BY BINARY_INTEGER;
    TYPE  JOB_TABLE_TYPE IS TABLE OF employees.job_id%TYPE
        INDEX BY BINARY_INTEGER;
    -- 변수선언 (변수이름 변수타입)
    first_name_arr ENAME_TABLE_TYPE;
    job_id_arr JOB_TABLE_TYPE;
    idx BINARY_INTEGER := 0;        -- 배열의 첨자로 쓸것, 0부터 시작
    
    /* record, 4개의 컬럼만 묶어서 가져오기 */
    -- 특정 컬럼만 묶고싶으면 record 타입 선언하기
    -- record 타입 선언, 컬럼 변수 선언
    TYPE emp_record_type IS RECORD(
        v_empno    employees.employee_id%TYPE,
        v_ename    employees.first_name%TYPE,
        v_job    employees.job_id%TYPE,
        v_deptno  employees.department_id%TYPE);
    -- record 변수 선언(변수이름 변수타입)
    emp_record emp_record_type;
    
    emp_record2 employees%rowtype;

begin
    /* PL/SQL select문. 1건 조회 */
    select first_name, salary 
    into v_fname, v_salary
    from employees 
    where employee_id = v_empid;
    
    dbms_output.put_line('v_empid = '||v_empid);
    dbms_output.put_line('v_fname = '||v_fname);
    dbms_output.put_line('v_salary = '||v_salary);
    
    DBMS_OUTPUT.PUT_LINE('**************************************************');
    
    /* table, for문장 */
    /* 여러건 가져오기 */
    FOR empRecord IN (SELECT first_name, job_id FROM employees) LOOP
    idx := idx + 1;                --인덱스 증가
    first_name_arr(idx) := empRecord.first_name; --사원이름과 
    job_id_arr(idx) := empRecord.job_id;     --직급을 저장. 
    END LOOP;
    
    /* 값들 읽기 */
    FOR J IN 1..idx LOOP          
    DBMS_OUTPUT.PUT_LINE(RPAD(first_name_arr(J),12) 
       || ' / ' ||  RPAD(job_id_arr(J),9));
    END LOOP;
    
    /* record */
    DBMS_OUTPUT.PUT_LINE('******* emp_record *****************************');
    -- 레코드의 컬럼 이름을 정해놓은 경우, 레코드에 선언한 변수 이름을 쓴다.
    SELECT employee_id, first_name, job_id, department_id 
    into emp_record
    FROM employees
    where employee_id = 100;
    -- record 안에 4개의 컬럼이 들어간다.
    -- record 출력
    DBMS_OUTPUT.PUT_LINE(emp_record.v_empno);
    DBMS_OUTPUT.PUT_LINE(emp_record.v_ename);
    DBMS_OUTPUT.PUT_LINE(emp_record.v_job);
    DBMS_OUTPUT.PUT_LINE(emp_record.v_deptno);
    
    DBMS_OUTPUT.PUT_LINE('******* emp_record2 *****************************');
    -- 레코드에 컬럼 변수를 선언하지 않았다면? 원래 테이블의 컬럼이름을 쓴다.
    SELECT *
    into emp_record2
    FROM employees
    where employee_id = 100;
    
    DBMS_OUTPUT.PUT_LINE(emp_record2.employee_id);
    DBMS_OUTPUT.PUT_LINE(emp_record2.last_name);
    DBMS_OUTPUT.PUT_LINE(emp_record2.email);
    DBMS_OUTPUT.PUT_LINE(emp_record2.salary);
 
end;
/

----------------- PL/SQL IF --------------------
declare
    emp_record2 employees%rowtype;      --모든컬럼이 다 들어옴
                                        --배열이 아니라서 한건만 들어올수있음
begin
    SELECT *
    into emp_record2
    FROM employees
    where employee_id = 150;
    
    if(emp_record2.commission_pct is null) then
        DBMS_OUTPUT.PUT_LINE('null이다 '||emp_record2.salary*12);
    else
        DBMS_OUTPUT.PUT_LINE('null이 아니다 '||(emp_record2.salary*12+emp_record2.salary*emp_record2.commission_pct));
    end if;
    DBMS_OUTPUT.PUT_LINE(emp_record2.employee_id);
    DBMS_OUTPUT.PUT_LINE(emp_record2.last_name);
    DBMS_OUTPUT.PUT_LINE(emp_record2.email);
    DBMS_OUTPUT.PUT_LINE(emp_record2.salary);
end;
/

----------------- PL/SQL loop --------------------
declare
    num number := 1;        -- 초기값 주기
begin
    /* 1. basic loop */
    loop
        dbms_output.put_line('basic loop: '||num);
        num := num + 1;
        if(num > 5) then 
            exit;
        end if;
    end loop;
    
    /* 2. for loop */
    for i in 1..5 loop
        dbms_output.put_line('for loop: '||i);
    end loop;
    
    /* 3. while loop */
    num := 1;
    while(num <= 5) loop
        dbms_output.put_line('while loop: '||num);
        num := num + 1;
    end loop;
end;
/


-- =================== 저장 프로시저, 함수, 커서 ======================
-- 저장프로시저 : PL/SQL문을 데이터베이스에 저장
-- 복잡한 DML문들을 필요할 때마다 다시 입력할 필요 없이 간단하게 호출한다.
-- 한번만 컴파일 하고 여러번 재사용
-- 성능향상

-- 프로시저 컴파일 --> 서버에 sp_print5 라는 프로시저가 저장됨
create or replace procedure sp_print5
is
    num number := 1;        -- 초기값 주기
begin
    /* 1. basic loop */
    loop
        dbms_output.put_line('basic loop: '||num);
        num := num + 1;
        if(num > 5) then 
            exit;
        end if;
    end loop;
    
    /* 2. for loop */
    for i in 1..5 loop
        dbms_output.put_line('for loop: '||i);
    end loop;
    
    /* 3. while loop */
    num := 1;
    while(num <= 5) loop
        dbms_output.put_line('while loop: '||num);
        num := num + 1;
    end loop;
end;
/

-- 프로시저 실행, DBMS TOOL 아무데서나 사용가능
execute sp_print5;

-- 저장 프로시저 오류 원인 살피기
SQL> SHOW ERROR;

-- 저장된 프로시저 보기
desc user_source;
select * from user_source;
select * from user_source where name = 'SP_PRINT5';

----------------------- 매개변수가 있는 프로시저 ------------------


-- 1. 프로시저 생성                       -- number 타입으로 들어온다                               
create or replace procedure sp_empinfo(v_empid in number, v_fname out varchar2, v_job out varchar2, v_sal out number)
                                                        -- varchar2타입이 나간다
is
    /* 변수 선언 */
    aa varchar2(20);
begin
    -- select 한 것을 out할 변수에 담음
    select first_name, job_id, salary
    into v_fname, v_job, v_sal
    from employees
    where employee_id = v_empid;
    
end;
/

-- 2. 변수 선언
variable a varchar2(20);
variable b varchar2(20);
variable c number;

-- 3. 프로시저 실행
execute sp_empinfo(100, :a, :b, :c);

-- 4. 결과
print a;
print b;
print c;

-------------------------- 저장 함수 ------------------------
-- 함수는 out이 아니고 return
-- sql 문장(DML문장)에서도 함수를 쓸 수 있다!!!

-- 모든 직원에게 보너스 50% 지급하기
-- 보너스 %가 바뀐다면 유지보수가 번거로움 --> 함수로 만들기
select first_name, salary, salary*0.5 보너스
from employees;

create or replace function func_bonus(sal in number) return number  -- 리턴타입
is
    result number(10, 2);   -- 전체 두자리 소수 밑 두자리
begin
    result := sal * 0.5;
    return result;
end;
/

select first_name, salary, salary*0.5 보너스, func_bonus(salary) 보너스2
from employees;