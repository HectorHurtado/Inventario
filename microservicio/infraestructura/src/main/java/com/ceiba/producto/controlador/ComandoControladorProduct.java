package com.ceiba.producto.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.producto.comando.ComandoProduct;
import com.ceiba.producto.comando.manejador.ManejadorActualizarProduct;
import com.ceiba.producto.comando.manejador.ManejadorCrearProduct;
import com.ceiba.producto.comando.manejador.ManejadorEliminarProduct;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@Api(tags = { "Controlador comando productos"})
public class ComandoControladorProduct {

    private final ManejadorCrearProduct manejadorCrearProduct;
	private final ManejadorEliminarProduct manejadorEliminarProduct;
	private final ManejadorActualizarProduct manejadorActualizarProduct;

    @Autowired
    public ComandoControladorProduct(ManejadorCrearProduct manejadorCrearProduct,
									 ManejadorEliminarProduct manejadorEliminarProduct,
									 ManejadorActualizarProduct manejadorActualizarProduct) {
        this.manejadorCrearProduct = manejadorCrearProduct;
		this.manejadorEliminarProduct = manejadorEliminarProduct;
		this.manejadorActualizarProduct = manejadorActualizarProduct;
    }

    @PostMapping
    @ApiOperation("Crear Producto")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoProduct comandoProduct) {
        return manejadorCrearProduct.ejecutar(comandoProduct);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Producto")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarProduct.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Producto")
	public void actualizar(@RequestBody ComandoProduct comandoProduct,@PathVariable Long id) {
		comandoProduct.setId(id);
		manejadorActualizarProduct.ejecutar(comandoProduct);
	}
}
