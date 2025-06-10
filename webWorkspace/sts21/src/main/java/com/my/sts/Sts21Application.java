package com.my.sts;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
public class Sts21Application{

	public static void main(String[] args) {
		SpringApplication.run(Sts21Application.class, args);
	}

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource;
		dataSource=new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:33306/xe");
		dataSource.setUsername("root");
		dataSource.setPassword("mysql");
		return dataSource;
	}

}
