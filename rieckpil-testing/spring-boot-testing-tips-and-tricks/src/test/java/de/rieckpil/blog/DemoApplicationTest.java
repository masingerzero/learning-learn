package de.rieckpil.blog;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoApplicationTest {
    @LocalServerPort
    private Integer port;
    @Test
    void contextLoad() {
        System.out.println("port = " + port);
        System.out.println();
    }

    @Test
    void foo() {
        System.out.println("DemoApplicationTest.foo");
    }

    @Test
    void bar() {
        System.out.println("DemoApplicationTest.bar");
    }
}
