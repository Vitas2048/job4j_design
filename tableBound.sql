create table pets(
    id serial primary key,
    nickname varchar(255)
    owners_id int references owners(id)
);
create table owners(
    id serial primary key,
    firstname varchar(255),
);
insert into pets(nickname, owners_id) values ('Reks', 1);
insert into pets(nickname, owners_id) values ('Reks', 2);
insert into owners(firstname) values ('Alex');
insert into owners(firstname) values ('Maria');

select * from pets;
select * from owners where id in (select owner_id from pet);


create table cellphone(
    id serial primary key,
    company varchar(255)
);
create table person(
    id serial primary key,
    cellphone_id int references cellphone(id) unique
);
insert into cellphone(company) values ('Samsung');
insert into person(cellphone_id) values (1);
select * from person;
select * from cellphone where id in (select cellphone_id from person);

create table developers(
    id serial primary key,
    firstname varchar(255)
);
create table projects(
    id serial primary key,
    task varchar(255)
);
create table developers_projects(
    id serial primary key,
    dev_id int references developers(id),
    p_id int references projects(id)
);
insert into developers(firstname) values ('Mike');
insert into developers(firstname) values ('Raychel');
insert into projects(task) values ('readalot');
insert into projects(task) values ('countalot');
insert into developers_projects (dev_id, p_id) values (1, 1);
insert into developers_projects (dev_id, p_id) values (1, 2);
insert into developers_projects (dev_id, p_id) values (2, 1);
select * from developers_projects;