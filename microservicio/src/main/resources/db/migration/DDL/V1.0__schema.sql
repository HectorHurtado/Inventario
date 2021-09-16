create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table product(
 id int(11) not null auto_increment,
 name varchar(100) not null,
 create_date datetime null,
 buy_price float not null,
 stock int not null,
 supplying_date datetime null,
 primary key (id)
);

create table movement(
 id int(11) not null auto_increment,
 id_product int not null,
 amount int not null,
 sale_price float not null,
 sale_date datetime not null,
 primary key (id),
 foreign key(id_product) references product(id)
);