package de.rieckpil.blog;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextClosedEvent;

import java.util.Map;

public class WireMockInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        WireMockServer wireMockServer = new WireMockServer(new WireMockConfiguration().dynamicPort());
        wireMockServer.start();

        applicationContext
                .getBeanFactory()
                .registerSingleton("wireMockServer", wireMockServer);

        applicationContext.addApplicationListener(event -> {
            if (event instanceof ContextClosedEvent) {
                wireMockServer.stop();
            }
        });

        TestPropertyValues
                .of(Map.of("todo_base_url", "http://localhost:" + wireMockServer.port()))
                .applyTo(applicationContext);
    }
}
