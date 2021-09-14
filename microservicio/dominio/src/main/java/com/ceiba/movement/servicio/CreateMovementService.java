package com.ceiba.movement.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.movement.modelo.entidad.Movement;
import com.ceiba.movement.puerto.repositorio.RepositorioMovement;
import com.ceiba.product.modelo.entidad.Product;
import com.ceiba.product.puerto.repositorio.RepositorioProduct;


public class CreateMovementService {

    private final RepositorioMovement repositorioMovement;

    public CreateMovementService(RepositorioMovement repositorioMovement) {
        this.repositorioMovement = repositorioMovement;
    }

    public Long ejecutar(Movement movement) {
        return this.repositorioMovement.crear(movement);
    }

}
