create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);
insert into fauna(name, avg_age, discovery_date) values ('fly', 8, '1818/09/09');
insert into fauna(name, avg_age, discovery_date) values ('turtle', 36500, '1949/09/09');
insert into fauna(name, avg_age, discovery_date) values ('cat', 10000, null);
insert into fauna(name, avg_age, discovery_date) values ('goldfish', 1766, '2000/09/09');
select * from fauna where name like '%fish%';
select * from fauna where avg_age between 10000 and 21000;
select * from fauna where discovery_date is null;
select * from fauna where discovery_date < '1950.01.01';