select p.name, c.name
from person p join company c
on p.company_id = c.id and not c.id = 5;


select c.name, max(v.count)
from
(select c.name, count(*)
from
(select p.company_id, c.id
from company c join person p
on p.company_id = c.id) v join company c
on v.company_id = c.id
group by c.name) v join company c
on c.name = v.name
where v.count = (
	select max(v.count) 
		from (
	select c.name, count(*)
			from
				(select p.company_id, c.id
					from company c join person p
					on p.company_id = c.id) v join company c
					on v.company_id = c.id
					group by c.name) v)
group by c.name;