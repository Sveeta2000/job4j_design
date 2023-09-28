create table car_bodies (
	id serial primary key,
	name text
);

create table car_engines (
	id serial primary key,
	name text

);

create table car_transmissions (
	id serial primary key,
	name text

);

create table cars (
	id serial primary key,
	name text,
	body_id int references car_bodies(id),
	engine_id int references car_engines(id),
	transmission_id int references car_transmissions(id)
);

insert into car_bodies(name) values ('Sports car'), ('Sedan'), ('Pickup truck');
insert into car_engines(name) values ('Hybrid'), ('ESS'), ('DSL');
insert into car_transmissions(name) values ('AT'), ('MT'), ('AM');
insert into cars(name, body_id, engine_id, transmission_id) values ('My car', 2, 1, 1), ('Dad car', 3, 1, 2);
insert into cars(name, body_id) values ('Nonames car', 3);

select cars.id as id, cars.name as car_name, car_bodies.name as body_name,
car_engines.name as engine_name, car_transmissions.name as transmission_name
from cars left join car_bodies on cars.body_id = car_bodies.id
left join car_engines on cars.engine_id = car_engines.id
left join car_transmissions on cars.transmission_id = car_transmissions.id;

select car_bodies.name as body_name
from car_bodies left join cars on cars.body_id = car_bodies.id
where cars.name is null;

select car_engines.name as engine_name
from car_engines left join cars on cars.engine_id = car_engines.id
where cars.name is null;

select car_transmissions.name as transmission_name
from car_transmissions left join cars on cars.transmission_id = car_transmissions.id
where cars.name is null;