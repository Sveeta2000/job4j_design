create table task(
    id serial primary key,
    description text,
    priority int
);

create table employee(
    id serial primary key,
    name varchar(255),
    task_id int references task(id)
);

insert into task(description, priority) values('sales', 3);
insert into task(description, priority) values('development', 2);
insert into task(description, priority) values('testing', 1);

insert into employee(name, task_id) values('Jack', 2);
insert into employee(name, task_id) values('Sarah', 1);
insert into employee(name, task_id) values('Thomas', 3);
insert into employee(name, task_id) values ('Sveta', 2);
insert into employee(name) values ('George');

select emp.name, tk.description, tk.priority
from employee as emp join task as tk on emp.task_id = tk.id
order by tk.priority;

select emp.name as Сотрудник, tk.description as Описание_задачи, tk.priority as Приоритет
from employee as emp join task as tk on emp.task_id = tk.id
order by emp.name;

select emp.name Сотрудник, tk.description as "Описание задачи", tk.priority Приоритет
from employee emp join task tk on emp.task_id = tk.id
order by tk.description;