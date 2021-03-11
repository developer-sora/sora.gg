create table champion_tip(
c_no number(4) primary key,
c_name varchar2 (10 char) not null,
c_comment varchar2 (500 char) not null
);

select * from champion_tip;

create sequence champion_tip_seq;

insert into champion_tip values(4, '소환사', '손 동작 느리다');