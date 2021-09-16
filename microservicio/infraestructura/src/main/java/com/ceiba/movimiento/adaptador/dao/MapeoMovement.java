package com.ceiba.movimiento.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.movimiento.modelo.dto.DtoMovimiento;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MapeoMovement implements RowMapper<DtoMovimiento>, MapperResult {

    @Override
    public DtoMovimiento mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Long idProduct = resultSet.getLong("id_product");
        Integer amount = resultSet.getInt("amount");
        Float salePrice = resultSet.getFloat("sale_price");
        Date saleDate = resultSet.getDate("sale_date");

        return new DtoMovimiento(id,idProduct,amount,salePrice,saleDate);
    }

}
