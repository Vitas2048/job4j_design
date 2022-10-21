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