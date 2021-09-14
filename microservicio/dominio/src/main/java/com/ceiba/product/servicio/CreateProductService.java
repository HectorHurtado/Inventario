package com.ceiba.product.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.product.modelo.entidad.Product;
import com.ceiba.product.puerto.repositorio.RepositorioProduct;


public class CreateProductService {

    private static final String EL_PRODUCTO_YA_EXISTE_EN_EL_SISTEMA = "El producto ya existe en el sistema";

    private final RepositorioProduct repositorioProduct;

    public CreateProductService(RepositorioProduct repositorioProduct) {
        this.repositorioProduct = repositorioProduct;
    }

    public Long ejecutar(Product product) {
        validarExistenciaPrevia(product);
        return this.repositorioProduct.crear(product);
    }

    private void validarExistenciaPrevia(Product product) {
        boolean existe = this.repositorioProduct.existe(product.getName());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_PRODUCTO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
