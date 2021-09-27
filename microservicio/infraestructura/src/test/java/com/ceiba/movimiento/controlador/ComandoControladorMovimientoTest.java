package com.ceiba.movimiento.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.movimiento.comando.ComandoMovimiento;
import com.ceiba.movimiento.testdatabuilder.ComandoMovimientoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorMovimiento.class)
public class ComandoControladorMovimientoTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void crear() throws Exception{
        // arrange
        ComandoMovimiento movement = new ComandoMovimientoTestDataBuilder().conId(2L).conIdProducto(2L).build();

        // act - assert
        mocMvc.perform(post("/movimientos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(movement)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }
}
