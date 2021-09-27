select sum((m.precio_venta - p.precio_compra) * m.cantidad)
from movimiento m, producto p
where m.id_producto = p.id and m.fecha_venta between :fechaInicial and :fechaFinal