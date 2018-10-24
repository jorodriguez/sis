/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jooq.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author jorodriguez
 */
@Getter @Setter @ToString
public class LecturaCmlDto {
    
       private String cml;
       private LocalDateTime fechaHoraLecturaCorte;
       private BigDecimal condensadoCml;
       private BigDecimal aguaCml;
       private BigDecimal liquidoCml;
}
