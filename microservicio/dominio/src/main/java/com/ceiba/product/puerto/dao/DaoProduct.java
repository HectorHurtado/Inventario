package com.ceiba.product.puerto.dao;

import com.ceiba.product.modelo.dto.DtoProduct;

import java.util.List;

public interface DaoProduct {

    /**
     * Permite listar productos
     * @return los productos
     */
    List<DtoProduct> listar();
}
