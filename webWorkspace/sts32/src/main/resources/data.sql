drop table if exists emp cascade ;
drop table if exists auths cascade;
create table emp(
	num int primary key auto_increment,
	id varchar(16),
	email varchar(16),
	pw varchar(64)
);
create table auths (
	id varchar(16) not null,
	auth varchar(10) not null,
	constraint fk_auths foreign key(id) references emp(id)
);
insert into emp (id,email,pw) values ('user1','user1@localhost','$2a$10$PEe5MgPMZ8sIBUlqrQ06sunwxMM0Xu4fr0ppJIT1JjRp0Vg.eGDUS');
insert into emp (id,email,pw) values ('user2','user2@localhost','$2a$10$fGdgIQnO57/uHGySeN8z3.Rc8fUI91ly2ZqS4nhTYUgvdJZ/I7Z.i');
insert into emp (id,email,pw) values ('user3','user3@localhost','$2a$10$fGdgIQnO57/uHGySeN8z3.Rc8fUI91ly2ZqS4nhTYUgvdJZ/I7Z.i');

insert into auths(id,auth) values ('user1','USER');
insert into auths(id,auth) values ('user1','ADMIN');
insert into auths(id,auth) values ('user2','USER');
insert into auths(id,auth) values ('user3','MEMBER');
commit;
