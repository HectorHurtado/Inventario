package com.ceiba.movement.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class DtoMovement {
    private Long id;
    private Long idProduct;
    private Integer amount;
    private Float salePrice;
    private Date saleDate;

}
