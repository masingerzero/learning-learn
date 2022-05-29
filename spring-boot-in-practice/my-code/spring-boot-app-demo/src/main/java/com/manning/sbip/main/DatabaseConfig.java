package com.manning.sbip.ch01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Component;

import javax.crypto.spec.PSource;

@Configuration
@PropertySource("classpath:dbConfig.properties")
public class DatabaseConfig {
    @Autowired
    Environment env;

    public DatabaseConfig() {
        System.out.println();
    }

    @Override
    public String toString() {

        return "user=" + env.getProperty("user") + "   " + "password=" + env.getProperty("password");
    }


}
