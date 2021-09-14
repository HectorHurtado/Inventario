package com.ceiba.product.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@AllArgsConstructor
public class DtoProduct {
    private Long id;
    private String name;
    private Date date;
    private Float buyPrice;
    private Integer stock;
    private Date supplyingDate;

}
