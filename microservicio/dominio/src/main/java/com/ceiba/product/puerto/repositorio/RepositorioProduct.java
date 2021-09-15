package com.ceiba.product.puerto.repositorio;

import com.ceiba.product.modelo.entidad.Product;

public interface RepositorioProduct {
    /**
     * Permite crear un producto
     * @param product
     * @return el id generado
     */
    Long crear(Product product);

    /**
     * Permite actualizar un producto
     * @param product
     */
    void actualizar(Product product);

    /**
     * Permite eliminar un producto
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un producto con un nombre
     * @param name
     * @return si existe o no
     */
    boolean existe(String name);

    /**
     * Permite validar si existe un producto con un nombre excluyendo un id
     * @param name
     * @return si existe o no
     */
    boolean existeExcluyendoId(Long id,String name);

    /**
     * Retorna un producto por su id
     * @param id
     * @return producto
     */
     Product findById(Long id);

}
