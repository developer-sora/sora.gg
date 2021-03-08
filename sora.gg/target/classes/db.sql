create table toprankergame (
g_number number (15) primary key
);
select * from toprankergame

 -- 만들어짐
create table champpick (
pickchamp number(5) not null,
benchamp number(5) not null
);
select * from champpick
-- 만들어짐

create table toprankeruser (
s_name varchar2 (100 char) primary key,
s_aid varchar2 (100 char) not null
);

DROP TABLE toprankeruser CASCADE CONSTRAINT;

-- 만드러짐

