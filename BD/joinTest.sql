select * from departments d 
left join employees e 
on d.id=e.departments_id;

select * from departments d 
right join employees e 
on d.id=e.departments_id;

select * from departments d 
full join employees e 
on d.id=e.departments_id;

select * from departments d 
cross join employees e ;

select * from departments d
left join employees e 
on d.id=e.departments_id
where e.departments_id is null;

select * from departments d 
left join employees e 
on d.id=e.departments_id 
where e.departments_id is not null;

select * from departments d 
right join employees e 
on d.id=e.departments_id;

select t1.name, t2.name 
from teens t1 
cross join teens t2
where t1.gender != t2.gender; 