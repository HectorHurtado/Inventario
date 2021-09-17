package com.ceiba.movimiento.comando.fabrica;

import com.ceiba.movimiento.comando.ComandoMovimiento;
import com.ceiba.movimiento.modelo.entidad.Movimiento;
import org.springframework.stereotype.Component;

@Component
public class FabricaMovimiento {

    public Movimiento crear(ComandoMovimiento comandoMovimiento) {
        return new Movimiento(
                comandoMovimiento.getId(),
                comandoMovimiento.getIdProducto(),
                comandoMovimiento.getCantidad(),
                comandoMovimiento.getPrecioVenta(),
                comandoMovimiento.getFechaVenta()
        );
    }

}
