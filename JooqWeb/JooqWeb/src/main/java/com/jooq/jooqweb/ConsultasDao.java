/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jooq.jooqweb;

import com.jooq.dto.LecturaCmlDto;
import java.util.Date;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import org.jooq.DSLContext;
import org.jooq.exception.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jorodriguez
 */
@Dependent
public class ConsultasDao {
 
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsultasDao.class);
     
    @Inject
    private DSLContext dslContext;
    
     public LecturaCmlDto obtenerLecturaCorteCml(Date fechaCorte) {
        LOGGER.debug("fecha corte {}", fechaCorte);
         System.out.println("fecha "+fechaCorte);
        LecturaCmlDto retorno = null;
        try {
            retorno = dslContext.fetchOne(
                    "select *  from  es_pres.cop_historial_totales_campo\n" +
                    "    where fecha_corte = ?",
                    new java.sql.Date(fechaCorte.getTime()))
                    .into(LecturaCmlDto.class);
            System.out.println(""+retorno.toString());
            LOGGER.debug("retorno {}",retorno.toString());

        } catch (DataAccessException e) {
            LOGGER.error("{}", e);
            System.out.println(""+e);
        }
        return retorno;
    }

}
