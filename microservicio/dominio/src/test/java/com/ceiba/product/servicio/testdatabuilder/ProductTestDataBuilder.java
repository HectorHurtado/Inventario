package com.ceiba.product.servicio.testdatabuilder;

import com.ceiba.product.modelo.entidad.Product;
import com.ceiba.usuario.modelo.entidad.Usuario;

import java.time.LocalDateTime;
import java.util.Date;

public class ProductTestDataBuilder {

    private Long id;
    private String name;
    private Date date;
    private Float buyPrice;
    private Integer stock;
    private Date supplyingDate;

    public ProductTestDataBuilder() {
        id = new Long(1);
        name = "1234";
        date = new Date();
        buyPrice = new Float(8000);
        stock = 10;
    }

    public ProductTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public Product build() {
        return new Product(id,name, date,buyPrice,stock);
    }
}
