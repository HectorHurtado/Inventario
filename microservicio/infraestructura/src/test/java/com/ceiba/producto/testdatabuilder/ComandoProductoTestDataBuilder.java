package com.ceiba.producto.testdatabuilder;

import com.ceiba.producto.comando.ComandoProducto;

import java.util.Date;

public class ComandoProductoTestDataBuilder {

    private static final String PRODUCT_NAME = "Comida";

    private Long id = 1L;
    private String nombre;
    private Date fechaCreacion;
    private Float precioCompra;
    private Integer stock;
    private Date fechaAbastecimiento;

    public ComandoProductoTestDataBuilder() {

        this.nombre = PRODUCT_NAME;
        this.fechaCreacion = new Date();
        this.precioCompra = 8000F;
        this.stock = 10;
        this.fechaAbastecimiento = null;
    }

    public ComandoProductoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoProductoTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoProducto build() {
        return new ComandoProducto(this.id,this.nombre, this.fechaCreacion,this.precioCompra,this.stock,this.fechaAbastecimiento);
    }
}
