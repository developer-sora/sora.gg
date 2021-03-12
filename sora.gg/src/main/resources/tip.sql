create table champion_tip(
c_no number(4) primary key,
c_writer varchar2 (50 char),
c_name varchar2 (50 char) not null,
c_comment varchar2 (500 char) not null
);

select * from champion_tip;

create sequence champion_tip_seq;

insert into champion_tip values(3, '말자하', '손 동작 느리다');

drop table champion_tip cascade constraint purge;
