package com.ceiba.producto.controlador;

import com.ceiba.producto.consulta.ManejadorListarProducts;
import com.ceiba.producto.modelo.dto.DtoProducto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos")
@Api(tags={"Controlador consulta productos"})
public class ConsultaControladorProducto {

    private final ManejadorListarProducts manejadorListarProducts;

    public ConsultaControladorProducto(ManejadorListarProducts manejadorListarProducts) {
        this.manejadorListarProducts = manejadorListarProducts;
    }

    @GetMapping
    @ApiOperation("Listar Productos")
    public List<DtoProducto> listar() {
        return this.manejadorListarProducts.ejecutar();
    }

}
