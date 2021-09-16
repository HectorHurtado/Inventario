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
    public void fechaDeAbastecimientoTresDiasDespuesSabadoTest() {
        // arrange
        ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder();
        Producto producto = productoTestDataBuilder.conId(1L).conFechaAbastecimiento("20/09/2021").build();
        Date date = obtieneFechaParseada("15/09/2021");
        // act - assert
        Assert.assertEquals(producto.getFechaAbastecimiento(), obtenerFechaDeAbastecimiento(date));
    }

    @Test
    public void fechaDeAbastecimientoTresDiasDespuesDomingoTest() {
        // arrange
        ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder();
        Producto producto = productoTestDataBuilder.conId(1L).conFechaAbastecimiento("20/09/2021").build();
        Date date = obtieneFechaParseada("16/09/2021");
        // act - assert
        Assert.assertEquals(producto.getFechaAbastecimiento(), obtenerFechaDeAbastecimiento(date));
    }

    @Test
    public void fechaDeAbastecimientoTresDiasDespuesEntreSemanaTest() {
        // arrange
        ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder();
        Producto producto = productoTestDataBuilder.conId(1L).conFechaAbastecimiento("16/09/2021").build();
        Date date = obtieneFechaParseada("13/09/2021");
        // act - assert
        Assert.assertEquals(producto.getFechaAbastecimiento(), obtenerFechaDeAbastecimiento(date));
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

    private Date obtenerFechaDeAbastecimiento(Date fechaVenta){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaVenta);
        calendar.add(Calendar.DAY_OF_WEEK,3);

        if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
            calendar.add(Calendar.DAY_OF_WEEK,2);
        }
        if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
            calendar.add(Calendar.DAY_OF_WEEK,1);
        }

        return calendar.getTime();
    }
}
