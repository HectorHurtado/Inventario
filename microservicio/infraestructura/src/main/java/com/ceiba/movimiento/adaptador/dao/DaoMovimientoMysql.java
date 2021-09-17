package com.ceiba.movimiento.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.movimiento.modelo.dto.DtoMovimiento;
import com.ceiba.movimiento.puerto.dao.DaoMovimiento;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class DaoMovimientoMysql implements DaoMovimiento {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="movimiento", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="movimiento", value="obtenerGanancia")
    private static String sqlGetProfit;

    public DaoMovimientoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoMovimiento> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoMovimiento());
    }

    @Override
    public Float obtenerGanancia(Date fecha) {

        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("fecha", fecha);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlGetProfit, paramSource,Float.class);
    }
}
