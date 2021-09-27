package com.ceiba.producto.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import com.ceiba.producto.servicio.testdatabuilder.ProductoTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ServicioCrearProductoTest {

    private static final Long ID = 1L;

    @Test
    public void validarProductoExistenciaPreviaTest() {
        // arrange
        Producto producto = new ProductoTestDataBuilder().build();
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        Mockito.when(repositorioProducto.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearProducto servicioCrearProducto = new ServicioCrearProducto(repositorioProducto);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearProducto.ejecutar(producto), ExcepcionDuplicidad.class,"El producto ya existe en el sistema");
    }


    @Test
    public void crearProductoTest() {
        // arrange
        Producto producto = new ProductoTestDataBuilder().conId(1L).build();

        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        Mockito.when(repositorioProducto.crear(Mockito.any())).thenReturn(ID);

        ServicioCrearProducto servicioCrearProducto = new ServicioCrearProducto(repositorioProducto);
        // act - assert
        Long idRespuesta = servicioCrearProducto.ejecutar(producto);
        Assert.assertEquals(idRespuesta, producto.getId());
    }



}
