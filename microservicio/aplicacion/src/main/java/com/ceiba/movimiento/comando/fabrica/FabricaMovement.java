package com.ceiba.movimiento.comando.fabrica;

import com.ceiba.movimiento.comando.ComandoMovement;
import com.ceiba.movimiento.modelo.entidad.Movimiento;
import org.springframework.stereotype.Component;

@Component
public class FabricaMovement {

    public Movimiento crear(ComandoMovement comandoMovement) {
        return new Movimiento(
                comandoMovement.getId(),
                comandoMovement.getIdProduct(),
                comandoMovement.getAmount(),
                comandoMovement.getSalePrice(),
                comandoMovement.getSaleDate()
        );
    }

}
