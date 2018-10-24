/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jooq.mbeans;

import com.jooq.jooqweb.ConsultasDao;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jorodriguez
 */
@ManagedBean
@ViewScoped
public class BeanPrueba {
   
    private static final Logger LOGGER = LoggerFactory.getLogger(BeanPrueba.class);
    
    @Inject
    private ConsultasDao consultas;
    
    public BeanPrueba() {
    }
    
    
    @PostConstruct    
    private void inciar(){
        System.out.println("Probando");
        LOGGER.debug("Probando");        
    }
    
    public void ejecutarConsulta(ActionEvent e){
        System.out.println("ejecucion de consulta");
        consultas.obtenerLecturaCorteCml(new Date());
    }
    
}
