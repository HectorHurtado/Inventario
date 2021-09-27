package com.ceiba.configuracion;

import com.ceiba.movimiento.puerto.repositorio.RepositorioMovimiento;
import com.ceiba.movimiento.servicio.ServicioCrearMovimiento;
import com.ceiba.producto.puerto.dao.DaoProducto;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import com.ceiba.producto.servicio.ServicioCrearProducto;
import com.ceiba.producto.servicio.ServicioEliminarProducto;
import com.ceiba.producto.servicio.ServicioActualizarProducto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {


    @Bean
    public ServicioCrearProducto createProductService(RepositorioProducto repositorioProducto) {
        return new ServicioCrearProducto(repositorioProducto);
    }

    @Bean
    public ServicioActualizarProducto updateProductService(RepositorioProducto repositorioProducto) {
        return new ServicioActualizarProducto(repositorioProducto);
    }

    @Bean
    public ServicioEliminarProducto deleteProductService(RepositorioProducto repositorioProducto) {
        return new ServicioEliminarProducto(repositorioProducto);
    }

    @Bean
    public ServicioCrearMovimiento createMovementService(RepositorioMovimiento repositorioMovimiento, RepositorioProducto repositorioProducto, DaoProducto daoProducto) {
        return new ServicioCrearMovimiento(repositorioMovimiento, repositorioProducto, daoProducto);
    }

}
