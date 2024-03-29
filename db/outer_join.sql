create table departments (
	id serial primary key,
	name text
);

create table employees (
	id serial primary key,
	name text,
	department_id int references departments(id)
);

insert into departments(name) values ('Development'), ('Sales'), ('Promo');
insert into employees(name, department_id) values ('Jim', 1), ('Gary', 1), ('Jo', 2);

select d.name as department_name, e.name as emplyee_name
from departments d
left join employees e on d.id = e.department_id;

select d.name as department_name, e.name as emplyee_name
from employees e
right join departments d on d.id = e.department_id;

select * from departments d
full join employees e on d.id = e.department_id;

select d.name as department_name, e.name as emplyee_name
from departments d
cross join employees e;

create table teen (
	id serial primary key,
	name text,
	gender varchar(1)
);

insert into teen(name, gender) values ('Jim', 'M'), ('Gary', 'M'), ('Jo', 'F'), ('Mary', 'F');

select t1.name as man, t2.name as woman
from teen t1
cross join teen t2
where t1.gender > t2.gender;