create table pet(
	id serial primary key,
	breed varchar(255),
	name varchar(255)
);
create table owner(
	id serial primary key,
	name varchar(255),
	pet_id int references pet(id),
	apparts boolean
);

insert into pet(breed, name) values('dog', 'Reks');
insert into pet(breed, name) values('cat', 'Sam');

insert into owner(name, pet_id, apparts) values ('Natasha', 1, true);
insert into owner (name, pet_id, apparts) values ('Pete', 2, false);
insert into owner(name, pet_id, apparts) values('Mike', null, true);

select p.breed, o.name from pet p join owner o on o.pet_id = p.id; 
select p.name, o.name from pet p join owner o on o.pet_id = p.id; 
select p.breed, o.apparts from pet p join owner o on o.pet_id = p.id; 