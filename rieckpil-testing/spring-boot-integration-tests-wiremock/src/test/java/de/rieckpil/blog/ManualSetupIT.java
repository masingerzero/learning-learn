package de.rieckpil.blog;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class ManualSetupIT {
    @Autowired
    WebTestClient webTestClient;

    private static WireMockServer wireMockServer;

    @DynamicPropertySource
    static void overrideWebClientBaseUrl(DynamicPropertyRegistry registry) {
        registry.add("todo_base_url", wireMockServer::baseUrl);

    }

    @BeforeAll
    static void startAndConfigureWiremockServer() {
        wireMockServer = new WireMockServer(WireMockConfiguration.wireMockConfig().dynamicPort());
        wireMockServer.start();
    }

    @Test
    void basicWireMockExample() {
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
    void wireMockRequestMatching() {

        wireMockServer.stubFor(WireMock.get(WireMock.urlEqualTo("/users"))
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

    @AfterAll
    static void cleanUp() {
        wireMockServer.stop();
    }
}
