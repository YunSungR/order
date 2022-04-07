package com.spring_order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.spring_order"})
@MapperScan(basePackages= {"com.spring_order.dao"})
public class SpringOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringOrderApplication.class, args);
	}

}
