create or replace function del_data(con integer)
returns void
language 'plpgsql'
as
$$
    begin
		delete from products
		where count <= con;
    end;
$$;

create or replace procedure del_data1(con integer)
language 'plpgsql'
as 
$$
    BEGIN
		delete from products
		where count <= con;
    END;
$$;

select del_data(15);

select * from products;

