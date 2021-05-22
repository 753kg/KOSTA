-- [예제 2-1]
create table player_t(
    player_id char(7) constraint player_id_pk primary key,
    team_id char(3) not null,
    player_name varchar2(20),
    nickname varchar2(40),
    join_yyyy char(4),
    position char(2),
    back_no number(3),
    nation varchar2(20),
    birth date,
    solar char(1),
    height number(3),
    weight number(3)
);

desc player_t;

-- [예제2-2]
create table team_t(
    team_id char(3) constraint team_id_pk primary key,
    region_name varchar2(4) not null,
    stadium_id char(3) not null,
    team_name varchar2(20) not null,
    e_team_name varchar2(50),
    orig_yyyy char(4),
    owner varchar2(10),
    zip_code1 char(3),
    zip_code2 char(3),
    address varchar2(60),
    ddd varchar2(3),
    tel varchar2(10),
    fax varchar2(10),
    homepage varchar2(5)
);

-- [예제2-3]
create table stadium_t(
    stadium_id char(3),
    stadium_name varchar2(10),
    hometeam_id char(3),
    seat_count number,
    address varchar2(60),
    ddd varchar2(3),
    tel varchar2(10),
    fax varchar2(10)
);

-- [예제 2-4]
select * from player_t;

insert into player_t(player_id, team_id, player_name, position, back_no, height, weight)
    values(1997051, 'K02', '고종수', 'MF', 22, 176, 70);
insert into player_t(player_id, team_id, player_name, position, back_no, height, weight)
    values(1997035, 'K02', '이운재', 'GK', 1, 182, 82);
insert into player_t(player_id, team_id, player_name, position, back_no, height, weight)
    values(2000030, 'K07', '김남일', 'MF', 4, 182, 76);
insert into player_t(player_id, team_id, player_name, position, back_no, height, weight)
    values(1997213, 'K07', '김태영', 'DF', 7, 180, 74);
    
-- [예제2-5]
select player_name 선수명, position 위치, height 키, weight 몸무게
from player_t;

-- [예제 2-6] 소속팀이 삼성블루윙즈인 선수들의 이름,포지션,백넘버,키를 출력
-- 소속팀 코드 -  K02(삼성블루윙즈), K07(전남드레곤즈)
select player_name, position, back_no, height
from player_t
where team_id = 'K02';

-- [예제2-7] 키가 170 센티미터 이상인 선수들을 출력
select *
from player_t
where height >= 170;

-- [예제2-8] ‘K02' 또는 'K07' 팀에 소속되어 있는 선수들을 출력하시오  
-- IN ( list ) SQL문을 사용하세요
select * from player_t
where team_id in ('K02', 'K07');

-- [예제2-9] 포지션이 'MF' 인 선수들을 출력하세요.
select * from player_t
where position = 'MF';

-- [예제2-10] "고"씨 성을 가진 선수들의 정보를 출력하세요
select * from player_t
where player_name like '고%';

-- [예제2-11] 스텝들의 정보를 출력하세요. 스텝들은 포지션(position) 코드가 "T"자로 

-- [예제2-12] 키가 170 센티미터 이상 180센티미터 이하인 선수들의 정보를 출력하세요.
-- BETWEEN ~ AND 문을 사용하세요
select * from player_t
where height between 170 and 180;

--[예제2-13] 키 정보가 입력되지 않은 선수들을 출력하세요. NULL 을 사용하세요.
select *  from player_t
where height is null;

-- [예제2-14] 소속이 삼성블루윙즈팀이고 키가 170 센티미터 이상 선수
select *  from player_t
where team_id = 'K02' and height >= 170;

-- [예제2-15] 삼성블루윙즈 또는 전남드레곤즈 선수들중 포지션이 미드필드이고 
-- 키가 17이상 180이하의 조건을 가진 선수들의 정보를 조회하는 SQL문을 작성하세요.
select *  from player_t
where team_id in ('K02', 'K07') and height between 170 and 180;

-- [예제2-16] K-리스 선수들의 포지션별 평균 키는 얼마인가?
select avg(height)
from player_t
where team_id like 'K%'
group by position;

-- [예제2-17] 수원 삼성블루윙즈팀의 선수들의 포지션별 인원은 어떻게 되는가?
select position, count(*)
from player_t
where team_id = 'K02'
group by position;

-- [예제2-18] K-리그의 포지션별 키가 180센티미터 이상되는 선수중에서 가장 큰 키를 구하세요.
select position, max(height)
from player_t
where team_id like 'K%'
group by position
having max(height) >= 180;


-- [예제2-19] 포지션별 평균키를 구한다. 단 평균키가 180 센티미터 이상의 값만 출력하세요.
select position, avg(height)
from player_t
group by position
having avg(height) >= 180;

-- [예제2-20] K-리그의 선수들 중에서 팀별, 포지션별 평균키를 구하세요.
select team_id, position, avg(height)
from player_t
group by team_id, position;

-- [예제2-21] 선수들의 이름, 포지션, 백넘버를 출력하는데 선수들의 백넘버 순으로 출력하시오.
select player_name, position, back_no
from player_t
order by back_no;

-- [예제2-22] 예제2-21의 결과와 같지만 백넘버가 큰수부터 출력하시오
select player_name, position, back_no
from player_t
order by back_no desc;

-- [예제2-23]
select player_name||' 선수' 선수명, position, back_no
from player_t;