package com.ceiba.movimiento.testdatabuilder;

import com.ceiba.movimiento.comando.ComandoMovimiento;

import java.util.Date;

public class ComandoMovimientoTestDataBuilder {

    private Long id;
    private Long idProducto;
    private Integer cantidad;
    private Float precioVenta;
    private Date fechaVenta;

    public ComandoMovimientoTestDataBuilder() {
        id = 1L;
        idProducto = 1L;
        cantidad = 1;
        precioVenta = 10000F;
        fechaVenta = new Date();
    }

    public ComandoMovimientoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoMovimientoTestDataBuilder conIdProducto(Long id) {
        this.idProducto = idProducto;
        return this;
    }

    public ComandoMovimiento build() {
        return new ComandoMovimiento(this.id,this.idProducto,this.cantidad,this.precioVenta,this.fechaVenta);
    }
}
