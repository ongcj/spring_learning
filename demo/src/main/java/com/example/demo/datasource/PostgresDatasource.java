package com.example.demo.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // this class served as a configuration
public class PostgresDatasource {
    @Bean // instantiate this datasource as a bean
    @ConfigurationProperties("app.datasource") // create configuration file that will contain url name password
    public HikariDataSource hikariDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }
}
