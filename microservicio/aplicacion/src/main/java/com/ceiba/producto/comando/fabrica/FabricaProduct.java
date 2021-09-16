package com.ceiba.producto.comando.fabrica;

import com.ceiba.producto.comando.ComandoProduct;
import com.ceiba.producto.modelo.entidad.Producto;
import org.springframework.stereotype.Component;

@Component
public class FabricaProduct {

    public Producto crear(ComandoProduct comandoProduct) {
        return new Producto(
                comandoProduct.getId(),
                comandoProduct.getName(),
                comandoProduct.getCreateDate(),
                comandoProduct.getBuyPrice(),
                comandoProduct.getStock(),
                comandoProduct.getSupplyingDate()
        );
    }

}
