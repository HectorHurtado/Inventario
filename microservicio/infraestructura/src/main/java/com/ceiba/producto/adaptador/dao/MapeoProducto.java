package com.ceiba.producto.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.producto.modelo.dto.DtoProducto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MapeoProducto implements RowMapper<DtoProducto>, MapperResult {

    @Override
    public DtoProducto mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        Date fechaCreacion = resultSet.getDate("fecha_creacion");
        Float precioCompra = resultSet.getFloat("precio_compra");
        Integer stock = resultSet.getInt("stock");
        Date fechaAbastecimiento = resultSet.getDate("fecha_abastecimiento");

        return new DtoProducto(id,nombre,fechaCreacion,precioCompra,stock,fechaAbastecimiento);

    }

}
