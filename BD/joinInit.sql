create table departments(
	id serial primary key,
	name varchar(255)
);

create table employees(
	id serial primary key,
	name varchar(255),
	departments_id int references departments(id)
);

create table teens(
	id serial primary key,
	name varchar(255),
	gender boolean
);

insert into departments(name) values('first');
insert into departments(name) values('second');
insert into departments(name) values('third');
insert into departments(name) values('xxxxxx');

insert into employees(name, departments_id) values('jade', 1);
insert into employees(name, departments_id) values('Shrek', 1);
insert into employees(name, departments_id) values('Donkey', 1);
insert into employees(name, departments_id) values('Russel', 2);
insert into employees(name, departments_id) values('Sam', 2);
insert into employees(name, departments_id) values('Maria', 2);
insert into employees(name, departments_id) values('Liam', 2);
insert into employees(name, departments_id) values('Bill', 3);
insert into employees(name, departments_id) values('Snake', 3);

insert into teens(name, gender) values('Sasha', false);
insert into teens(name, gender) values('Alex', false);
insert into teens(name, gender) values('Mike', false);
insert into teens(name, gender) values('Vladimir', false);
insert into teens(name, gender) values('Sasha', true);
insert into teens(name, gender) values('Julia', true);
insert into teens(name, gender) values('Nadya', true);
