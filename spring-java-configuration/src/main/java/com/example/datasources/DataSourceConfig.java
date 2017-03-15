package com.example.datasources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;

/**
 * Created by anil on 3/7/17.
 */
@Configuration
public class DataSourceConfig {

    @Bean
    @Profile("dev")
    public DataSource dataSourceForDev() {
        return new DriverManagerDataSource();
    }

    @Bean
    @Profile("prod")
    public DataSource dataSourceForProd() {
        return new DriverManagerDataSource();
    }

    @Bean
    @Profile("default")
    public DataSource defaultDataSource() {
        return new DriverManagerDataSource();
    }
}
