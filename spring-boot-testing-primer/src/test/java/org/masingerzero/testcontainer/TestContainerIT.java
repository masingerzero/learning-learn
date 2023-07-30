package org.masingerzero.testcontainer;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.testcontainers.utility.DockerImageName.parse;

@Testcontainers
@SpringBootTest
public class TestContainerIT {

    @Container
    static final PostgreSQLContainer<?> postgreSQLContainer =
            new PostgreSQLContainer<>(parse("postgres:13"))
                    .withDatabaseName("test")
                    .withUsername("duke")
                    .withPassword("s3cret");

    @Test
    void contextLoaded() {
        System.out.println("Context loaded!!!");

    }
}
