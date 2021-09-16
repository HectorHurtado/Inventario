package com.ceiba.movimiento.modelo.entidad;


import lombok.Getter;

import java.util.Date;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Movimiento {

    private static final String SE_DEBE_INGRESAR_EL_ID_DEL_PRODUCTO = "Se debe ingresar el id del producto";
    private static final String SE_DEBE_INGRESAR_LA_CANTIDAD_EN_MOVIMIENTO = "Se debe ingresar la cantidad en movimiento";
    private static final String SE_DEBE_INGRESAR_EL_PRECIO_DEL_MOVIMIENTO = "Se debe ingresar el precio del movimiento";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DEL_MOVIMIENTO = "Se debe ingresar la fecha del movimiento";

    private Long id;
    private Long idProducto;
    private Integer cantidad;
    private Float precioVenta;
    private Date fechaVenta;

    public Movimiento(Long id, Long idProducto, Integer cantidad, Float precioVenta, Date fechaVenta) {
        validarObligatorio(idProducto, SE_DEBE_INGRESAR_EL_ID_DEL_PRODUCTO);
        validarObligatorio(cantidad, SE_DEBE_INGRESAR_LA_CANTIDAD_EN_MOVIMIENTO);
        validarObligatorio(precioVenta, SE_DEBE_INGRESAR_EL_PRECIO_DEL_MOVIMIENTO);
        validarObligatorio(fechaVenta, SE_DEBE_INGRESAR_LA_FECHA_DEL_MOVIMIENTO);

        this.id = id;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.fechaVenta = fechaVenta;
    }

}
