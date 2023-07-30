package de.rieckpil.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.web.server.LocalManagementPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
properties = {
        "server.port=8042",
        "management.server.port=9042"
})
public class ApplicationIT {
    @Autowired
    WebTestClient webTestClient;

    @LocalServerPort
    Integer port;

    @LocalManagementPort
    Integer managementPort;

    @Test
    void loadContext() {
        System.out.println(port);
        System.out.println(managementPort);
    }

    @Test
    void httpClientExample() {
        webTestClient
                .get()
                .uri("/api/customers")
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }


    @Test
    void httpClientExampleManagement() {
        webTestClient
                .get()
                .uri("/actuator")
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody();


    }

}
