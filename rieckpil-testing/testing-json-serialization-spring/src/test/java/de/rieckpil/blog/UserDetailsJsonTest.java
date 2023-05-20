package de.rieckpil.blog;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.boot.test.json.JsonContentAssert;

import java.io.IOException;
import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@JsonTest
public class UserDetailsJsonTest {
    @Autowired
    JacksonTester<UserDetails> json;
    
    @Test
    public void testUserDetailsSerialization() throws IOException {

        UserDetails userDetails = new UserDetails(1L, "Duke", "Java",
                LocalDate.of(1995, 1, 1), true);

        JsonContent<UserDetails> result = this.json.write(userDetails);

        assertThat(result).hasJsonPathStringValue("$.firstname");
        assertThat(result).extractingJsonPathStringValue("$.firstname").isEqualTo("Duke");
        assertThat(result).extractingJsonPathStringValue("$.lastname").isEqualTo("Java");
        assertThat(result).extractingJsonPathStringValue("$.dateofbirth").isEqualTo("01.01.1995");
        assertThat(result).doesNotHaveJsonPath("$.enabled");
    }

    @Test
    public void testUserDetailsDeserialization() throws IOException {
        String jsonContent = "{\"firstname\":\"Mike\", \"lastname\": \"Meyer\"," +
                " \"dateofbirth\":\"15.05.1990\"," +
                " \"id\": 42, \"enabled\": true}";
        UserDetails userDetails = json.parse(jsonContent).getObject();
        Assertions.assertEquals("Mike", userDetails.getFirstName());
        Assertions.assertEquals("Meyer", userDetails.getLastName());
        Assertions.assertEquals(LocalDate.of(1990, 5, 15), userDetails.getDateOfBirth());
        Assertions.assertTrue(userDetails.isEnabled());

    }
}
