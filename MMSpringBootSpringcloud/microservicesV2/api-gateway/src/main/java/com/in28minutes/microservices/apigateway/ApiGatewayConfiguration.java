package com.in28minutes.microservices.apigateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.route.builder.RouteLocatorDsl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    Logger logger = LoggerFactory.getLogger(ApiGatewayConfiguration.class);
    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/get")
                        .filters(f -> f
                                .addRequestHeader("MyHeader", "MyURI")
                                .addRequestParameter("Param", "Value"))
                        .uri("http://httpbin.org/80"))
                .route(p -> p.path("/currency-exchange/**")
                        .uri("lb://currency-exchange"))
                .route(p -> p.path("/currency-conversion/**")
                        .uri("lb://currency-conversion"))
                .route(p -> p.path("/currency-conversion/feign/**")
                        .uri("lb://currency-conversion"))
                .route(p -> p.path("/currency-conversion-new/**")
                        .filters(f -> f.rewritePath(
                                "/currency-conversion-new/(?<segment>.*)",
                                "/currency-conversion/feign/${segment}"))
                        .uri("lb://currency-conversion"))
                .build();
    }

//    @Bean
//    public GlobalFilter loggingFilter() {
//        return (exchange, chain) -> {
//            logger.info("Path of the request received -> {}", exchange.getRequest().getPath());
//            return chain
//                    .filter(exchange);
//        };
//    }
}
