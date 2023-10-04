select * from games;

insert into games(name, amount, price) values ('TAC', 10, 4990.00);

savepoint before_delete_sp;

delete from games
where price < 5000;

select * from games;

rollback to before_delete_sp;

select * from games;

savepoint before_update_sp;

update games
set price = price * 1.2
where price < 5000;

select * from games;

rollback to before_update_sp;

select * from games;