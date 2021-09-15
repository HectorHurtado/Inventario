package com.ceiba.product.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.product.modelo.entidad.Product;
import com.ceiba.product.puerto.repositorio.RepositorioProduct;
import com.ceiba.product.servicio.testdatabuilder.ProductTestDataBuilder;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearProductTest {

    @Test
    public void validarProductoExistenciaPreviaTest() {
        // arrange
        Product product = new ProductTestDataBuilder().build();
        RepositorioProduct repositorioProduct = Mockito.mock(RepositorioProduct.class);
        Mockito.when(repositorioProduct.existe(Mockito.anyString())).thenReturn(true);
        CreateProductService createProductService = new CreateProductService(repositorioProduct);
        // act - assert
        BasePrueba.assertThrows(() -> createProductService.ejecutar(product), ExcepcionDuplicidad.class,"El producto ya existe en el sistema");
    }
}
