package com.ceiba.movement.servicio;

import com.ceiba.movement.modelo.entidad.Movement;
import com.ceiba.movement.servicio.testdatabuilder.MovementTestDataBuilder;
import com.ceiba.product.modelo.entidad.Product;
import com.ceiba.product.servicio.testdatabuilder.ProductTestDataBuilder;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class ServicioCrearMovementTest {

    @Test
    public void fechaDeAbastecimiento() {
        // arrange
        ProductTestDataBuilder productTestDataBuilder = new ProductTestDataBuilder();
        Product product = productTestDataBuilder.conId(1L).build();
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date = sdf.parse("15/09/2021");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // act - assert
        Assert.assertEquals(product.getSupplyingDate(), getSupplyingDate(date));
    }


    private Date getSupplyingDate(Date saleDate){

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(saleDate);
            calendar.add(Calendar.DAY_OF_WEEK,3);

            if(calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY){
                calendar.add(Calendar.DAY_OF_WEEK,2);
            }
            if(calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY){
                calendar.add(Calendar.DAY_OF_WEEK,1);
            }

            return calendar.getTime();
    }
}
