create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table producto(
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 fecha_creacion datetime null,
 precio_compra float not null,
 stock int not null,
 fecha_abastecimiento datetime null,
 primary key (id)
);

create table movimiento(
 id int(11) not null auto_increment,
 id_producto int not null,
 cantidad int not null,
 precio_venta float not null,
 fecha_venta datetime not null,
 primary key (id),
 foreign key(id_producto) references producto(id)
);