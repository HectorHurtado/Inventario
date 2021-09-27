package com.ceiba.movimiento.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
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
    private static final Integer CANTIDAD_VENTA = 2;
    private static final Integer CANTIDAD_SUPERIOR_A_STOCK = 10;



    @Test
    public void crearMovimientoTest() {
        // arrange
        Movimiento movimiento = new MovimientoTestDataBuilder().build();

        RepositorioMovimiento repositorioMovimiento = Mockito.mock(RepositorioMovimiento.class);
        Mockito.when(repositorioMovimiento.crear(Mockito.any())).thenReturn(ID);

        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        Mockito.when(repositorioProducto.crear(Mockito.any())).thenReturn(ID);

        DtoProducto dtoProducto = new DtoProducto(1L,NOMBRE,FECHA_CREACION,PRECIO_COMPRA,STOCK,null);
        DaoProducto daoProducto = Mockito.mock(DaoProducto.class);
        Mockito.when(daoProducto.buscarPorId(Mockito.anyLong())).thenReturn(dtoProducto);

        ServicioCrearMovimiento servicioCrearMovimiento = new ServicioCrearMovimiento(repositorioMovimiento, repositorioProducto, daoProducto);
        // act - assert
        Long idRespuesta = servicioCrearMovimiento.ejecutar(movimiento);
        Assert.assertEquals(idRespuesta,movimiento.getId());

    }


    @Test
    public void crearMovimientoConCantidadMayorAlStockTest() {
        // arrange
        Movimiento movimiento = new MovimientoTestDataBuilder().conCantidad(CANTIDAD_SUPERIOR_A_STOCK).build();

        RepositorioMovimiento repositorioMovimiento = Mockito.mock(RepositorioMovimiento.class);
        Mockito.when(repositorioMovimiento.crear(Mockito.any())).thenReturn(ID);

        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        Mockito.when(repositorioProducto.crear(Mockito.any())).thenReturn(ID);

        DtoProducto dtoProducto = new DtoProducto(1L,NOMBRE,FECHA_CREACION,PRECIO_COMPRA,STOCK,null);
        DaoProducto daoProducto = Mockito.mock(DaoProducto.class);
        Mockito.when(daoProducto.buscarPorId(Mockito.anyLong())).thenReturn(dtoProducto);

        ServicioCrearMovimiento servicioCrearMovimiento = new ServicioCrearMovimiento(repositorioMovimiento, repositorioProducto, daoProducto);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearMovimiento.ejecutar(movimiento), ExcepcionValorInvalido.class,"La cantidad no puede ser superior al stock del producto");

    }

    @Test
    public void fechaDeAbastecimientoTresDiasDespuesSabadoTest() {

        // arrange
        RepositorioMovimiento repositorioMovimiento = Mockito.mock(RepositorioMovimiento.class);
        Mockito.when(repositorioMovimiento.crear(Mockito.any())).thenReturn(ID);

        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        Mockito.when(repositorioProducto.crear(Mockito.any())).thenReturn(ID);

        DtoProducto dtoProducto = new DtoProducto(1L,NOMBRE,FECHA_CREACION,PRECIO_COMPRA,STOCK,null);
        DaoProducto daoProducto = Mockito.mock(DaoProducto.class);
        Mockito.when(daoProducto.buscarPorId(Mockito.anyLong())).thenReturn(dtoProducto);

        ServicioCrearMovimiento servicioCrearMovimiento = new ServicioCrearMovimiento(repositorioMovimiento, repositorioProducto, daoProducto);

        ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder();
        Producto producto = productoTestDataBuilder.conId(1L).conStock(STOCK).build();
        servicioCrearMovimiento.actualizarStockProducto(producto,CANTIDAD_VENTA);
        servicioCrearMovimiento.actualizarFechaAbastecimiento(producto,obtieneFechaParseada("29/09/2021"));
        Date date = obtieneFechaParseada("04/10/2021");
        // act - assert
        Assert.assertEquals(date, producto.getFechaAbastecimiento());

    }

    @Test
    public void fechaDeAbastecimientoTresDiasDespuesDomingoTest() {

        // arrange
        RepositorioMovimiento repositorioMovimiento = Mockito.mock(RepositorioMovimiento.class);
        Mockito.when(repositorioMovimiento.crear(Mockito.any())).thenReturn(ID);

        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        Mockito.when(repositorioProducto.crear(Mockito.any())).thenReturn(ID);

        DtoProducto dtoProducto = new DtoProducto(1L,NOMBRE,FECHA_CREACION,PRECIO_COMPRA,STOCK,null);
        DaoProducto daoProducto = Mockito.mock(DaoProducto.class);
        Mockito.when(daoProducto.buscarPorId(Mockito.anyLong())).thenReturn(dtoProducto);

        ServicioCrearMovimiento servicioCrearMovimiento = new ServicioCrearMovimiento(repositorioMovimiento, repositorioProducto, daoProducto);

        ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder();
        Producto producto = productoTestDataBuilder.conId(1L).conStock(STOCK).build();
        servicioCrearMovimiento.actualizarStockProducto(producto,CANTIDAD_VENTA);
        servicioCrearMovimiento.actualizarFechaAbastecimiento(producto,obtieneFechaParseada("30/09/2021"));
        Date date = obtieneFechaParseada("04/10/2021");
        // act - assert
        Assert.assertEquals(date, producto.getFechaAbastecimiento());

    }

    @Test
    public void fechaDeAbastecimientoTresDiasDespuesEntreSemanaTest() {

        // arrange
        RepositorioMovimiento repositorioMovimiento = Mockito.mock(RepositorioMovimiento.class);
        Mockito.when(repositorioMovimiento.crear(Mockito.any())).thenReturn(ID);

        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        Mockito.when(repositorioProducto.crear(Mockito.any())).thenReturn(ID);

        DtoProducto dtoProducto = new DtoProducto(1L,NOMBRE,FECHA_CREACION,PRECIO_COMPRA,STOCK,null);
        DaoProducto daoProducto = Mockito.mock(DaoProducto.class);
        Mockito.when(daoProducto.buscarPorId(Mockito.anyLong())).thenReturn(dtoProducto);

        ServicioCrearMovimiento servicioCrearMovimiento = new ServicioCrearMovimiento(repositorioMovimiento, repositorioProducto, daoProducto);

        ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder();
        Producto producto = productoTestDataBuilder.conId(1L).conStock(STOCK).build();
        servicioCrearMovimiento.actualizarStockProducto(producto,CANTIDAD_VENTA);
        servicioCrearMovimiento.actualizarFechaAbastecimiento(producto,obtieneFechaParseada("27/09/2021"));
        Date date = obtieneFechaParseada("30/09/2021");
        // act - assert
        Assert.assertEquals(date, producto.getFechaAbastecimiento());

    }

    private Date obtieneFechaParseada(String fecha){

        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date = sdf.parse(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }
}
