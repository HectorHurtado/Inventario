package com.ceiba.product.servicio.testdatabuilder;

import com.ceiba.product.modelo.entidad.Product;
import com.ceiba.usuario.modelo.entidad.Usuario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class ProductTestDataBuilder {

    private static final String PRODUCT_NAME = "Comida";

    private Long id = 1L;
    private String name;
    private Date date;
    private Float buyPrice;
    private Integer stock;
    private Date supplyingDate;

    public ProductTestDataBuilder() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = sdf.parse("16/09/2021");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        name = PRODUCT_NAME;
        date = new Date();
        buyPrice = 8000F;
        stock = 10;
        supplyingDate = date;
    }

    public ProductTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ProductTestDataBuilder conSupplyingDate(Date supplyingDate) {
        this.supplyingDate = supplyingDate;
        return this;
    }

    public Product build() {
        return new Product(id,name, date,buyPrice,stock);
    }
}
