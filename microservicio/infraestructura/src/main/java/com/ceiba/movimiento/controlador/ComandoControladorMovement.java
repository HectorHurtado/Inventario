package com.ceiba.movimiento.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.movimiento.comando.ComandoMovement;
import com.ceiba.movimiento.comando.manejador.ManejadorCrearMovement;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movements")
@Api(tags = { "Controlador comando movimientos"})
public class ComandoControladorMovement {

    private final ManejadorCrearMovement manejadorCrearMovement;

    @Autowired
    public ComandoControladorMovement(ManejadorCrearMovement manejadorCrearMovement) {
        this.manejadorCrearMovement = manejadorCrearMovement;
    }

    @PostMapping
    @ApiOperation("Crear Movimiento")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoMovement comandoMovement) {
        return manejadorCrearMovement.ejecutar(comandoMovement);
    }
}
