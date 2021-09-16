package com.ceiba.movimiento.puerto.repositorio;

import com.ceiba.movimiento.modelo.entidad.Movimiento;

public interface RepositorioMovimiento {
    /**
     * Permite crear un movimiento
     * @param movimiento
     * @return el id generado
     */
    Long crear(Movimiento movimiento);

}
