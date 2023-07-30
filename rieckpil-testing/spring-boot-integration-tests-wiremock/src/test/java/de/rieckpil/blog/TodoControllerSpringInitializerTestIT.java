package de.rieckpil.blog;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = {WireMockInitializer.class})
public class TodoControllerSpringInitializerTestIT {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private WireMockServer wireMockServer;

    @Test
    void basicWireMockExample() {
        Assertions.assertEquals(0, wireMockServer.getStubMappings().size());
        wireMockServer.stubFor(WireMock.get("/todos")
                .willReturn(WireMock.aResponse()
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                        .withBody("[]")));
        this.webTestClient
                .get()
                .uri("/api/todos")
                .exchange()
                .expectStatus().isOk()
                .expectBody().jsonPath("$.length()").isEqualTo(0);
    }

    @Test
    void basicWireMockExampleTwo() {
        Assertions.assertEquals(0, wireMockServer.getStubMappings().size());
        wireMockServer.stubFor(WireMock.get("/todos")
                .willReturn(WireMock.aResponse()
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                        .withBody("[]")));
        this.webTestClient
                .get()
                .uri("/api/todos")
                .exchange()
                .expectStatus().isOk()
                .expectBody().jsonPath("$.length()").isEqualTo(0);
    }

    @AfterEach
    void cleanWireMock() {
        wireMockServer.resetAll();
    }


}
