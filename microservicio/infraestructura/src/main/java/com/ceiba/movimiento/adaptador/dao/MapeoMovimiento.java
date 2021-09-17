package com.ceiba.movimiento.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.movimiento.modelo.dto.DtoMovimiento;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MapeoMovimiento implements RowMapper<DtoMovimiento>, MapperResult {

    @Override
    public DtoMovimiento mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Long idProducto = resultSet.getLong("id_producto");
        Integer cantidad = resultSet.getInt("cantidad");
        Float precioVenta = resultSet.getFloat("precio_venta");
        Date fechaVenta = resultSet.getDate("fecha_venta");

        return new DtoMovimiento(id,idProducto,cantidad,precioVenta,fechaVenta);
    }

}
