package com.manning.sbip.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Component
//@Configuration
public class ConfigurationProxyCGLIBTest {
    @Bean
    public ServiceA aService(){
        return new ServiceA();
    }

    @Bean
    public ServiceB bService(){
        return new ServiceB(aService());
    }

    class ServiceA {
        public ServiceA() {
            System.out.println("Service A instance!!!!");
            System.out.println(this);
        }

    }

    class ServiceB {
        ServiceA serviceA;
        public ServiceB(ServiceA aService) {
            serviceA = aService;
        }

        public ServiceA getServiceA() {
            return serviceA;
        }
    }









}
