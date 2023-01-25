package com.in28minutes.microservices.limitsservice.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("limits-service")
@Component
@Data
public class Configuration {
    private int minimum;
    private int maximum;

    private String source;
}
