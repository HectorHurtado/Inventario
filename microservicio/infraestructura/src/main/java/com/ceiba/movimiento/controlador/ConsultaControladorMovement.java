package com.ceiba.movimiento.controlador;

import com.ceiba.movimiento.consulta.ManejadorGetProfitMovements;
import com.ceiba.movimiento.consulta.ManejadorListarMovements;
import com.ceiba.movimiento.modelo.dto.DtoMovimiento;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/movements")
@Api(tags={"Controlador consulta movements"})
public class ConsultaControladorMovement {

    private final ManejadorListarMovements manejadorListarMovements;
    private final ManejadorGetProfitMovements manejadorGetProfitMovements;

    public ConsultaControladorMovement(ManejadorListarMovements manejadorListarMovements,ManejadorGetProfitMovements manejadorGetProfitMovements) {
        this.manejadorListarMovements = manejadorListarMovements;
        this.manejadorGetProfitMovements = manejadorGetProfitMovements;
    }

    @GetMapping
    @ApiOperation("Listar Movimientos")
    public List<DtoMovimiento> listar() {
        return this.manejadorListarMovements.ejecutar();
    }

    @GetMapping("/getProfit")
    @ApiOperation("obtener ganancias")
    public Float getProfit(@RequestBody Date date) {
        return this.manejadorGetProfitMovements.ejecutar(date);
    }


}
