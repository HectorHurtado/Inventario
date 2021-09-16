package com.ceiba.movimiento.testdatabuilder;

import com.ceiba.movimiento.comando.ComandoMovement;

import java.util.Date;

public class ComandoMovementTestDataBuilder {

    private Long id;
    private Long idProduct;
    private Integer amount;
    private Float salePrice;
    private Date saleDate;

    public ComandoMovementTestDataBuilder() {
        id = 1L;
        idProduct = 1L;
        amount = 1;
        salePrice = 10000F;
        saleDate = new Date();
    }

    public ComandoMovementTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoMovement build() {
        return new ComandoMovement(this.id,this.idProduct,this.amount,this.salePrice,this.saleDate);
    }
}
