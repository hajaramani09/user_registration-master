package codingtechniques;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;

public class WebServerFactory implements
                WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

        @Override
        public void customize(ConfigurableServletWebServerFactory factory) {

                factory.setPort(8181);
        }
}
