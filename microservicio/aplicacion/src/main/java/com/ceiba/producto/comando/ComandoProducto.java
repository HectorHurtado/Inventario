package com.ceiba.producto.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoProducto {

    private Long id;
    private String nombre;
    private Date fechaCreacion;
    private Float precioCompra;
    private Integer stock;
    private Date fechaAbastecimiento;
}
