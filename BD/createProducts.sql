create table type(
	id serial primary key,
	name varchar(255)
);

create table product(
	id serial primary key,
	name varchar(255),
	type_id int references type(id),
	expired_date date,
	price int
);

insert into type(name) values('сыр');
insert into type(name) values('молоко');
insert into type(name) values('мясо');
insert into type(name) values('напитки');
insert into type(name) values('хлебобулочное изделие');

insert into product(name, type_id, expired_date, price) values('сыр плавленный', 1, '2022-11-20', 90);
insert into product(name, type_id, expired_date, price) values('сыр пармезан', 1, '2023-11-20', 200);
insert into product(name, type_id, expired_date, price) values('сыр копченный', 1, '2022-10-20', 50);
insert into product(name, type_id, expired_date, price) values('Молоко домашнее', 2, '2022-10-29', 60);
insert into product(name, type_id, expired_date, price) values('Молоко сгущенное', 2, '2022-10-29', 80);
insert into product(name, type_id, expired_date, price) values('Сметана', 2, '2022-11-05', 70);
insert into product(name, type_id, expired_date, price) values('Филе куринное', 3, '2022-11-05', 300);
insert into product(name, type_id, expired_date, price) values('Поджарка свинная', 3, '2022-11-02', 350);
insert into product(name, type_id, expired_date, price) values('шашлык по домашнему', 3, '2022-11-10', 300);
insert into product(name, type_id, expired_date, price) values('мороженое мясо', 3, '2022-12-10', 250);
insert into product(name, type_id, expired_date, price) values('Сок в ассортименте', 4, '2023-10-20', 100);
insert into product(name, type_id, expired_date, price) values('Лимонад', 4, '2023-10-20', 50);
insert into product(name, type_id, expired_date, price) values('Тархун', 4, '2021-09-05', 60);
insert into product(name, type_id, expired_date, price) values('Хлеб 1 категории', 5, '2022-10-25', 30);
insert into product(name, type_id, expired_date, price) values('Баранки', 5, '2022-12-05', 90);
insert into product(name, type_id, expired_date, price) values('Сухари с изюмом', 5, '2022-12-05', 80);

