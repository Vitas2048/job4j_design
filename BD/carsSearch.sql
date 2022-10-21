select c.name, b.name, e.name, t.name from cars c 
left join car_bodies b 
on c.body_id=b.id 
left join car_engines e
on c.engine_id = e.id
left join car_transmissions t
on c.transmission_id = t.id;

select b.name from car_bodies b 
left join cars c 
on b.id = c.body_id
where c.body_id is null;

select e.name from car_engines e 
left join cars c 
on e.id = c.engine_id
where c.engine_id is null; 

select t.name from car_transmissions t 
left join cars c 
on t.id = c.transmission_id
where c.transmission_id is null; 