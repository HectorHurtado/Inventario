package com.ceiba.movimiento.consulta;

import com.ceiba.ComandoRespuesta;
import com.ceiba.movimiento.puerto.dao.DaoMovimiento;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ManejadorObtenerGananciaMovimientos {

    private final DaoMovimiento daoMovimiento;

    public ManejadorObtenerGananciaMovimientos(DaoMovimiento daoMovimiento){
        this.daoMovimiento = daoMovimiento;
    }

    public ComandoRespuesta<Float> ejecutar(Date fecha) {
        return new ComandoRespuesta<>(this.daoMovimiento.obtenerGanancia(fecha));
    }
}
