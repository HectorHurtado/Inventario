package com.ceiba.movimiento.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.movimiento.comando.ComandoMovement;
import com.ceiba.movimiento.comando.fabrica.FabricaMovement;
import com.ceiba.movimiento.modelo.entidad.Movimiento;
import com.ceiba.movimiento.servicio.ServicioCrearMovimiento;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearMovement implements ManejadorComandoRespuesta<ComandoMovement, ComandoRespuesta<Long>> {

    private final FabricaMovement fabricaMovement;
    private final ServicioCrearMovimiento servicioCrearMovimiento;

    public ManejadorCrearMovement(FabricaMovement fabricaMovement, ServicioCrearMovimiento servicioCrearMovimiento) {
        this.fabricaMovement = fabricaMovement;
        this.servicioCrearMovimiento = servicioCrearMovimiento;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoMovement comandoMovement) {
        Movimiento movement = this.fabricaMovement.crear(comandoMovement);
        return new ComandoRespuesta<>(this.servicioCrearMovimiento.ejecutar(movement));
    }
}
