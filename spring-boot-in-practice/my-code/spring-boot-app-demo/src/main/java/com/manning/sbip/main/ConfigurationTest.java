package com.manning.sbip.ch01;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class ConfigurationTest {
    @Autowired
    Environment env;

    @Bean
    public Foo foo() {
//        String appTimeout = env.getProperty("app.timeout");
//        System.out.println(appTimeout);

        return new Foo();
    }
}
