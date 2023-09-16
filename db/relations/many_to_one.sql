create table person(
	id serial primary key,
	nickname varchar(30)
);

create table post(
	id serial primary key,
	body text,
	person_id int references person(id)
);