create table customer(
	id serial primary key,
	name varchar(30)
);

create table product(
	id serial primary key,
	name varchar(30),
	amount int
);

create table customer_product(
	id serial primary key,
	customer_id int references customer(id),
	product_id int references product(id)
);