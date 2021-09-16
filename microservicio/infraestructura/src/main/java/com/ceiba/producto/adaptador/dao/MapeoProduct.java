package com.ceiba.producto.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.producto.modelo.dto.DtoProducto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MapeoProduct implements RowMapper<DtoProducto>, MapperResult {

    @Override
    public DtoProducto mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        Date createDate = resultSet.getDate("create_date");
        Float buyPrice = resultSet.getFloat("buy_price");
        Integer stock = resultSet.getInt("stock");
        Date supplyingDate = resultSet.getDate("supplying_date");

        return new DtoProducto(id,name,createDate,buyPrice,stock,supplyingDate);

    }

}
