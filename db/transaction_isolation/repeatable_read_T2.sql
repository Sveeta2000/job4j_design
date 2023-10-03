BEGIN TRANSACTION ISOLATION LEVEL REPEATABLE READ;

select * from games;

update games
set amount = amount + 1
where name = 'Dune';