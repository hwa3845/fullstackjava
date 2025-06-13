package com.my.sts;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@MapperScan("com.my.sts.model")
@SpringBootApplication
public class Sts32Application {

	public static void main(String[] args) {
		SpringApplication.run(Sts32Application.class, args);
	}

	@Bean
	SqlSessionFactory sqlSessionFactory(DataSource dataSource) {
		try {
			SqlSessionFactoryBean factory=new SqlSessionFactoryBean();
			factory.setDataSource(dataSource);
			return factory.getObject();
		} catch (Exception e) {
			return null;
		}
	}
	
	@Bean
	SqlSessionTemplate template(DataSource dataSource) {
		return new SqlSessionTemplate(sqlSessionFactory(dataSource));
	}
}
