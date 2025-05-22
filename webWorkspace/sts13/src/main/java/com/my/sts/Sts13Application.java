package com.my.sts;

import java.sql.Driver;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
@MapperScan("com.my.sts.model")
public class Sts13Application {

	public static void main(String[] args) {
		SpringApplication.run(Sts13Application.class, args);
	}
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource;
		dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName(Driver.class.getCanonicalName());
		dataSource.setUrl("jdbc:mysql://24f104c2b77f:3306/xe");
		dataSource.setUsername("scott");
		dataSource.setPassword("tiger");
		
		return dataSource;
	}
}
