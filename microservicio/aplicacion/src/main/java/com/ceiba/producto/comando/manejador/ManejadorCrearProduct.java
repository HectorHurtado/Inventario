package com.ceiba.producto.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.producto.comando.ComandoProduct;
import com.ceiba.producto.comando.fabrica.FabricaProduct;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.servicio.ServicioCrearProducto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearProduct implements ManejadorComandoRespuesta<ComandoProduct, ComandoRespuesta<Long>> {

    private final FabricaProduct fabricaProduct;
    private final ServicioCrearProducto servicioCrearProducto;

    public ManejadorCrearProduct(FabricaProduct fabricaProduct, ServicioCrearProducto servicioCrearProducto) {
        this.fabricaProduct = fabricaProduct;
        this.servicioCrearProducto = servicioCrearProducto;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoProduct comandoProduct) {
        Producto producto = this.fabricaProduct.crear(comandoProduct);
        return new ComandoRespuesta<>(this.servicioCrearProducto.ejecutar(producto));
    }
}
