package com.ceiba.movimiento.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.movimiento.comando.ComandoMovimiento;
import com.ceiba.movimiento.testdatabuilder.ComandoMovimientoTestDataBuilder;
import com.ceiba.producto.comando.ComandoProducto;
import com.ceiba.producto.testdatabuilder.ComandoProductoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ConsultaControladorMovimiento.class)
public class ConsultaControladorMovimientoTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void listar() throws Exception {
        // arrange

        // act - assert
        mocMvc.perform(get("/movimientos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].precioVenta", is(10000.0)));
    }


    @Test
    public void obtenerGananciasTest() throws Exception {
        // arrange
        ComandoMovimiento movimientoGanancia = new ComandoMovimientoTestDataBuilder().conFechaVenta(new Date()).build();
        // act - assert
        mocMvc.perform(post("/movimientos/ganancia")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(movimientoGanancia)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.valor", is(4000.0)));
    }

}
