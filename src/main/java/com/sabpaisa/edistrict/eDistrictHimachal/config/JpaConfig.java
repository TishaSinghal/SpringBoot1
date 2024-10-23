
package com.sabpaisa.edistrict.eDistrictHimachal.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;
import java.util.Properties; 


@Configuration
@EnableJpaRepositories(basePackages = "com.sabpaisa.edistrict.eDistrictHimachal.repository")
@EntityScan(basePackages = "com.sabpaisa.edistrict.eDistrictHimachal.model")
@EnableTransactionManagement
public class JpaConfig {

	
	 @Bean
	    public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	        dataSource.setUrl("jdbc:mysql://localhost:3306/edistrict_user");
	        dataSource.setUsername("root");
	        dataSource.setPassword("password");
	        return dataSource;
	    }
	 
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setPackagesToScan("com.sabpaisa.edistrict.eDistrictHimachal.model");
        

        // Set Hibernate properties
        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");  // Set the dialect explicitly
        jpaProperties.put("hibernate.hbm2ddl.auto", "update");  // Automatically creates/updates schema
        jpaProperties.put("hibernate.show_sql", "true"); 
        em.setJpaProperties(jpaProperties);
        
        
        return em;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
