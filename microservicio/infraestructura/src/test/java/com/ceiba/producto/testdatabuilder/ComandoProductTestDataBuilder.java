package com.ceiba.producto.testdatabuilder;

import com.ceiba.producto.comando.ComandoProduct;

import java.util.Date;

public class ComandoProductTestDataBuilder {

    private static final String PRODUCT_NAME = "Comida";

    private Long id = 1L;
    private String name;
    private Date createDate;
    private Float buyPrice;
    private Integer stock;
    private Date supplyingDate;

    public ComandoProductTestDataBuilder() {

        this.name = PRODUCT_NAME;
        this.createDate = new Date();
        this.buyPrice = 8000F;
        this.stock = 10;
        this.supplyingDate = null;
    }

    public ComandoProductTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoProduct build() {
        return new ComandoProduct(this.id,this.name, this.createDate,this.buyPrice,this.stock,this.supplyingDate);
    }
}
