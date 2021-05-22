drop table members;
drop table books;
drop table borrows;

drop sequence borrows_code_seq;
drop sequence books_children_seq;
drop sequence books_essay_seq;
drop sequence books_novel_seq;

create table members(
    m_id varchar2(30) constraint members_id_PK primary key,
    m_pass varchar2(30) not null,
    m_name varchar2(20) not null,
    birth date,
    phone varchar2(15),
    borr_count number(1) default 0,
    rsv_count number(1) default 0
);

create table books(
    b_code number(3) constraint books_code_PK primary key,
    b_name varchar2(60) not null,
    author varchar2(30) not null,
    pub varchar2(30) not null,
    pub_date date not null,
    cover varchar2(30),
    category varchar2(20) not null,
    b_status varchar2(12) default '대출가능',
    rsv_status varchar2(12)
);

create table borrows(
    borr_code number(4) constraint borrows_code_PK primary key,
    b_code constraint borrows_book_code_FK references books(b_code) ON DELETE CASCADE,
    m_id constraint borrows_member_id_FK references members(m_id) ON DELETE CASCADE,
    borr_date date default sysdate,
    return_date date default sysdate + 14,
    borr_status varchar2(12),
    rsv_member constraint borrows_rsv_member_FK references members(m_id)
);

-- ==============================================================
create sequence borrows_code_seq
    start with 1000;

create sequence books_children_seq
    start with 100;
    
create sequence books_essay_seq
    start with 200;

create sequence books_novel_seq
    start with 300;
-- ==============================================================
insert into books(b_code, b_name, author, pub, pub_date, cover, category) 
values(books_novel_seq.nextval, '달러구트 꿈 백화점', '이미예', '팩토리나인', '20/07/08', 'covers/lmyd.png', '소설');
insert into books(b_code, b_name, author, pub, pub_date, cover, category) 
values(books_novel_seq.nextval, '달러구트 꿈 백화점', '이미예', '팩토리나인', '20/07/08', 'covers/lmyd.png', '소설');
insert into books(b_code, b_name, author, pub, pub_date, cover, category) 
values(books_novel_seq.nextval, '아몬드', '손원평', '창비', '17/03/31', 'covers/swpa.png', '소설');
insert into books(b_code, b_name, author, pub, pub_date, cover, category) 
values(books_novel_seq.nextval, '보건교사 안은영', '정세랑', '민음사', '20/09/11', 'covers/jsrb.png', '소설');
insert into books(b_code, b_name, author, pub, pub_date, cover, category) 
values(books_novel_seq.nextval, '시선으로부터,', '정세랑', '문학동네', '20/06/05', 'covers/jsrs.png', '소설');
insert into books(b_code, b_name, author, pub, pub_date, cover, category) 
values(books_novel_seq.nextval, '소년이 온다', '한강', '창비', '14/05/19', 'covers/hks.png', '소설');
insert into books(b_code, b_name, author, pub, pub_date, cover, category) 
values(books_novel_seq.nextval, '기억 1', '베르나르 베르베르', '열린책들', '20/05/30', 'covers/BRNK1.png', '소설');
insert into books(b_code, b_name, author, pub, pub_date, cover, category) 
values(books_novel_seq.nextval, '심판', '베르나르 베르베르', '열린책들', '20/09/05', 'covers/BRNS.png', '소설');
insert into books(b_code, b_name, author, pub, pub_date, cover, category) 
values(books_novel_seq.nextval, '데미안', '헤르만 헤세', '민음사', '09/01/20', 'covers/hrmd.png', '소설');
insert into books(b_code, b_name, author, pub, pub_date, cover, category) 
values(books_novel_seq.nextval, '페인트', '이희영', '창비', '19/04/19', 'covers/lhyp.png', '소설');
insert into books(b_code, b_name, author, pub, pub_date, cover, category) 
values(books_novel_seq.nextval, '피프티 피플', '정세랑', '창비', '16/11/21', 'covers/jsrf.png', '소설');

insert into books(b_code, b_name, author, pub, pub_date, cover, category) 
values(books_essay_seq.nextval, '애쓰지 않고 편안하게', '김수현', '놀', '20/05/14', 'covers/ksha.png', '에세이');
insert into books(b_code, b_name, author, pub, pub_date, cover, category) 
values(books_essay_seq.nextval, '나는 나로 살기로 했다', '김수현', '마음의숲', '20/03/16', 'covers/kshn.png', '에세이');
insert into books(b_code, b_name, author, pub, pub_date, cover, category) 
values(books_essay_seq.nextval, '보통의 언어들', '김이나', '위즈덤하우스', '20/05/27', 'covers/kinb.png', '에세이');
insert into books(b_code, b_name, author, pub, pub_date, cover, category) 
values(books_essay_seq.nextval, '여행의 이유', '김영하', '문학동네', '19/04/17', 'covers/kyhy.png', '에세이');
insert into books(b_code, b_name, author, pub, pub_date, cover, category) 
values(books_essay_seq.nextval, '언어의 온도', '이기주', '말글터', '16/08/19', 'covers/lkju.png', '에세이');
insert into books(b_code, b_name, author, pub, pub_date, cover, category) 
values(books_essay_seq.nextval, '배움의 발견', '타라 웨스트오버', '열린책들', '20/01/05', 'covers/trwb.png', '에세이');

insert into books(b_code, b_name, author, pub, pub_date, cover, category) 
values(books_children_seq.nextval, '추리 천재 엉덩이 탐정 1', '트롤', '아이세움', '16/08/10', 'covers/trc1.png', '어린이');
insert into books(b_code, b_name, author, pub, pub_date, cover, category) 
values(books_children_seq.nextval, '추리 천재 엉덩이 탐정 2', '트롤', '아이세움', '16/11/25', 'covers/trc2.png', '어린이');
insert into books(b_code, b_name, author, pub, pub_date, cover, category) 
values(books_children_seq.nextval, '추리 천재 엉덩이 탐정 3', '트롤', '아이세움', '17/03/30', 'covers/trc3.png', '어린이');
insert into books(b_code, b_name, author, pub, pub_date, cover, category) 
values(books_children_seq.nextval, '아홉 살 마음 사전', '박성우', '창비', '17/03/10', 'covers/pswa.png', '어린이');
insert into books(b_code, b_name, author, pub, pub_date, cover, category) 
values(books_children_seq.nextval, '만복이네 떡집', '김리리', '비룡소', '10/05/28', 'covers/krrm.png', '어린이');
insert into books(b_code, b_name, author, pub, pub_date, cover, category) 
values(books_children_seq.nextval, '장군이네 떡집', '김리리', '비룡소', '20/04/29', 'covers/krrj.png', '어린이');

-- ==============================================================
-- 대출중인 도서 view
create or replace view borrowing_view
as
select * from borrows where borr_status = '대출중';

select * from borrowing_view;
-- ==============================================================
-- 회원가입
insert into members(m_id, m_pass, m_name, birth, phone)
values('hun2', '훈이12', '훈이', '15/03/02', '010-3333-2222');

-- ==============================================================
-- join view
create or replace view search_books_view
as
select b_code, b_name, author, pub, pub_date, 
    nvl(cover, '이미지없음') cover, category, b_status,
    decode(return_date, null, '-', return_date) return_date, 
    decode(rsv_status, null, '-', rsv_status) rsv_status
from books left outer join borrowing_view using(b_code);

-- 전체도서
select b_code, b_name, author, pub, pub_date, cover, b_status, return_date, rsv_status
from search_books_view;

-- 도서명으로 검색
select b_code, b_name, author, pub, pub_date, cover, b_status, return_date, rsv_status
from search_books_view
where b_name like '%달러구트%';

-- 작가명으로 검색
select b_code, b_name, author, pub, pub_date, cover, b_status, return_date, rsv_status
from search_books_view
where author like '%세랑%';

-- 카테고리별 조회
select b_code, b_name, author, pub, pub_date, cover, b_status, return_date, rsv_status
from search_books_view
where category = '소설';

-- ==============================================================

-- 1. 일반 도서 대출
create or replace procedure borrow(bcode in number, mid in varchar2, message out varchar2)
is
	exists_borr char(1);
	borrCount members.borr_count%type;
begin
	-- 해당 책이 대출가능한 상태인지 확인
	select
	case when exists(select * from books where b_code = bcode and b_status = '대출가능') then '1'
	else '0' end
	into exists_borr
	from dual;
    -- 해당 멤버의 도서 대출 권수를 저장
	select borr_count into borrCount from members where m_id = mid;

	-- 대출중이면
	if(exists_borr = '0') then message := 'XX대출실패XX : 이미 대출중인 도서입니다.';
	-- 대출권수가 2권 이상이면
	elsif(borrCount >= 2) then message := 'XX대출실패XX : 최대 2권까지만 대출 가능합니다.';
	else
		insert into borrows(borr_code, b_code, m_id, borr_status)
		values(borrows_code_seq.nextval, bcode, mid, '대출중');
        
        update books
        set b_status = '대출중', rsv_status = '예약가능'
        where b_code = bcode;
    
        update members
        set borr_count = borr_count + 1
        where m_id = mid;
		
        message := '대출이 완료되었습니다.';
	end if;
end;
/

-- 2. 일반 도서 반납
create or replace procedure returnBook(bcode in number, mid in varchar2, message out varchar2)
is
	exists_return char(1);
    exists_rsvmem char(1);
begin
	-- 반납가능한책이있는지
	select
	case when exists(select * from borrowing_view 
                    where b_code = bcode and m_id = mid) then '1'
	else '0' end
	into exists_return
	from dual;

	--반납가능한책이있으면
    if(exists_return = '0') then message := 'XX반납실패XX : 반납 가능한 도서가 없습니다.';
    else
        -- 반납가능한 책이 있으면
        -- 예약중인 회원이 있는지 체크
        select nvl2(rsv_member, '1', '0')
        into exists_rsvmem
        from borrowing_view
        where b_code = bcode and m_id = mid;
        
        -- 예약중인 회원이 있으면
        if(exists_rsvmem = '1') then message := 'XX반납실패XX : 예약도서반납 기능을 이용하세요.';
        else
            --예약중인 회원이 없으면
            -- 대출이력변경
            update borrows set borr_status = '반납', return_date = sysdate
            where borr_code = ( select borr_code
                                from borrowing_view
                                where b_code = bcode and m_id = mid );
            
            -- 회원 도서 대출 권수 -1
            update members set borr_count = borr_count -1
            where m_id = mid;
            
            -- 책 상태 변경
            update books set b_status = '대출가능', rsv_status = null
            where b_code = bcode;
            
            message := '반납이 완료되었습니다.';
        end if;
    end if;
   
end;
/

-- 3. 대출중인 책 예약
create or replace procedure rsvBook(bcode in number, mid in varchar2, message out varchar2)
is
    rsvStatus books.rsv_status%type;
    borrCode borrows.borr_code%type;
    borrowingMem borrows.m_id%type;
    rsvCount members.rsv_count%type;
    
    exists_borr char(1);
    exists_rsv char(1);
begin
    -- 책이 대출중인지
    select
    case when exists(select * from books 
                    where b_code = bcode and b_status = '대출중') then '1'
    else '0' end
    into exists_borr
    from dual;
    -- 예약가능상태인지
    select
    case when exists(select * from books 
                    where b_code = bcode and rsv_status = '예약가능') then '1'
    else '0' end
    into exists_rsv
    from dual;
    
    -- 대출가능상태면
    if(exists_borr = '0') then message := 'XX예약실패XX : 대출 가능한 책은 예약할 수 없습니다.';
    elsif(exists_rsv = '0') then message := 'XX예약실패XX : 이미 예약중인 도서입니다.';
    else
        -- 책의 대출코드와 대출중인 회원 아이디를 저장
        select borr_code, m_id
        into borrCode, borrowingMem
        from borrows
        where b_code = bcode and borr_status = '대출중';
        -- 예약하는 회원의 rsv_count를 저장
        select rsv_count into rsvCount from members where m_id = mid;
        
        if(borrowingMem = mid) then message := 'XX예약실패XX : 회원님이 대출중인 도서는 예약할 수 없습니다.';
        elsif(rsvCount >= 1) then message := 'XX예약실패XX : 예약은 1인당 1권만 가능합니다.';
        else
            update borrows
            set rsv_member = mid
            where borr_code = borrCode;
                
            update books
            set rsv_status = '예약중'
            where b_code = bcode;

            update members
            set rsv_count = rsv_count + 1
            where m_id = mid;
        
            message := '예약이 완료되었습니다.';
        end if;
    end if;

end;
/

-- 4. 예약중인 책 반납하기
create or replace procedure rsvBookReturn(bcode in number, mid in varchar2, message out varchar2)
is
    exists_return char(1);
    exists_rsvmem char(1);
    borrCode borrows.borr_code%type;
begin
    -- 반납가능한 도서가 있는지
    select 
    case when exists(select * from borrowing_view
                     where b_code = bcode and m_id = mid) then '1'
    else '0' end
    into exists_return
    from dual;
    
    if(exists_return = '0') then message := 'XX반납실패XX : 반납 가능한 도서가 없습니다.';
    else
        -- 반납가능한 도서가 있으면
        -- 예약중인 회원이 있는지 체크
        select nvl2(rsv_member, '1', '0') 
        into exists_rsvmem
        from borrowing_view 
        where b_code = bcode and m_id = mid;
        
        -- 예약중인 회원이 없으면
        if(exists_rsvmem = '0') then message := 'XX반납실패XX : 일반 반납 기능을 이용하세요.';
        else
            --예약중인 회원이 있으면
            -- 그 도서의 대출 코드를 저장
            select borr_code
            into borrCode
            from borrowing_view
            where b_code = bcode and m_id = mid;
        
            -- 대출이력 변경
            update borrows
            set borr_status = '반납', return_date = sysdate
            where borr_code = borrCode;
        
            -- 회원의 도서 권수 빼기
            update members
            set borr_count = borr_count - 1
            where m_id = mid;
            
            
            message := '반납이 완료되었습니다.';
        end if;
    end if;
end;
/

-- 5. 예약한 책 대출하기
create or replace procedure rsvBookBorrow(mid in varchar2, message out varchar2)
is
    exists_borr char(1);
    rsvCount members.rsv_count%type;
    borrCount members.borr_count%type;
    bookCode books.b_code%type;
    borrCode borrows.borr_code%type;
    returnMessage varchar2(300);
begin
    -- 예약한 도서가 있는지, 대출중인 책이 몇권인지
    select rsv_count, borr_count 
    into rsvCount, borrCount 
    from members 
    where m_id = mid;

    -- 대출 가능한 예약도서가 있는지
    select 
    case when exists(select * from borrows where rsv_member = mid and borr_status = '반납') then '1'
    else '0' end
    into exists_borr
    from dual;
    
    if(rsvCount = 0) then message := 'XX대출실패XX : 예약한 도서가 없습니다.';
    elsif(exists_borr = '0') then message := 'XX대출실패XX : 대출 가능한 예약 도서가 없습니다.';
    elsif(borrCount >= 2) then message := 'XX대출실패XX : 최대 2권까지만 대출 가능합니다.';
    else
        -- 책을 대출 가능한 상태로 만들기
        -- 예약한 책 찾기
        select b_code, borr_code into bookCode, borrCode from borrows where rsv_member = mid;
        
        update books set b_status = '대출가능' 
        where b_code = bookCode;
        
        -- borrow 프로시저 부르기
        borrow(bookCode, mid, returnMessage);

        -- borr 테이블 rsv_member = null로 만들기
        update borrows set rsv_member = null where rsv_member = mid;
        update members set rsv_count = 0 where m_id = mid;
        
        message := returnMessage;
    end if;

end;
/

/*
create or replace procedure borrow(bookCode in number, memberID in varchar2, resultNum out number)
is
    bookStatus books.b_status%type;
    borrCount members.borr_count%type;
begin
    select b_status 
    into bookStatus
    from books 
    where b_code = bookCode;
    
    select borr_count
    into borrCount
    from members
    where m_id = memberID;
    
    if(bookStatus = '대출중') then resultNum := 1;
    elsif(borrCount >= 2) then resultNum := 2;
    elsif(bookStatus = '대출가능' and borrCount < 2) then
        insert into borrows(borr_code, b_code, m_id, borr_status)
        values(borrows_code_seq.nextval, bookCode, memberID, '대출중');
        resultNum := 3;
    else resultNum := 0;
    end if;
    
end;
/
*/
commit;
--variable message number(1);
--execute borrow(300, 'hun2', :message);
-- 반납
 /*    
	if(exists_return = '1') then
		update borrows
		set borr_status = '반납', return_date = sysdate
		where b_code = bcode and m_id = mid and borr_status = '대출중';

		update books
        set b_status = '대출가능'
        where b_code = bcode;
    
        update members
        set borr_count =borr_count - 1
        where m_id = mid;
		message := 1;
	else message := 0;
	end if;*/
/*
-- 반납
update borrows
set borr_status = '반납', return_date = sysdate
where borr_code = 1002 and m_id = 'hun2' and borr_status = '대출중';
*/
-- ==============================================================
/*
drop trigger trigger_borrow;
drop trigger trigger_return;
SELECT * FROM ALL_TRIGGERS where table_name = 'BORROWS';
-- 대출 시 트리거
create or replace trigger trigger_borrow
after insert on borrows
for each row
begin
    update books
    set b_status = '대출중'
    where b_code = :NEW.b_code;
    
    update members
    set borr_count = borr_count + 1
    where m_id = :NEW.m_id;
end;
/

-- 반납 시 트리거
create or replace trigger trigger_return
after update on borrows
for each row
begin
    update books
    set b_status = '대출가능'
    where b_code = :NEW.b_code;
    
    update members
    set borr_count = decode(borr_count, 0, 0, borr_count - 1)
    where m_id = :NEW.m_id;
end;
/
*/
-- ==================== 마이페이지 ==========================================
-- 개인정보 수정
update members
set m_pass = '훈이비번바꿈', phone = '010-3232-3232'
where m_id = 'hun2';

select * from members;
commit;
-- 특정 멤버가 대출중인 도서 조회
select borr_code, b_name, author, borr_date, return_date, borr_status
from borrowing_view join books using(b_code)
where m_id = 'hun2';

-- 특정 멤버의 모든 대출 이력 조회
select borr_code, b_name, author, borr_date, return_date, borr_status
from borrows join books using(b_code)
where m_id = 'hun2'
order by return_date desc;

-- 기간 연장
update borrowing_view
set return_date = return_date + 7
where borr_code = 1007 and m_id = 'jj9';
select * from borrowing_view;
select * from borrows;
commit;

-- 회원 탈퇴
delete from members
where m_id = 'jj9' and borr_count = 0;
-- ==============================================================
select * from members;
select * from search_books_view;
select * from borrows order by borr_status, b_code;
select * from borrowing_view;

variable aab number;
execute rsvBook(100, 'hun2', :aab);
print aab;

execute borrow(300, 'hun2', :aab);
print aab;

select borr_count from members where m_id = 'hun2';
select rsv_count from members where m_id = 'hun2';

commit;

select * from borrows where rsv_member = 'hun2';

select borr_code, b_code, b_name, author, borr_date, return_date, borr_status, rsv_member
from borrows join books using(b_code)
where rsv_member = 'aodrn';

desc BORROWS;