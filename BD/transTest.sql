begin transaction;
delete from numbers where name='nine';
insert into numbers(name) values('eleven');
commit;

begin transaction isolation level repeatable read;
delete from numbers where name='eleven';
insert into numbers(name) values('twelve');
commit;