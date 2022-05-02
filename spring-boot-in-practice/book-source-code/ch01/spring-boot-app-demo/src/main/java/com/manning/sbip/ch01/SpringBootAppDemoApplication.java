package com.manning.sbip.ch01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootAppDemoApplication {

	public static void main(String[] args) {
//		SpringApplication springApplication = new SpringApplication(SpringBootAppDemoApplication.class);
//		springApplication.addListeners(new ApplicationStartingEventListener());
//		springApplication.run(args);
//
		SpringApplication.run(SpringBootAppDemoApplication.class, args);

	}

}
