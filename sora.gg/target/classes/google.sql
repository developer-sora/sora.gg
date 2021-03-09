create table google_id(
g_user_id varchar2(30 char) primary key,
g_email varchar2(20 char) not null,
g_name varchar2(10 char) not null
);

select * from google_id;

drop table google_id cascade constraint purge;

