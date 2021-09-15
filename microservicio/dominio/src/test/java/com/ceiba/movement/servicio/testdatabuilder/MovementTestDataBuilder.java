package com.ceiba.movement.servicio.testdatabuilder;

import com.ceiba.movement.modelo.entidad.Movement;
import com.ceiba.usuario.modelo.entidad.Usuario;

import java.time.LocalDateTime;
import java.util.Date;

public class MovementTestDataBuilder {

    private Long id;
    private Long idProduct;
    private Integer amount;
    private Float salePrice;
    private Date saleDate;

    public MovementTestDataBuilder() {
        id = 1L;
        idProduct = 1L;
        amount = 1;
        salePrice = 10000F;
        saleDate = new Date();
    }


    public MovementTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public MovementTestDataBuilder conSaleDate(Date saleDate) {
        this.saleDate = saleDate;
        return this;
    }

    public Movement build() {
        return new Movement(id,idProduct, amount,salePrice,saleDate);
    }
}
