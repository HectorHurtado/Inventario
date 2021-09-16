package com.ceiba.movimiento.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class DtoMovimiento {
    private Long id;
    private Long idProducto;
    private Integer cantidad;
    private Float precioVenta;
    private Date fechaVenta;

}
