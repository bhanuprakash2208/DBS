package com.dbs.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringJBossDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJBossDemoApplication.class, args);
	}
	
//	@RestController("\test")
//	public String get()
//	{
//		return "Hello";
//	}

}
