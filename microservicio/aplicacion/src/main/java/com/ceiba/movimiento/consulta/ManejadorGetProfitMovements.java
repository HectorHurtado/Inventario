package com.ceiba.movimiento.consulta;

import com.ceiba.movimiento.puerto.dao.DaoMovimiento;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ManejadorGetProfitMovements {

    private final DaoMovimiento daoMovimiento;

    public ManejadorGetProfitMovements(DaoMovimiento daoMovimiento){
        this.daoMovimiento = daoMovimiento;
    }

    public Float ejecutar(Date date) {return this.daoMovimiento.obtenerGanancia(date); }
}
