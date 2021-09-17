select sum(m.precio_venta - p.precio_compra)
from movimiento m, producto p
where m.fecha_venta = :fecha