create database bookstore;
use bookstore;

create table log_user
	(user_id int not null auto_increment,                 /* int ——> varchar */
	username varchar(50) not null unique,
	password varchar(25) not null,
	user_nickname varchar(50),
	user_truename varchar(50),
	user_gender int,
	user_phone int,
	user_email varchar(50),
	balance int,
	pay_pwd int,
	create_time date,                 /* 一个表只能一个timestamp,所以这里用了date*/
	last_ip varchar(50),
	last_time timestamp,
	status int, 

	primary key(user_id)
);

insert into log_user (username, password) values ("luoyucheng", "123456");

