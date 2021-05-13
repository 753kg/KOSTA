create table cust_account(
	accountNO varchar2(20) primary key,
	custName varchar2(50),
	balance number(20,4)
);

delete from cust_account;
insert into cust_account values('112', '홍길동', 100000);

insert into cust_account values('113', '성덕', 100000);

commit;

select * from cust_account;