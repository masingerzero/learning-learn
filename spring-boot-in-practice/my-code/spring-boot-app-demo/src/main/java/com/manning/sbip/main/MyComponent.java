package com.manning.sbip.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

//@Component
//@Configuration
public class MyComponent {
    @Autowired
    Environment env;

    public MyComponent() {
        String port = env.getProperty("port");
        System.out.println(port);
        String property = env.getProperty("foo.property");
        System.out.println(property);
    }

}
