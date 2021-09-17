package com.ceiba.movimiento.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.movimiento.comando.ComandoMovimiento;
import com.ceiba.movimiento.comando.manejador.ManejadorCrearMovimiento;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movimientos")
@Api(tags = { "Controlador comando movimientos"})
public class ComandoControladorMovimiento {

    private final ManejadorCrearMovimiento manejadorCrearMovimiento;

    @Autowired
    public ComandoControladorMovimiento(ManejadorCrearMovimiento manejadorCrearMovimiento) {
        this.manejadorCrearMovimiento = manejadorCrearMovimiento;
    }

    @PostMapping
    @ApiOperation("Crear Movimiento")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoMovimiento comandoMovimiento) {
        return manejadorCrearMovimiento.ejecutar(comandoMovimiento);
    }
}
