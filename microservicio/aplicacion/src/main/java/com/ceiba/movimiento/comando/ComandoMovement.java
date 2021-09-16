package com.ceiba.movimiento.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoMovement {

    private Long id;
    private Long idProduct;
    private Integer amount;
    private Float salePrice;
    private Date saleDate;
}
