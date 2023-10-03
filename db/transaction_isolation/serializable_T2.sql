BEGIN TRANSACTION ISOLATION LEVEL SERIALIZABLE;

select sum(amount) from games;

update games
set amount = amount - 2
where name = 'TAC';