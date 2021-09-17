package com.ceiba.movimiento.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.movimiento.modelo.entidad.Movimiento;
import com.ceiba.movimiento.puerto.repositorio.RepositorioMovimiento;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioMovimientoMysql implements RepositorioMovimiento {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="movimiento", value="crear")
    private static String sqlCrear;

    public RepositorioMovimientoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Movimiento movimiento) {

        return this.customNamedParameterJdbcTemplate.crear(movimiento, sqlCrear);
    }


}
