package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.demo.Dao")
public class DemoApplication {

	//测试111
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
