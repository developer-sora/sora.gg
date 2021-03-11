create table toprankergame (
g_number number (15) primary key
);
select * from toprankergame

 -- 김길수 만들어짐
create table champpick (
pickchamp number(10) not null
);
select * from champpick
--drop table champpick
--drop table champban
-- 김길수 만들어짐
create table champban (
banchamp number(10) not null
);
select * from champban
-- 김길수 만들어짐

create table toprankeruser (
s_name varchar2 (100 char) primary key,
s_aid varchar2 (100 char) not null
);
select * from  toprankeruser;
DROP TABLE toprankeruser CASCADE CONSTRAINT;

-- 만드러짐

create table user_id(
u_email varchar2 (30 char) primary key,
u_nickname varchar2 (20 char) not null,
u_password varchar2 (20 char) not null
);

select * from user_id;
=======
-- 김길수 만드러짐
SELECT banchamp, COUNT(*) FROM champban GROUP BY banchamp;
SELECT banchamp, COUNT(*) FROM champban GROUP BY banchamp HAVING COUNT(*)>5 order by count(*) desc;
<<<<<<< HEAD
=======
>>>>>>> refs/remotes/origin/main




create table matchlist(
gameId number (15) primary key,
queue varchar2 (30char) not null,
gametime varchar2 (30char) not null,
championEn varchar2(15char) not null,
championKr varchar2(30char) not null,
position varchar2(15char) not null,
win varchar2(9char) not null
);
>>>>>>> branch 'main' of https://github.com/developer-sora/sora.gg.majimak.git
