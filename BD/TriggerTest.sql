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



create or replace function btax()
    returns trigger as
$$
    BEGIN
		new.price= new.price * 1.2;
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger btax_trigger
    before insert
	on products
	for each row
    execute procedure btax();

insert into products (name, producer, count, price) VALUES ('product_3', 'producer_2', 3, 100);



create or replace function tax()
    returns trigger as
$$
    BEGIN
        update products
        set price = price + price * 0.2
        where id = (select id from inserted);
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger tax_trigger
    after insert on products
    referencing new table as inserted
    for each statement
    execute procedure tax();

insert into products (name, producer, count, price) VALUES ('product_2', 'producer_1', 3, 80);

select * from products;