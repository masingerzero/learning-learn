package de.rieckpil.blog;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.rieckpil.blog.jsonplaceholder.JsonPlaceholderClient;
import de.rieckpil.blog.jsonplaceholder.UserPh;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.client.response.MockRestResponseCreators;
import org.springframework.web.client.HttpServerErrorException;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.*;

@RestClientTest(JsonPlaceholderClient.class)
public class JsonPlaceHolderClientTest {
    @Autowired
    private JsonPlaceholderClient jsonPlaceholderClient;

    @Autowired
    private MockRestServiceServer mockRestServiceServer;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void dependenciesArePresentTest() {
        Assertions.assertNotNull(jsonPlaceholderClient);
        Assertions.assertNotNull(mockRestServiceServer);
        Assertions.assertNotNull(objectMapper);
    }

    @Test
    public void responseOkTest() {
        String userJson = """
                {
                    "id": 1,
                    "name": "Leanne Graham",
                    "username": "Bret",
                    "email": "Sincere@april.biz",
                    "address": {
                      "street": "Kulas Light",
                      "suite": "Apt. 556",
                      "city": "Gwenborough",
                      "zipcode": "92998-3874",
                      "geo": {
                        "lat": "-37.3159",
                        "lng": "81.1496"
                      }
                    },
                    "phone": "1-770-736-8031 x56442",
                    "website": "hildegard.org",
                    "company": {
                      "name": "Romaguera-Crona",
                      "catchPhrase": "Multi-layered client-server neural-net",
                      "bs": "harness real-time e-markets"
                    }
                  }
                """;
        this.mockRestServiceServer.expect(requestTo("/users/1"))
                .andRespond(withSuccess(userJson, APPLICATION_JSON));

        UserPh singleUser = this.jsonPlaceholderClient.getSingleUser(1L);
        Assertions.assertNotNull(singleUser);
    }

    @Test
    public void serviceUnavailableResponseErrorTest() {
        this.mockRestServiceServer.expect(requestTo("/users/1"))
                .andRespond(withStatus(HttpStatus.SERVICE_UNAVAILABLE));
        HttpServerErrorException.ServiceUnavailable serviceUnavailable =
                Assertions.assertThrows(
                        HttpServerErrorException.ServiceUnavailable.class,
                        () -> this.jsonPlaceholderClient.getSingleUser(1L),
                        () -> "Error 503");

    }


}
