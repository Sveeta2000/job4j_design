create table type (
	id serial primary key,
	name text
);

create table product (
    id serial primary key,
	name text,
	type_id int references type(id),
	expiry_date date,
	price int
);

insert into type (name) values ('СЫР'), ('МОЛОКО'), ('ВЫПЕЧКА'), ('ДЕСЕРТ');
insert into product (name, type_id, expiry_date, price) values ('Сыр моцарелла', 1, '22.09.2023', 400);
insert into product (name, type_id, expiry_date, price) values ('Сыр плавленный', 1, '29.09.2023', 100);

insert into product (name, type_id, expiry_date, price) values ('Молоко 3%', 2, '29.10.2023', 150);
insert into product (name, type_id, expiry_date, price) values ('Молоко 0.05%', 2, '09.11.2023', 160);
insert into product (name, type_id, expiry_date, price) values ('Молоко миндальное', 2, '31.12.2023', 200);
insert into product (name, type_id, expiry_date, price) values ('Молоко кокосовое', 2, '31.12.2023', 400);
insert into product (name, type_id, expiry_date, price) values ('Молоко 2%', 2, '28.10.2023', 140);
insert into product (name, type_id, expiry_date, price) values ('Молоко банановое', 2, '09.11.2023', 260);
insert into product (name, type_id, expiry_date, price) values ('Молоко соевое', 2, '31.12.2023', 220);
insert into product (name, type_id, expiry_date, price) values ('Молоко безлактозное', 2, '31.12.2023', 180);
insert into product (name, type_id, expiry_date, price) values ('Молоко 500мл', 2, '31.12.2023', 80);
insert into product (name, type_id, expiry_date, price) values ('Молоко клубничное', 2, '31.12.2023', 170);


insert into product (name, type_id, expiry_date, price) values ('Хлеб белый', 3, '29.09.2023', 50);
insert into product (name, type_id, expiry_date, price) values ('Хлеб черный', 3, '26.09.2023', 60);
insert into product (name, type_id, expiry_date, price) values ('Булочка с корицей', 3, '30.09.2023', 50);

insert into product (name, type_id, expiry_date, price) values ('Мороженое пломбир', 4, '30.11.2023', 110);

select product.name as product_name, type.name as type_name, expiry_date, price
from product inner join type on type.id = product.type_id
where type.name = 'СЫР';

select name as product_name, expiry_date, price
from product
where name like '%Мороженое%';

select name, expiry_date, price
from product
where current_date > expiry_date;

select name, expiry_date, price
from product
where price in (
	select price
    from product
    order by price desc
    limit 1
    );

select type.name as type_name, count(product.name) as amount
from product inner join type on type.id = product.type_id
group by type.name
order by amount desc;

select product.name as product_name, type.name as type_name, expiry_date, price
from product inner join type on type.id = product.type_id
where type.name in ('СЫР','МОЛОКО');

select type.name as type_name
from product inner join type on type.id = product.type_id
group by type.name
having count(product.name) < 10;

select product.name as product_name, type.name as type_name
from product inner join type on type.id = product.type_id;