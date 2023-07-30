package de.rieckpil.blog;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import org.apache.http.impl.conn.Wire;
import org.eclipse.jetty.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TodoControllerJUnit5ExtensionIT {
    @RegisterExtension
    static WireMockExtension wireMockServer = WireMockExtension.newInstance()
            .options(wireMockConfig().dynamicPort())
            .build();

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("todo_base_url", wireMockServer::baseUrl);
    }

    @Autowired
    WebTestClient webTestClient;


    @Test
    void basicWireMockExample() {
        wireMockServer.stubFor(get("/todos")
                .willReturn(aResponse()
                        .withHeader("Content-Type", APPLICATION_JSON_VALUE)
                        .withBody("[]")));
        this.webTestClient
                .get()
                .uri("/api/todos")
                .exchange()
                .expectStatus().isOk()
                .expectBody().jsonPath("$.length()").isEqualTo(0);
    }

    @Test
    void testGetAllTodosShouldReturnDataFromClient() {
        wireMockServer.stubFor(get("/todos")
                .willReturn(aResponse()
                        .withHeader("Content-Type", APPLICATION_JSON_VALUE)
                        .withBody("[{\"userId\": 1,\"id\": 1,\"title\": \"Learn Spring Boot 3.0\", \"completed\": false}," +
                                "{\"userId\": 1,\"id\": 2,\"title\": \"Learn WireMock\", \"completed\": true}]"))
        );

        this.webTestClient
                .get()
                .uri("/api/todos")
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody()
                .jsonPath("$[0].title")
                .isEqualTo("Learn Spring Boot 3.0")
                .jsonPath("$.length()")
                .isEqualTo(2);

    }

    @Test
    void testGetAllTodosShouldPropagateErrorMessageFromClient() {
        wireMockServer.stubFor(WireMock.get("/todos")
                .willReturn(WireMock.aResponse()
                        .withStatus(403)));

        this.webTestClient
                .get()
                .uri("/api/todos")
                .exchange()
                .expectStatus()
                .isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR_500);
    }

    @BeforeEach
    void wireMockReset() {
        wireMockServer.resetAll();
    }
}
