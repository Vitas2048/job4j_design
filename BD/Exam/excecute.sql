select p.name, c.name
from person p join company c
on p.company_id = c.id and not c.id = 5;


select c.name,
count(p.company_id) persons
from company c
join person p
on c.id = p.company_id
GROUP by c.name
having count(p.company_id)=(
	select count(p.company_id)
	from person p 
	group by p.company_id
	order by count(p.company_id) desc
	limit 1);