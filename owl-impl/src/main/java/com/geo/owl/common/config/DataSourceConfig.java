package com.geo.owl.common.config;

import lombok.val;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration(proxyBeanMethods = false)
@EnableJpaRepositories(basePackages = "com.geo.owl")
public class DataSourceConfig {

    @Value("${datasource.master.url}")
    private String url;
    @Value("${datasource.master.driverClassName}")
    private String driverClassName;
    @Value("${datasource.master.username}")
    private String userName;
    @Value("${datasource.master.password}")
    private String password;
    @Value("${datasource.master.schema}")
    private String schema;


    @Bean
    @Primary
    public DataSource dataSource() {
        val dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setSchema(schema);
        doMigration(dataSource);
        return dataSource;
    }

    private void doMigration(DataSource dataSource){
        Flyway flyway = Flyway.configure()
                .dataSource(dataSource)
                .load();
        flyway.migrate();
    }
}
