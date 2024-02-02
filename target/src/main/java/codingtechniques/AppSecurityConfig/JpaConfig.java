package codingtechniques.AppSecurityConfig;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class JpaConfig {

    
    @Bean
public LocalContainerEntityManagerFactoryBean entityManagerFactory(
  @Qualifier("dataSource") DataSource dataSource) {
 LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
 em.setDataSource(dataSource);
 em.setPackagesToScan("main.java.codingtechniques.model"); // Adjust the package
 em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
 return em;
}

     @Bean
 public JpaTransactionManager transactionManager(
   @Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
  JpaTransactionManager transactionManager = new JpaTransactionManager();
  transactionManager.setEntityManagerFactory(entityManagerFactory);
  return transactionManager;
 }

}
