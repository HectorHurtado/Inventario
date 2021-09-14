package com.ceiba.movement.servicio.testdatabuilder;

import com.ceiba.movement.modelo.entidad.Movement;
import com.ceiba.usuario.modelo.entidad.Usuario;

import java.time.LocalDateTime;

public class MovementTestDataBuilder {

    private Long id;
    private Long idProduct;
    private Integer amount;
    private Float salePrice;

    public MovementTestDataBuilder() {
        id = new Long(1);
        idProduct = new Long(1);
        amount = 1;
        salePrice = new Float(10000);
    }


    public MovementTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public Movement build() {
        return new Movement(id,idProduct, amount,salePrice);
    }
}
