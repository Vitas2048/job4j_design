create table car_bodies(
	id serial primary key,
	name varchar(255)
);

create table car_engines(
	id serial primary key,
	name varchar(255)
);

create table car_transmissions(
	id serial primary key,
	name varchar(255)
);

create table cars(
	id serial primary key,
	name varchar(255),
	body_id int references car_bodies(id),
	engine_id int references car_engines(id),
	transmission_id int references car_transmissions(id)
);

insert into car_bodies(name) values('седан');
insert into car_bodies(name) values('хэтчбек');
insert into car_bodies(name) values('универсал');
insert into car_bodies(name) values('купе');
insert into car_bodies(name) values('лифтбек');

insert into car_engines(name) values('1.8 Т');
insert into car_engines(name) values('M57');
insert into car_engines(name) values('Duraterc HE');
insert into car_engines(name) values('2JZ');
insert into car_engines(name) values('VQ35DE');
insert into car_engines(name) values('VTEC');

insert into car_transmissions(name) values('automatic');
insert into car_transmissions(name) values('variator');
insert into car_transmissions(name) values('mechanic');
insert into car_transmissions(name) values('robot');

insert into cars(name, body_id, engine_id, transmission_id) values('Audi Q7', 1, 3, 1);
insert into cars(name, body_id, engine_id, transmission_id) values('Audi Q6', 2, 2, 1);
insert into cars(name, body_id, engine_id, transmission_id) values('Audi A5', 1, 1, 1);
insert into cars(name, body_id, engine_id, transmission_id) values('BMW X7', 3, 2, 1);
insert into cars(name, body_id, engine_id, transmission_id) values('BMW X6', 3, 2, 2);
insert into cars(name, body_id, engine_id, transmission_id) values('BMW X5', 1, 2, 2);
insert into cars(name, body_id, engine_id, transmission_id) values('Ford focus', 1, 3, 3);
insert into cars(name, body_id, engine_id, transmission_id) values('Ford fiesta', 2, 3, 1);
insert into cars(name, body_id, engine_id, transmission_id) values('Toyota corolla', 1, 4, 2);
insert into cars(name, body_id, engine_id, transmission_id) values('Toyota caldina', 3, 4, 1);
insert into cars(name, body_id, engine_id, transmission_id) values('Toyota mark 2', 1, 4, 3);
insert into cars(name, body_id, engine_id, transmission_id) values('Honda fit', 2, 6, 3);
insert into cars(name, body_id, engine_id, transmission_id) values('Honda accord', 1, 6, 1);
insert into cars(name, body_id, engine_id, transmission_id) values('Honda odyssey', 2, 6, 3);
insert into cars(name, body_id, engine_id) values('Honda X', 2, 6);
insert into cars(name, body_id, transmission_id) values('AUTOVAZ', 2, 3);
insert into cars(name, engine_id, transmission_id) values('Tesla', 2, 3);