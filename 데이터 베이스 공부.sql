create table addresses(_id integer primary key autoincrement ,name text,phone text,address text);/*생성*/

select * from addresses;/*전체 출력*/

insert into addresses(name,phone,address) values('이름','전화번호','주소');/*삭제*/
insert into addresses(name,phone,address) values('첫째','111-1111-1111','1시1동1길'); /*삽입*/
insert into addresses(name,phone,address) values('둘째','222-2222-2222','2시2동2길');

insert into addresses(name,phone,address) values('셋째','333-3333-3333','3시3동3길');
insert into addresses(name,phone,address) values('넷째','444-4444-4444','4시4동4길');
insert into addresses values(null,'다섯','555','5시5동');

select phone from address where name='이름'; /*문자열 비교해서 1개만 가져오기*/

delete from addresses where _id=2; /*삭제*/
drop table addresses; /*데이터 버리기*/

update addresses set name='김길동';/*모든값 교체*/
update addresses set name='김길동' where  _id=1;/*특정값만 교체*/

select name from addresses  where name like '이%';/*부분일치*/

select *from addresses order by name ; /*오름차순*/
select *from addresses order by name desc; /*내림차순*/