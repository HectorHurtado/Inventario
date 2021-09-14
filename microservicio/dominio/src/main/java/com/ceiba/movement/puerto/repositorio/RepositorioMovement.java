package com.ceiba.movement.puerto.repositorio;

import com.ceiba.movement.modelo.entidad.Movement;

public interface RepositorioMovement {
    /**
     * Permite crear un movimiento
     * @param movement
     * @return el id generado
     */
    Long crear(Movement movement);

}
