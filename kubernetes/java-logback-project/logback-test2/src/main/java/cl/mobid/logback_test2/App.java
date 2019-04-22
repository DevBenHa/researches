package cl.mobid.logback_test2;

//import java.util.Properties;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

//import cl.mobid.logtest.util.Constant;

@SpringBootApplication
public class App extends SpringBootServletInitializer {

	@Bean
	InitBean initBean() {
        return new InitBean();
    }
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder) {
		
		springApplicationBuilder.sources(App.class);
		return springApplicationBuilder;
    }
	
	public static void main(String[] args) {
		SpringApplicationBuilder springApplicationBuilder = new SpringApplicationBuilder(App.class);
		springApplicationBuilder.sources(App.class);
        springApplicationBuilder.run(args);
	}


}
