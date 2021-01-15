package com.geo.owl.common.config;

import lombok.val;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class HibernateConfig {

    private static final String PERSISTENCE_UNIT = "owl";
    private String[] packages = {
            "com.geo.owl.building.model",
            "com.geo.owl.common.model"
    };

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        val entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setPackagesToScan(packages);
        entityManager.setDataSource(dataSource);
        entityManager.setJpaProperties(hibernateProperties());
        entityManager.setJpaDialect(new HibernateJpaDialect());
        entityManager.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManager.setPersistenceUnitName(PERSISTENCE_UNIT);
        return entityManager;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager();
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    private Properties hibernateProperties() {
        val properties = new Properties();
        properties.put("hibernate.hbm2ddl.auto", "validate");
        properties.put(
                "datasource.master.properties.hibernate.dialect",
                "org.hibernate.dialect.H2Dialect"
        );
        properties.put("hibernate.physical_naming_strategy", SpringNamingStrategy.class.getName());
        return properties;
    }
}
