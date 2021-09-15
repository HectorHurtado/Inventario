package com.ceiba.product.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.product.modelo.entidad.Product;
import com.ceiba.product.puerto.repositorio.RepositorioProduct;

public class UpdateProductService {

    private final RepositorioProduct repositorioProduct;

    public UpdateProductService(RepositorioProduct repositorioProduct) {
        this.repositorioProduct = repositorioProduct;
    }

    public void ejecutar(Product product) {
        this.repositorioProduct.actualizar(product);
    }
}
