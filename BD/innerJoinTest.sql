create table owner(
	id serial primary key,
	name varchar(255),
	apparts boolean
);

create table pet(
	id serial primary key,
	breed varchar(255),
	name varchar(255),
	owner_id int references owner(id)
);


insert into owner(name, apparts) values ('Natasha', true);
insert into owner (name, apparts) values ('Pete', false);
insert into owner(name, apparts) values('Mike', true);

insert into pet(breed, name, owner_id) values('dog', 'Reks', 1);
insert into pet(breed, name, owner_id) values('cat', 'Sam', 2);

select p.breed, o.name from pet p join owner o on p.owner_id = o.id; 
select p.name, o.name from pet p join owner o on p.owner_id = o.id; 
select p.breed, o.apparts from pet p join owner o on p.owner_id = o.id; 