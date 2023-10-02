create table products (
    id serial primary key,
    name varchar(50),
    producer varchar(50),
    count integer default 0,
    price integer
);

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

create or replace function tax_before()
returns trigger as
$$
    BEGIN
        new.price = new.price + new.price * 0.1;
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';

create trigger before_tax_trigger
    before insert
    on products
    for each row
    execute procedure tax_before();

create table history_of_price (
    id serial primary key,
    name varchar(50),
    price integer,
    date timestamp
);

create trigger record_products
    after insert
    on products
    for each row
    execute procedure write_to_record();

create or replace function write_to_record()
returns trigger as
$$
    BEGIN
        insert into history_of_price (name, price, date)
        values (new.name, new.price, current_date);
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';

insert into products (name, producer, count, price) VALUES ('product_1', 'producer_1', 3, 50);
insert into products (name, producer, count, price) VALUES ('product_2', 'producer_2', 8, 100);

select * from history_of_price;
select * from products;

insert into products (name, producer, count, price) VALUES ('product_3', 'producer_3', 0, 100);

create or replace function f_delete_products()
returns void
language 'plpgsql'
as
$$
    begin
        delete from products where count <= 0;
    end;
$$;

select f_delete_products();

create or replace procedure delete_by_id(d_id integer)
language 'plpgsql'
as $$
    BEGIN
        delete from products where id = d_id;
    END;
$$;

call delete_by_id(11);