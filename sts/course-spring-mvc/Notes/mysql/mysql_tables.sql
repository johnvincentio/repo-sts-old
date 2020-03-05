
set FOREIGN_KEY_CHECKS = 0;

drop table if exists category;
drop table if exists customer;
drop table if exists product;
drop table if exists purchase;
drop table if exists purchaseitem;

create table category (
	id bigint not null auto_increment, 
	description varchar(700) not null, 
	name varchar(100) not null, 
	version integer, 
	primary key (id)
);

create table customer (
	id bigint not null auto_increment,
	email varchar(255) not null, 
	first_name varchar(255), 
	last_name varchar(255), 
	name varchar(100) not null, 
	password varchar(255) not null, 
	phone varchar(20), 
	version integer, 
	primary key (id)
);

create table product (
	id bigint not null auto_increment,
	description varchar(700) not null, 
	featured boolean, 
	image_path varchar(700), 
	price double not null, 
	product_name varchar(100) not null, 
	version integer, 
	category bigint, 
	primary key (id)
);

create table purchase (
	id bigint not null auto_increment,
	completed boolean, 
	order_date timestamp not null, 
	version integer, 
	ordered_by bigint, 
	primary key (id)
);

create table purchaseitem (
	id bigint not null auto_increment,
	order_date timestamp not null, 
	quantity integer not null, 
	version integer, 
	product bigint, 
	purchase bigint, 
	primary key (id)
);

alter table product add constraint FK_19w9vgbbv4qs6m0tkucs9ad0c foreign key (category) references category(id);
alter table purchase add constraint FK_rf4yj0t3bq1f42596a7v71l1c foreign key (ordered_by) references customer(id);
alter table purchaseitem add constraint FK_5ta318a5vltt62onwwyv79rks foreign key (product) references product(id);
alter table purchaseitem add constraint FK_1y3h3hbsrr3fbpuqbfj6ogoi2 foreign key (purchase) references purchase(id);

set FOREIGN_KEY_CHECKS = 1;
