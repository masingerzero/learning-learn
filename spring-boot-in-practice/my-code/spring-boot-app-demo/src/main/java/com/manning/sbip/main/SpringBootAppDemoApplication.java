package com.manning.sbip.main;

import com.manning.sbip.main.ch02.AppProperties;
import com.manning.sbip.main.ch02.AppService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

//@SpringBootApplication
//@EnableConfigurationProperties(AppProperties.class)
//@ConfigurationPropertiesScan("com.manning.sbip.main.ch02")
public class SpringBootAppDemoApplication {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
//		SpringApplication.run(SpringBootAppDemoApplication.class, args);
//		Properties properties = new Properties();
//		properties.setProperty("spring.config.on-not-found", "ignore");
//		SpringApplication springApplication = new SpringApplication(SpringBootAppDemoApplication.class);
//		springApplication.setDefaultProperties(properties);
//	springApplication.run(args);
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootAppDemoApplication.class, args);
//		AppService service = applicationContext.getBean(AppService.class);
//		AppProperties appProperties = service.getAppProperties();
//
//		System.out.println(appProperties);


//		MyConfiguration.ServiceB bService = applicationContext.getBean(MyConfiguration.ServiceB.class);
//		LOGGER.info(bService.getServiceA().toString());
//
//		bService = applicationContext.getBean(MyConfiguration.ServiceB.class);
//		LOGGER.info(bService.getServiceA().toString());


	}

	@Order(0)
	@Bean
	public CommandLineRunner commandLineRunner0() {
		return args -> {
			System.out.println("command line runner order0");
		};
	}

	@Order(1)
	@Bean
	public CommandLineRunner commandLineRunner1() {
		return args -> {
			System.out.println("command line runner order1");
		};
	}

	@Order(2)
	@Bean
	@Autowired
	public CommandLineRunner commandLineRunner2(ApplicationContext applicationContext) {
		return args -> {
			Arrays.stream(applicationContext.getBeanDefinitionNames())
							.forEach(System.out::println);
			System.out.println("command line runner order2");
		};
	}





}
