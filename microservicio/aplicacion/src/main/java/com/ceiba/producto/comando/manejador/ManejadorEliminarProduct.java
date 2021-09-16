package com.ceiba.producto.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.producto.servicio.ServicioEliminarProducto;
import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarProduct implements ManejadorComando<Long> {

    private final ServicioEliminarProducto servicioEliminarProducto;

    public ManejadorEliminarProduct(ServicioEliminarProducto servicioEliminarProducto) {
        this.servicioEliminarProducto = servicioEliminarProducto;
    }

    public void ejecutar(Long idProduct) {
        this.servicioEliminarProducto.ejecutar(idProduct);
    }
}
