package com.ceiba.movimiento.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.movimiento.comando.ComandoMovimiento;
import com.ceiba.movimiento.comando.fabrica.FabricaMovimiento;
import com.ceiba.movimiento.modelo.entidad.Movimiento;
import com.ceiba.movimiento.servicio.ServicioCrearMovimiento;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearMovimiento implements ManejadorComandoRespuesta<ComandoMovimiento, ComandoRespuesta<Long>> {

    private final FabricaMovimiento fabricaMovimiento;
    private final ServicioCrearMovimiento servicioCrearMovimiento;

    public ManejadorCrearMovimiento(FabricaMovimiento fabricaMovimiento, ServicioCrearMovimiento servicioCrearMovimiento) {
        this.fabricaMovimiento = fabricaMovimiento;
        this.servicioCrearMovimiento = servicioCrearMovimiento;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoMovimiento comandoMovimiento) {
        Movimiento movimiento = this.fabricaMovimiento.crear(comandoMovimiento);
        return new ComandoRespuesta<>(this.servicioCrearMovimiento.ejecutar(movimiento));
    }
}
