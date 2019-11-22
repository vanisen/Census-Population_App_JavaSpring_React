package com.org.census.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * this class create the MySQL DataSource
 */
@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class DbConfig {

  @Value("${app.datasource.driverClassName}") String driverClassName;
  @Value("${app.datasource.url}") String url;
  @Value("${app.datasource.username}") String username;
  @Value("${app.datasource.password}") String password;

  @Bean(name = "dataSource")
  public DataSource getDataSource() {
    DataSource dataSource = DataSourceBuilder
        .create()
        .username(username)
        .password(password)
        .url(url)
        .driverClassName(driverClassName)
        .build();
    return dataSource;
  }

}
