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

-- 김길수 만드러짐
SELECT banchamp, COUNT(*) FROM champban GROUP BY banchamp;
SELECT banchamp, COUNT(*) FROM champban GROUP BY banchamp HAVING COUNT(*)>5 order by count(*) desc;
