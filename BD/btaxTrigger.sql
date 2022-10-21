create or replace function btax()
    returns trigger as
$$
    BEGIN
        update products
        set price = price + price * 0.2
        where id = new.id;
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

select * from products;