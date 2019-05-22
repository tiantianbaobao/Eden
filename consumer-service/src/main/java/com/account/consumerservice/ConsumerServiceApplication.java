package com.account.consumerservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.account.consumerservice.servlet")
//@MapperScan(basePackages = "com.account.consumerservice.core.dao")
public class ConsumerServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(ConsumerServiceApplication.class, args);
	}

}
