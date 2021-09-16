package com.ceiba.movimiento.puerto.dao;

import com.ceiba.movimiento.modelo.dto.DtoMovimiento;

import java.util.Date;
import java.util.List;

public interface DaoMovimiento {

    /**
     * Permite listar movimientos
     * @return los movimientos
     */
    List<DtoMovimiento> listar();

    /**
     * Permite obtener ganancias a partir de una fecha
     * @return valor ganancias
     */
    Float obtenerGanancia(Date fecha);
}
