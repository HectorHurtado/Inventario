update producto
set nombre = :nombre,
	fecha_abastecimiento = :fechaAbastecimiento,
	stock = :stock
where id = :id