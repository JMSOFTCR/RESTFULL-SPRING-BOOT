package com.example.demo;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

@Configuration
public class util {
	   @Bean

	    public DataSource datasource() {

	        return DataSourceBuilder.create()

	          .driverClassName("com.mysql.cj.jdbc.Driver")

	          .url("jdbc:mysql://localhost:3306/restspring?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC")

	          .username("root")

	          .password("")

	          .build(); 

	    }

	

}
