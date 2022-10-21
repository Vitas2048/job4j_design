
create view show_engines_where_morethan3_bodies_andmorethan3_transmisiions
as select e.name engine, count(b.name) bodies, count(t.name) transmissions
from cars c
left join car_transmissions t 
	on c.transmission_id = t.id 
left join car_bodies b 
	on c.body_id = b.id
left join car_engines e 
	on c.engine_id = e.id
	group by (e.name)
	having count(b.name) > 3 
	and count(t.name) > 2;
	
select * from show_engines_where_morethan3_bodies_andmorethan3_transmisiions;