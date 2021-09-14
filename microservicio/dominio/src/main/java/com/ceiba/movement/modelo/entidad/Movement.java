package com.ceiba.movement.modelo.entidad;


import lombok.Getter;

import java.util.Date;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Movement {

    private static final String SE_DEBE_INGRESAR_EL_ID_DEL_PRODUCTO = "Se debe ingresar el id del producto";
    private static final String SE_DEBE_INGRESAR_LA_CANTIDAD_EN_MOVIMIENTO = "Se debe ingresar la cantidad en movimiento";
    private static final String SE_DEBE_INGRESAR_EL_PRECIO_DEL_MOVIMIENTO = "Se debe ingresar el precio del movimiento";

    private Long id;
    private Long idProduct;
    private Integer amount;
    private Float salePrice;

    public Movement(Long id, Long idProduct, Integer amount, Float salePrice) {
        validarObligatorio(idProduct, SE_DEBE_INGRESAR_EL_ID_DEL_PRODUCTO);
        validarObligatorio(amount, SE_DEBE_INGRESAR_LA_CANTIDAD_EN_MOVIMIENTO);
        validarObligatorio(salePrice, SE_DEBE_INGRESAR_EL_PRECIO_DEL_MOVIMIENTO);

        this.id = id;
        this.idProduct = idProduct;
        this.amount = amount;
        this.salePrice = salePrice;
    }

}
