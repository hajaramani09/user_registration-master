package codingtechniques;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.config.BootstrapMode;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableTransactionManagement
@EnableWebMvc
@EnableJpaRepositories(bootstrapMode = BootstrapMode.DEFAULT)
@ComponentScan(basePackages = { "main.java.codingtechniques" })
@SpringBootApplication(scanBasePackages = "main.java.codingtechniques", exclude = {
		HibernateJpaAutoConfiguration.class })
@EnableAutoConfiguration(exclude = { SecurityAutoConfiguration.class })
// @EnableAutoConfiguration()

public class UserRegistrationApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {

		SpringApplication.run(UserRegistrationApplication.class, args);


	}

}
