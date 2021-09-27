package com.ceiba.movimiento.consulta;

import com.ceiba.ComandoRespuesta;
import com.ceiba.movimiento.comando.ComandoMovimiento;
import com.ceiba.movimiento.puerto.dao.DaoMovimiento;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class ManejadorObtenerGananciaMovimientos {

    private final DaoMovimiento daoMovimiento;

    public ManejadorObtenerGananciaMovimientos(DaoMovimiento daoMovimiento){
        this.daoMovimiento = daoMovimiento;
    }

    public ComandoRespuesta<Float> ejecutar(ComandoMovimiento comandoMovimiento) {

        return new ComandoRespuesta<>(this.daoMovimiento.obtenerGanancia(obtenerFechaInicial(comandoMovimiento.getFechaVenta()),obtenerFechaFinal(comandoMovimiento.getFechaVenta())));
    }

    private Date obtenerFechaInicial(Date date){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);

        return calendar.getTime();

    }

    private Date obtenerFechaFinal(Date date){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY,23);
        calendar.set(Calendar.MINUTE,59);
        calendar.set(Calendar.SECOND,59);
        calendar.set(Calendar.MILLISECOND,59);

        return calendar.getTime();
    }


}
