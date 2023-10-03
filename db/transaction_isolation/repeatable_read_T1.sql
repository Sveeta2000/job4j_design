BEGIN TRANSACTION ISOLATION LEVEL REPEATABLE READ;

select * from games;

insert into games(name, amount, price) values ('D&D', 5, 8990.00);

delete from games
where price < 3000;

update games
set amount = amount + 1
where name = 'Dune';