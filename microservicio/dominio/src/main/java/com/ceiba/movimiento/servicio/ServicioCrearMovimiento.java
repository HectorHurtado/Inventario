package com.ceiba.movimiento.servicio;

import com.ceiba.movimiento.modelo.entidad.Movimiento;
import com.ceiba.movimiento.puerto.repositorio.RepositorioMovimiento;
import com.ceiba.producto.modelo.dto.DtoProducto;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.puerto.dao.DaoProducto;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;

import java.util.Calendar;
import java.util.Date;


public class ServicioCrearMovimiento {

    private final RepositorioMovimiento repositorioMovimiento;
    private final RepositorioProducto repositorioProducto;
    private final DaoProducto daoProducto;

    public ServicioCrearMovimiento(RepositorioMovimiento repositorioMovimiento, RepositorioProducto repositorioProducto, DaoProducto daoProducto) {
        this.repositorioMovimiento = repositorioMovimiento;
        this.repositorioProducto = repositorioProducto;
        this.daoProducto = daoProducto;
    }

    public Long ejecutar(Movimiento movimiento) {

        actualizarProducto(movimiento);
        return this.repositorioMovimiento.crear(movimiento);
    }

    private void actualizarProducto(Movimiento movimiento){

        DtoProducto dtoProducto = daoProducto.buscarPorId(movimiento.getIdProducto());
        Producto producto = new Producto(dtoProducto.getId(), dtoProducto.getNombre(),
                dtoProducto.getFechaCreacion(), dtoProducto.getPrecioCompra(),
                dtoProducto.getStock(), dtoProducto.getFechaAbastecimiento());
        producto = obtenerProductoParaActualizar(producto, movimiento.getFechaVenta());
        repositorioProducto.actualizar(producto);
    }


    private Producto obtenerProductoParaActualizar(Producto producto, Date fechaVenta){

        if(producto.getStock().equals(0)){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fechaVenta);
            calendar.add(Calendar.DAY_OF_WEEK,3);

            if(calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY){
                calendar.add(Calendar.DAY_OF_WEEK,2);
            }
            if(calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY){
                calendar.add(Calendar.DAY_OF_WEEK,1);
            }

            producto.setFechaAbastecimiento( calendar.getTime());
        }

        return producto;
    }

}
