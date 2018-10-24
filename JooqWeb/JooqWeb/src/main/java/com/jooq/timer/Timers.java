package com.jooq.timer;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.ScheduleExpression;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;
import javax.ejb.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ihsa
 */
@Singleton
@Startup
public class Timers {

    private static final Logger LOGGER = LoggerFactory.getLogger(Timers.class);

    private @Resource
    TimerService timerService;

    @PostConstruct
    public void initTimers() {
        LOGGER.info("------------------->Iniciando timers<--------------------------");
        cancelarTimers();
        inicializarTimers();
    }

    private void cancelarTimers() {
        if (timerService.getTimers() != null) {
            for (Timer timer : timerService.getTimers()) {
                timer.cancel();
            }
        }
    }

    private void inicializarTimers() {
        final List<TimersEnum> listaTimers = Arrays.asList(TimersEnum.values());

        for (TimersEnum timerEnum : listaTimers) {
            LOGGER.info("Registro de timer : [{}] - H {} M {} S{}", timerEnum.toString(), timerEnum.getHora(), timerEnum.getMinuto(), timerEnum.getSegundo());
            timerService.createCalendarTimer(
                    new ScheduleExpression()
                            .hour(timerEnum.getHora())
                            .minute(timerEnum.getMinuto())
                            .second(timerEnum.getSegundo()),
                    new TimerConfig(timerEnum, true));
        }
    }

    @Timeout
    public void ejbTimeout(Timer timer) {
        LOGGER.info("Timers.ejbTimeout()");
        LOGGER.info("Ejecutando Timer: " + new Date());

    }
}
