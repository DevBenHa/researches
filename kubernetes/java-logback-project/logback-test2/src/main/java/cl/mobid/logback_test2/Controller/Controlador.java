package cl.mobid.logback_test2.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/")
public class Controlador {
	private Logger log = LoggerFactory.getLogger(Controlador.class);
	@RequestMapping(value = "/ping", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String ping() {
		try {
			log.debug("This is a debug message");
			log.info("This is an info message");
			log.warn("This is a warn message");
			log.error("This is an error message");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return "PRUEBA";
	}
}
