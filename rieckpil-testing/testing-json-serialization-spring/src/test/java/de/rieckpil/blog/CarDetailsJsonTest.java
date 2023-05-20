package de.rieckpil.blog;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;

import java.io.IOException;

@JsonTest
public class CarDetailsJsonTest {

    @Autowired
    JacksonTester<CarDetails> carDetailsJacksonTester;

    @Test
    public void carDetailsSerializerTest() throws IOException {
        CarDetails carDetails = new CarDetails("Audi", "A3", "gray");
        JsonContent<CarDetails> result = carDetailsJacksonTester.write(carDetails);
        System.out.println(result.getJson());
        Assertions.assertThat(result).extractingJsonPathStringValue("$.type").contains("Audi", "A3", "gray");
    }
}
