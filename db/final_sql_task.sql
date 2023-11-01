CREATE TABLE company
(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
    id integer NOT NULL,
    name character varying,
    company_id integer references company(id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

insert into company (id, name) values (1, 'A'), (2, 'B'), (3, 'C'), (4, 'D'), (5, 'E');

insert into person (id, name, company_id) VALUES (1, 'Ann', 3), (2, 'Ben', 3), (3, 'Cat', 5), (4, 'Dan', 5);
insert into person (id, name, company_id) VALUES (5, 'Eva', 1), (6, 'Finn', 1), (7, 'George', 1), (8, 'Hue', 1);
insert into person (id, name, company_id) VALUES (9, 'Ivy', 3), (10, 'Jack', 3);

select person.name, company.name
from person inner join company on person.company_id = company.id
where company.id <> 5
order by person.name;

select company.name, count(person.name) as Количество
from person inner join company on person.company_id = company.id
group by company.name
having count(person.name) = (select count(name)
					 from person
					 group by company_id
					 order by count(name) desc
					 limit 1
					 )
order by company.name;