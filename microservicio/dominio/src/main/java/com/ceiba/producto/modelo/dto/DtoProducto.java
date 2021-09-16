package com.ceiba.producto.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class DtoProducto {
    private Long id;
    private String nombre;
    private Date fechaCreacion;
    private Float precioCompra;
    private Integer stock;
    private Date fechaAbastecimiento;

}
