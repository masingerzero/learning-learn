package de.rieckpil.blog.jsonplaceholder;

import de.rieckpil.blog.User;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Component
public class JsonPlaceholderClient {

    private final RestTemplate restTemplate;
    public JsonPlaceholderClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.rootUri("https://jsonplaceholder.typicode.com")
                .setConnectTimeout(Duration.ofSeconds(2))
                .setReadTimeout(Duration.ofSeconds(2))
                .build();
    }

    public UserPh getSingleUser(Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        return this.restTemplate
                .exchange("/users/{id}", HttpMethod.GET, requestEntity, UserPh.class, id)
                .getBody();
    }



}
