create table person(
	id serial primary key,
	nickname varchar(30)
);

create table telegram(
	id serial primary key,
	username varchar(20),
	person_id int references person(id) unique
);