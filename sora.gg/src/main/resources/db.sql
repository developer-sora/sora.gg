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
DROP TABLE user_id CASCADE CONSTRAINT;

create table sora_duo(
	s_no number(4) primary key,	-- 글 번호
	s_writer varchar2(30 char) not null, -- 글쓴이 ID
	s_comment varchar2(200 char) not null,
	s_date date not null,
	-- 이 테이블에 제약 조건을 설정
	constraint duo_writer
		foreign key(s_writer) references user_id(u_email)
		on delete cascade 
);

create sequence sora_duo_seq;

insert into sora_duo values(1000, 'project.sora.gg@gmail.com', 'ㅎㅅㅎ', sysdate);

select * from sora_duo;
=======
-- 김길수 만드러짐
SELECT banchamp, COUNT(*) FROM champban GROUP BY banchamp;
SELECT banchamp, COUNT(*) FROM champban GROUP BY banchamp HAVING COUNT(*)>5 order by count(*) desc;



create table monthtoprankergame (
g_number number (15) primary key
);

create table monthchamppick (
pickchamp number(10) not null
);
create table monthchampban (
banchamp number(10) not null
);