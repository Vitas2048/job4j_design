create or replace function addnewt()
    returns trigger as
$$
    BEGIN
		insert into history_of_price(name, price, date) 
		values (new.name, new.price, CURRENT_DATE);
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger addtonewt_trigger
    after insert
	on products
	for each row
    execute procedure addnewt();

insert into products (name, producer, count, price) VALUES ('product_4', 'producer_3', 3, 100);

select * from history_of_price;