package com.ceiba.movement.puerto.dao;

import com.ceiba.movement.modelo.dto.DtoMovement;

import java.util.List;

public interface DaoMovement {

    /**
     * Permite listar movimientos
     * @return los movimientos
     */
    List<DtoMovement> listar();
}
