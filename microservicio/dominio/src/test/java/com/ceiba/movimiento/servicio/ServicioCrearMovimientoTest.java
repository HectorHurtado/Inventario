package com.ceiba.movimiento.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.movimiento.modelo.entidad.Movimiento;
import com.ceiba.movimiento.puerto.repositorio.RepositorioMovimiento;
import com.ceiba.movimiento.servicio.testdatabuilder.MovimientoTestDataBuilder;
import com.ceiba.producto.modelo.dto.DtoProducto;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.puerto.dao.DaoProducto;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import com.ceiba.producto.servicio.ServicioCrearProducto;
import com.ceiba.producto.servicio.testdatabuilder.ProductoTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ServicioCrearMovimientoTest {

    private static final Long ID = 1L;
    private static final String NOMBRE = "Comida";
    private static final Date FECHA_CREACION = new Date();
    private static final Float PRECIO_COMPRA = 8000F;
    private static final Integer STOCK = 2;
    private static final Integer SIN_STOCK = 0;



    @Test
    public void crearMovimientoTest() {
        // arrange
        Movimiento movimiento = new MovimientoTestDataBuilder().build();
        Long id = 1L;
        RepositorioMovimiento repositorioMovimiento = Mockito.mock(RepositorioMovimiento.class);
        Mockito.when(repositorioMovimiento.crear(Mockito.any())).thenReturn(id);
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        Mockito.when(repositorioProducto.crear(Mockito.any())).thenReturn(id);
        DtoProducto dtoProducto = new DtoProducto(1L,NOMBRE,FECHA_CREACION,PRECIO_COMPRA,STOCK,null);
        DaoProducto daoProducto = Mockito.mock(DaoProducto.class);
        Mockito.when(daoProducto.buscarPorId(Mockito.anyLong())).thenReturn(dtoProducto);
        ServicioCrearMovimiento servicioCrearMovimiento = new ServicioCrearMovimiento(repositorioMovimiento, repositorioProducto, daoProducto);
        // act - assert
        Long idRespuesta = servicioCrearMovimiento.ejecutar(movimiento);
        Assert.assertEquals(idRespuesta,id);

    }


    @Test
    public void crearMovimientoSinStockTest() {
        // arrange
        Movimiento movimiento = new MovimientoTestDataBuilder().build();
        Long id = 1L;
        RepositorioMovimiento repositorioMovimiento = Mockito.mock(RepositorioMovimiento.class);
        Mockito.when(repositorioMovimiento.crear(Mockito.any())).thenReturn(id);
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        Mockito.when(repositorioProducto.crear(Mockito.any())).thenReturn(id);
        DtoProducto dtoProducto = new DtoProducto(1L,NOMBRE,FECHA_CREACION,PRECIO_COMPRA,SIN_STOCK,null);
        DaoProducto daoProducto = Mockito.mock(DaoProducto.class);
        Mockito.when(daoProducto.buscarPorId(Mockito.anyLong())).thenReturn(dtoProducto);
        ServicioCrearMovimiento servicioCrearMovimiento = new ServicioCrearMovimiento(repositorioMovimiento, repositorioProducto, daoProducto);
        // act - assert
        Long idRespuesta = servicioCrearMovimiento.ejecutar(movimiento);
        Assert.assertEquals(idRespuesta,id);

    }
}
