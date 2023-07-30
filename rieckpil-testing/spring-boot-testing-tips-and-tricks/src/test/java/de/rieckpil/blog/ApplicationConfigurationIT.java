package de.rieckpil.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = {
                "my.custom.property=inlined",

        }
)
@ActiveProfiles("integration-test")
public class ApplicationConfigurationIT {

    @Autowired
    private Environment environment;

    @Test
    void shouldPrintConfigurationValues(@Value("${foo.bar.baz}") String fooBarBaz) {
        System.out.println(environment.getProperty("my.custom.property"));
        System.out.println(fooBarBaz);

    }

}
