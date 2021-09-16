package com.ceiba.producto.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.producto.comando.ComandoProduct;
import com.ceiba.producto.comando.fabrica.FabricaProduct;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.servicio.ServicioActualizarProducto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarProduct implements ManejadorComando<ComandoProduct> {

    private final FabricaProduct fabricaProduct;
    private final ServicioActualizarProducto servicioActualizarProducto;

    public ManejadorActualizarProduct(FabricaProduct fabricaProduct, ServicioActualizarProducto servicioActualizarProducto) {
        this.fabricaProduct = fabricaProduct;
        this.servicioActualizarProducto = servicioActualizarProducto;
    }

    public void ejecutar(ComandoProduct comandoProduct) {
        Producto producto = this.fabricaProduct.crear(comandoProduct);
        this.servicioActualizarProducto.ejecutar(producto);
    }
}
