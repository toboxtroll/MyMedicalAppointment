package com.mymedicalappointment.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConecctionPostgres {
    Properties config = new Properties();
    InputStream configInput = null;
    private static JdbcTemplate jdbcTemplate;

    private ConecctionPostgres() {
        try{
            configInput = new FileInputStream("application.properties");
            config.load(configInput);
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setUrl(config.getProperty("jdbc.url"));
            dataSource.setUsername(config.getProperty("jdbc.username"));
            dataSource.setPassword(config.getProperty("jdbc.password"));

            jdbcTemplate = new JdbcTemplate(dataSource);
        } catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public synchronized static JdbcTemplate getJdbcTemplate() {
        if (jdbcTemplate == null) new ConecctionPostgres();
        return jdbcTemplate;
    }

}
