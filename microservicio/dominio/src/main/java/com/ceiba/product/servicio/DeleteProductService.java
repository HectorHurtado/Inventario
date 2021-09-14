package com.ceiba.product.servicio;

import com.ceiba.product.puerto.repositorio.RepositorioProduct;

public class DeleteProductService {

    private final RepositorioProduct repositorioProduct;

    public DeleteProductService(RepositorioProduct repositorioProduct) {
        this.repositorioProduct = repositorioProduct;
    }

    public void ejecutar(Long id) {
        this.repositorioProduct.eliminar(id);
    }
}
