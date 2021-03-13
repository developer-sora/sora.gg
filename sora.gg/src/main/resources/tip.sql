create table champion_tip(
c_no number(4) primary key,
c_writer varchar2 (50 char),
c_name varchar2 (50 char) not null,
c_comment varchar2 (500 char) not null,
c_date date not null
);

select * from champion_tip;

create sequence champion_tip_seq;

insert into CHAMPION_TIP values (100, null, 'Malzahar', '공허의 버러지', sysdate);
insert into CHAMPION_TIP values (101, null, 'Malzahar', '공허의 버러지 조종자', sysdate);
insert into CHAMPION_TIP values (seq, null, "챔피언 이름 ", 코멘트, sysdate);

drop table champion_tip cascade constraint purge;

