
package com.jooq.timer;


public enum TimersEnum {
    
    ACTUALIZACION("00","01","00");   

    private final String hora;    
    private final String minuto;    
    private final String segundo;    
    
    
    private TimersEnum(String hora,String minuto,String segundo) {
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }
        
    public String getHora() {
        return hora;
    }

    public String getMinuto() {
        return minuto;
    }

    public String getSegundo(){
        return this.segundo;
    }
    
}
