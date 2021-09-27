package com.ceiba.movimiento.servicio.testdatabuilder;

import com.ceiba.movimiento.modelo.entidad.Movimiento;

import java.util.Date;

public class MovimientoTestDataBuilder {

    private Long id;
    private Long idProducto;
    private Integer cantidad;
    private Float precioVenta;
    private Date fechaVenta;

    public MovimientoTestDataBuilder() {
        id = 1L;
        idProducto = 1L;
        cantidad = 1;
        precioVenta = 10000F;
        fechaVenta = new Date();
    }


    public MovimientoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public MovimientoTestDataBuilder conPrecioVenta(Date saleDate) {
        this.fechaVenta = saleDate;
        return this;
    }
    public MovimientoTestDataBuilder conCantidad(int cantidad) {
        this.cantidad = cantidad;
        return this;
    }

    public Movimiento build() {
        return new Movimiento(this.id, this.idProducto, this.cantidad, this.precioVenta, this.fechaVenta);
    }
}
