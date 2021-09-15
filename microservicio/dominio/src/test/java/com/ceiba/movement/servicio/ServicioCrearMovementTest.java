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


}
