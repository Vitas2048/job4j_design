create table monitors(
    id serial primary key,
    names varchar(255),
    gaming boolean,
    frequency integer
);
insert into monitors(names, gaming, frequency) values('Asus', true, 144);
update monitors set names = 'Samsung';
delete from monitors;
select * from monitors;