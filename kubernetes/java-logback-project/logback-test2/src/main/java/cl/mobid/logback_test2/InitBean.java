package cl.mobid.logback_test2;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class InitBean {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
    @PostConstruct
    public void init() {
    	log.info("Aplicacion inicializada");
    }

    @PreDestroy
    public void destroy() {
    	log.info("Aplicacion Detenida");
    }
}
