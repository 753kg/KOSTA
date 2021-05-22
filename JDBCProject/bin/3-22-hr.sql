-- ================== 커서 ====================
-- select문 -> 처리 결과가 여러개일 때 커서를 이용해야한다.

-------------- 명시적인 커서 ---------------
create or replace procedure sp_emplist
is
    /* 선언부 */
    -- record 선언
    v_emp_record employees%rowtype;
    -- 1. cursor 선언
    cursor cur_emp is select employee_id, first_name, last_name from employees;
begin
    /* 실행부 */
    -- 2. cursor 실행
    open cur_emp;
    -- 3. 한건씩 fetch
    loop
        fetch cur_emp into v_emp_record.employee_id, v_emp_record.first_name, v_emp_record.last_name;
        exit when cur_emp%notfound;     -- 데이터가 없으면 exit
        dbms_output.put_line('직원번호:'||v_emp_record.employee_id);
        dbms_output.put_line('first_name:'||v_emp_record.first_name);
        dbms_output.put_line('last_name:'||v_emp_record.last_name);
        dbms_output.put_line('-----------------------------');
    end loop;
    -- 4. cursor 닫기
    close cur_emp;
end;
/

set serveroutput on;
execute SP_EMPLIST;

------------ 암시적인 커서 : FOR LOOP -----------------
create or replace procedure sp_emplist
is
begin
    for emp_rec in (select employee_id, first_name, last_name from employees) loop
        dbms_output.put_line('직원번호:'||emp_rec.employee_id);
        dbms_output.put_line('first_name:'||emp_rec.first_name);
        dbms_output.put_line('last_name:'||emp_rec.last_name);
        dbms_output.put_line('-----------------------------');
    end loop;
end;
/

set serveroutput on;
execute SP_EMPLIST;

-- ==================== 패키지 ===========================
-- 여러개의 프로시저나 함수를 패키지로 묶음
-- 선언부, 실행부(body)를 만든다.
-- 선언을 두번해야함. 선언부와 실행부(몸체부)에 두번.

/* 패키지 선언부 */
create or replace package pkg_sp2
is
    -- 프로시저 2개 만들고 하나의 패키지로 만들것이다.
    procedure sp_emplist1;
    procedure sp_emplist2;

end;
/
/* 패키지 실행부 */
create or replace package body pkg_sp2
is
    -- 프로시저 구현
    procedure sp_emplist1
    is
        /* 선언부 */
        -- record 선언
        v_emp_record employees%rowtype;
        -- 1. cursor 선언
        cursor cur_emp is select employee_id, first_name, last_name from employees;
    begin
        /* 실행부 */
        -- 2. cursor 실행
        open cur_emp;
        -- 3. 한건씩 fetch
        loop
            fetch cur_emp into v_emp_record.employee_id, v_emp_record.first_name, v_emp_record.last_name;
            exit when cur_emp%notfound;     -- 데이터가 없으면 exit
            dbms_output.put_line('직원번호:'||v_emp_record.employee_id);
            dbms_output.put_line('first_name:'||v_emp_record.first_name);
            dbms_output.put_line('last_name:'||v_emp_record.last_name);
            dbms_output.put_line('-----------------------------');
        end loop;
        -- 4. cursor 닫기
        close cur_emp;
    end;
    
    procedure sp_emplist2
    is
    begin
        for emp_rec in (select employee_id, first_name, last_name from employees) loop
            dbms_output.put_line('직원번호:'||emp_rec.employee_id);
            dbms_output.put_line('first_name:'||emp_rec.first_name);
            dbms_output.put_line('last_name:'||emp_rec.last_name);
            dbms_output.put_line('-----------------------------');
        end loop;
    end;
    
end;
/

/* 실행 ==> 패키지이름.프로시저 */
execute PKG_SP2.sp_emplist1;
execute PKG_SP2.sp_emplist2;

-- ==================== 트리거 =======================
-- trigger : 자동으로 실행되는 procedure

create or replace trigger trigger_jobs
after insert on jobs
begin
    dbms_output.put_line('jobs table에 1건 입력됨');
end;
/

desc jobs;
insert into jobs values('test', 'test 내용', 1000, 2000);
select * from jobs;

---------------------------------------------------
create table jobs_ref(
    salno number(4) primary key,
    sal number(7, 2),
    job_id varchar2(10) references jobs(job_id)
);

-- jobs에 insert되면 jobs_ref에 insert

create sequence jobs_ref_seq;

-- :NEW ==> jobs 테이블에 insert한 데이터를 의미
create or replace trigger trigger_jobs
after insert on jobs
for each row
begin
    dbms_output.put_line('jobs table에 1건 입력됨');
    insert into jobs_ref values(jobs_ref_seq2.nextval, :NEW.max_salary, :NEW.job_id);
end;
/

insert into jobs values('test5', 'test 내용', 1000, 9999);

-----------------------------------------------------

-- :old ==> delete한 그 데이터를 의미
-- jobs_ref가 jobs를 참조하므로 jobs_ref를 먼저 지워야함
-- after로 해도 문제가 없었는데 이유가 뭐지..?
create or replace trigger trigger_jobs_del
before delete on jobs
for each row
begin
    dbms_output.put_line('jobs table에 1건 삭제됨');
    delete from jobs_ref where job_id = :old.job_id;
end;
/

delete from jobs where job_id = 'test3';

desc jobs;
select * from jobs;
select * from jobs_ref;

------------------------------------------------
CREATE TABLE 상품(
    상품코드 CHAR(6) PRIMARY KEY,
    상품명 VARCHAR2(12) NOT NULL,
    제조사 VARCHAR(12),
    소비자가격 NUMBER(8),
    재고수량 NUMBER DEFAULT 0
);

INSERT INTO 상품(상품코드, 상품명, 제조사, 소비자가격)
VALUES('A00001','세탁기', 'LG', 500); 
INSERT INTO 상품(상품코드, 상품명, 제조사, 소비자가격)
VALUES('A00002','컴퓨터', 'LG', 700);
INSERT INTO 상품(상품코드, 상품명, 제조사, 소비자가격)
VALUES('A00003','냉장고', '삼성', 600);

commit;

-- 상품테이블에 있는 것만 입고됨
CREATE TABLE 입고(
    입고번호 NUMBER(6) PRIMARY KEY,
    상품코드 CHAR(6) REFERENCES 상품(상품코드),
    입고일자 DATE DEFAULT SYSDATE,
    입고수량 NUMBER(6),
    입고단가 NUMBER(8),
    입고금액 NUMBER(8)
);

-- 입고 될 때마다 상품테이블의 재고수량 업데이트
CREATE OR REPLACE TRIGGER TRG_04
AFTER INSERT ON 입고
FOR EACH ROW
BEGIN
    UPDATE 상품
    SET 재고수량 = 재고수량 + :NEW.입고수량
    WHERE 상품코드 = :NEW.상품코드;
END;
/ 

INSERT INTO 입고(입고번호, 상품코드, 입고수량, 입고단가, 입고금액) 
VALUES(4, 'A00002', 10, 320, 1600);

-- 갱신 트리거
CREATE OR REPLACE TRIGGER TRG03
AFTER UPDATE ON 입고
FOR EACH ROW
BEGIN
    UPDATE 상품
    SET 재고수량 = 재고수량 + (-:old.입고수량+:new.입고수량) 
    WHERE 상품코드 = :new.상품코드;
END;
/

update 입고
set 입고수량 = 100
where 입고번호 = 1;

select * from 상품;
select * from 입고;
