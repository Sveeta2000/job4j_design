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

insert into type (name) values ('���'), ('������'), ('�������'), ('������');
insert into product (name, type_id, expiry_date, price) values ('��� ���������', 1, '22.09.2023', 400);
insert into product (name, type_id, expiry_date, price) values ('��� ����������', 1, '29.09.2023', 100);

insert into product (name, type_id, expiry_date, price) values ('������ 3%', 2, '29.10.2023', 150);
insert into product (name, type_id, expiry_date, price) values ('������ 0.05%', 2, '09.11.2023', 160);
insert into product (name, type_id, expiry_date, price) values ('������ ����������', 2, '31.12.2023', 200);
insert into product (name, type_id, expiry_date, price) values ('������ ���������', 2, '31.12.2023', 400);
insert into product (name, type_id, expiry_date, price) values ('������ 2%', 2, '28.10.2023', 140);
insert into product (name, type_id, expiry_date, price) values ('������ ���������', 2, '09.11.2023', 260);
insert into product (name, type_id, expiry_date, price) values ('������ ������', 2, '31.12.2023', 220);
insert into product (name, type_id, expiry_date, price) values ('������ ������������', 2, '31.12.2023', 180);
insert into product (name, type_id, expiry_date, price) values ('������ 500��', 2, '31.12.2023', 80);
insert into product (name, type_id, expiry_date, price) values ('������ ����������', 2, '31.12.2023', 170);


insert into product (name, type_id, expiry_date, price) values ('���� �����', 3, '29.09.2023', 50);
insert into product (name, type_id, expiry_date, price) values ('���� ������', 3, '26.09.2023', 60);
insert into product (name, type_id, expiry_date, price) values ('������� � �������', 3, '30.09.2023', 50);

insert into product (name, type_id, expiry_date, price) values ('��������� �������', 4, '30.11.2023', 110);

select product.name as product_name, type.name as type_name, expiry_date, price
from product inner join type on type.id = product.type_id
where type.name = '���';

select name as product_name, expiry_date, price
from product
where name like '%���������%';

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
where type.name in ('���','������');

select type.name as type_name
from product inner join type on type.id = product.type_id
group by type.name
having count(product.name) < 10;

select product.name as product_name, type.name as type_name
from product inner join type on type.id = product.type_id;