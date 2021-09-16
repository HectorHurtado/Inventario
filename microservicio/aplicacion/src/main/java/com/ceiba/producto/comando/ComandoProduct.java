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
public class ComandoProduct {

    private Long id;
    private String name;
    private Date createDate;
    private Float buyPrice;
    private Integer stock;
    private Date supplyingDate;
}
