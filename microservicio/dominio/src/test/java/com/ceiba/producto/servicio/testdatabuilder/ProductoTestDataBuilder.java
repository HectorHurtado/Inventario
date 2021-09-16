package com.ceiba.producto.servicio.testdatabuilder;

import com.ceiba.producto.modelo.entidad.Producto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductoTestDataBuilder {

    private static final String PRODUCT_NAME = "Comida";

    private Long id = 1L;
    private String nombre;
    private Date fechaCreacion;
    private Float precioCompra;
    private Integer stock;
    private Date fechaAbastecimiento;

    public ProductoTestDataBuilder() {

        this.nombre = PRODUCT_NAME;
        this.fechaCreacion = new Date();
        this.precioCompra = 8000F;
        this.stock = 10;
        this.fechaAbastecimiento = new Date();
    }

    public ProductoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ProductoTestDataBuilder conFechaAbastecimiento(String fechaAbastecimiento){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = sdf.parse(fechaAbastecimiento);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.fechaAbastecimiento = date;
        return this;
    }

    public ProductoTestDataBuilder conSupplyingDate(Date supplyingDate) {
        this.fechaAbastecimiento = supplyingDate;
        return this;
    }

    public Producto build() {
        return new Producto(this.id,this.nombre, this.fechaCreacion,this.precioCompra,this.stock,this.fechaAbastecimiento);
    }
}
