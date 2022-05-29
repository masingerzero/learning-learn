package com.manning.sbip.main.ch02;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

//@SpringBootApplication
public class CourseTrackerApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(CourseTrackerApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Executing command Line Runner as implementation of main app class ");
        for (String arg : args) {
            System.out.println(arg);
        }
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            Arrays.stream(args)
                            .forEach(System.out::println);

            System.out.println("Command line runner from bean definition");
        };
    }
}
