package com.sky.shardingdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class MyConfig {

    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate();
    }
}
