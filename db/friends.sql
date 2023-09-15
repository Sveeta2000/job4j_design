create table friends(
	id serial primary key,
	name varchar(200),
	phone text,
	birthday date
);
insert into friends(name, phone, birthday) values('Irina', '89123456789', '2000.10.04');
update friends set phone = '+79123456789';
delete from friends;