package com.ceiba.movimiento.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.movimiento.comando.ComandoMovimiento;
import com.ceiba.movimiento.consulta.ManejadorObtenerGananciaMovimientos;
import com.ceiba.movimiento.consulta.ManejadorListarMovimientos;
import com.ceiba.movimiento.modelo.dto.DtoMovimiento;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/movimientos")
@Api(tags={"Controlador consulta movements"})
public class ConsultaControladorMovimiento {

    private final ManejadorListarMovimientos manejadorListarMovimientos;
    private final ManejadorObtenerGananciaMovimientos manejadorObtenerGananciaMovimientos;

    public ConsultaControladorMovimiento(ManejadorListarMovimientos manejadorListarMovimientos, ManejadorObtenerGananciaMovimientos manejadorObtenerGananciaMovimientos) {
        this.manejadorListarMovimientos = manejadorListarMovimientos;
        this.manejadorObtenerGananciaMovimientos = manejadorObtenerGananciaMovimientos;
    }

    @GetMapping
    @ApiOperation("Listar Movimientos")
    public List<DtoMovimiento> listar() {
        return this.manejadorListarMovimientos.ejecutar();
    }


    @PostMapping(value = "/ganancia")
    @ApiOperation("obtener ganancias")
    public ComandoRespuesta<Float> consultarGanancia(@RequestBody ComandoMovimiento comandoMovimiento) {
        return this.manejadorObtenerGananciaMovimientos.ejecutar(comandoMovimiento);
    }


}
