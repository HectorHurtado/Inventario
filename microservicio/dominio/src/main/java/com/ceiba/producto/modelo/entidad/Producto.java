package com.ceiba.producto.modelo.entidad;


import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
@Setter
public class Producto {

    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_PRODUCTO = "Se debe ingresar el nombre de producto";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION = "Se debe ingresar la fecha de creación";
    private static final String SE_DEBE_INGRESAR_EL_PRECIO_DEL_PRODUCTO = "Se debe ingresar el precio del producto";
    private static final String SE_DEBE_INGRESAR_EL_STOCK_DEL_PRODUCTO = "Se debe ingresar el stock del producto";



    private Long id;
    private String nombre;
    private Date fechaCreacion;
    private Float precioCompra;
    private Integer stock;
    private Date fechaAbastecimiento;

    public Producto(Long id, String nombre, Date fechaCreacion, Float precioCompra, Integer stock, Date fechaAbastecimiento) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_PRODUCTO);
        validarObligatorio(precioCompra, SE_DEBE_INGRESAR_EL_PRECIO_DEL_PRODUCTO);
        validarObligatorio(stock, SE_DEBE_INGRESAR_EL_STOCK_DEL_PRODUCTO);

        this.id = id;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.precioCompra = precioCompra;
        this.stock = stock;
        this.fechaAbastecimiento = fechaAbastecimiento;
    }

}
