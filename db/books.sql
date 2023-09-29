create table students (
    id serial primary key,
    name varchar(50)
);

insert into students (name) values ('Иван Иванов');
insert into students (name) values ('Петр Петров');
insert into students (name) values ('Саша Петров');

create table authors (
    id serial primary key,
    name varchar(50)
);

insert into authors (name) values ('Александр Пушкин');
insert into authors (name) values ('Николай Гоголь');

create table books (
    id serial primary key,
    name varchar(200),
	amount int,
	price decimal(6, 2),
    author_id integer references authors(id)
);

insert into books (name, amount, price, author_id) values ('Евгений Онегин', 5, 450.00, 1);
insert into books (name, amount, price, author_id) values ('Капитанская дочка', 10, 650.10, 1);
insert into books (name, amount, price, author_id) values ('Дубровский', 4, 410.99, 1);
insert into books (name, amount, price, author_id) values ('Мертвые души', 8, 370.50, 2);
insert into books (name, amount, price, author_id) values ('Вий', 2, 350.90, 2);

create table orders (
    id serial primary key,
    active boolean default true,
    book_id integer references books(id),
    student_id integer references students(id)
);

insert into orders (book_id, student_id) values (1, 1);
insert into orders (book_id, student_id) values (3, 1);
insert into orders (book_id, student_id) values (5, 2);
insert into orders (book_id, student_id) values (4, 1);
insert into orders (book_id, student_id) values (2, 2);
insert into orders (book_id, student_id) values (2, 3);

/* if sum of order of a student is greater than 1000.00 give them 10% discount
*/
create view show_students_and_total_price_with_10percent_discount
    as select s.name as student, case
when sum(b.price) > 1000.00 then round(sum(b.price) * 0.9, 2)
when sum(b.price) < 1000.00 then sum(b.price)
end
as new_price
from students as s
join orders o on s.id = o.student_id
join books b on o.book_id = b.id
group by s.name
order by new_price desc;