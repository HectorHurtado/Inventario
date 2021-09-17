insert into usuario(nombre,clave,fecha_creacion) values('test','1234',now());
insert into producto (nombre,fecha_creacion,precio_compra,stock) values ('Comida', now(), 8000, 2);
insert into movimiento (id_producto, cantidad, precio_venta, fecha_venta) values (1, 2, 10000, now());