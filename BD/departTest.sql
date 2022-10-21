create table departments(
	id serial primary key,
	name varchar(255)
);

create table employees (
	id serial primary key,
	name varchar(255),
	departments_id int references departments(id)
);

insert into departments(name) values('first');
insert into departments(name) values('second');
insert into departments(name) values('third');

insert into employees(name, departments_id) values ('Jade', 1);
insert into employees(name, departments_id) values ('Russel', 2);
insert into employees(name, departments_id) values ('Bill', 3);
insert into employees(name, departments_id) values ('Shrek', 1);
insert into employees(name, departments_id) values ('Donkey', 1);
insert into employees(name, departments_id) values ('Sam', 2);
insert into employees(name, departments_id) values ('Maria', 2);
insert into employees(name, departments_id) values ('Liam', 2);
insert into employees(name, departments_id) values ('Snake', 3);
