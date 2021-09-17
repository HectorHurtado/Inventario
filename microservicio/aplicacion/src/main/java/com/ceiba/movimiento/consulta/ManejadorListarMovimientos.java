package com.ceiba.movimiento.consulta;

import com.ceiba.movimiento.modelo.dto.DtoMovimiento;
import com.ceiba.movimiento.puerto.dao.DaoMovimiento;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarMovimientos {

    private final DaoMovimiento daoMovimiento;

    public ManejadorListarMovimientos(DaoMovimiento daoMovimiento){
        this.daoMovimiento = daoMovimiento;
    }

    public List<DtoMovimiento> ejecutar() {return this.daoMovimiento.listar(); }
}
