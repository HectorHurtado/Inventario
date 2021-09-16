package com.ceiba.producto.consulta;

import com.ceiba.producto.modelo.dto.DtoProducto;
import com.ceiba.producto.puerto.dao.DaoProducto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorProducts {

    private final DaoProducto daoProducto;

    public ManejadorProducts(DaoProducto daoProducto){
        this.daoProducto = daoProducto;
    }

    public DtoProducto ejecutar(Long idProduct){ return this.daoProducto.buscarPorId(idProduct); }



}
