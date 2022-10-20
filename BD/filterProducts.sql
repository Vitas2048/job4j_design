select p.name 
from product p 
join type t 
on p.type_id=t.id and t.name = 'сыр';

select p.name 
from product p
where p.name like '%мороженое%';

select p.name
from product p
where p.expired_date < CURRENT_DATE;

select p.name, p.price
from product p
where p.price = (select max(p.price) from product p);

select t.name, count(*)
from type t 
join product p
on p.type_id=t.id
group by t.name;

select p.name, t.name
from type t
join product p 
on p.type_id=t.id and t.name = 'молоко' or p.type_id = t.id and t.name = 'сыр';

select t.name
from type t 
join product p 
on p.type_id = t.id
group by t.name
having count(t.name) < 10;