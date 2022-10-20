create table devices(
id serial primary key,
name varchar(255),
price float
);

create table people(
id serial primary key,
name varchar(255)
);

create table devices_people(
id serial primary key,
device_id int references devices(id),
people_id int references people(id)
);

insert into devices(name, price) values('cellphone', 3000);
insert into devices(name, price) values('laptop', 10000);
insert into devices (name, price) values('TV', 4000);
insert into devices (name, price) values('PC', 15000);

insert into people(name) values ('Maria');
insert into people(name) values ('Mike');
insert into people(name) values ('Sasha');
insert into people(name) values ('Ludvig');

insert into devices_people(device_id, people_id) values(1, 1);
insert into devices_people(device_id, people_id) values(2, 1);
insert into devices_people(device_id, people_id) values(3, 1);
insert into devices_people(device_id, people_id) values(1, 2);
insert into devices_people(device_id, people_id) values(3, 2);
insert into devices_people(device_id, people_id) values(4, 2);
insert into devices_people(device_id, people_id) values(1, 3);
insert into devices_people(device_id, people_id) values(1, 4);
insert into devices_people(device_id, people_id) values(2, 4);
insert into devices_people(device_id, people_id) values(3, 4);
insert into devices_people(device_id, people_id) values(4, 4);

select avg(price) from devices;
select p.name, avg(d.price) from devices_people dp 
join people p 
on dp.people_id = p.id 
join devices d 
on dp.device_id = d.id 
group by p.name;

select p.name, avg(d.price) from devices_people dp 
join people p 
on dp.people_id = p.id 
join devices d 
on dp.device_id = d.id 
group by p.name having avg(d.price) > 5000;