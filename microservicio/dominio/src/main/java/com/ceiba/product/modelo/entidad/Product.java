package com.ceiba.product.modelo.entidad;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

import static com.ceiba.dominio.ValidadorArgumento.validarLongitud;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
@Setter
public class Product {

    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_PRODUCTO = "Se debe ingresar el nombre de producto";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION = "Se debe ingresar la fecha de creación";
    private static final String SE_DEBE_INGRESAR_EL_PRECIO_DEL_PRODUCTO = "Se debe ingresar el precio del producto";
    private static final String SE_DEBE_INGRESAR_EL_STOCK_DEL_PRODUCTO = "Se debe ingresar el stock del producto";



    private Long id;
    private String name;
    private Date date;
    private Float buyPrice;
    private Integer stock;
    private Date supplyingDate;

    public Product(Long id, String name, Date date, Float buyPrice,Integer stock, Date supplyingDate) {
        validarObligatorio(name, SE_DEBE_INGRESAR_EL_NOMBRE_DE_PRODUCTO);
        validarObligatorio(buyPrice, SE_DEBE_INGRESAR_EL_PRECIO_DEL_PRODUCTO);
        validarObligatorio(stock, SE_DEBE_INGRESAR_EL_STOCK_DEL_PRODUCTO);

        this.id = id;
        this.name = name;
        this.date = date;
        this.buyPrice = buyPrice;
        this.stock = stock;
        this.supplyingDate = supplyingDate;
    }

}
