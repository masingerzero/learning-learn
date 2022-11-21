package com.in28minuties.rest.webservices.restfulwebservices;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.in28minuties.rest.webservices.restfulwebservices.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class RestfulWebServicesApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void contextLoads() {
	}

	@Test
	void testObtainAllUsers() throws Exception {
		mvc.perform(get("/users"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json("[{\"id\":1,\"name\":\"Adam\",\"birthDate\":\"1992-10-26\"},{\"id\":2,\"name\":\"Eve\",\"birthDate\":\"1997-10-26\"},{\"id\":3,\"name\":\"Jim\",\"birthDate\":\"2002-10-26\"}]"));
	}


	@Test
	void testObtainOneUser() throws Exception {
		mvc.perform(get("/users/1"))
				.andExpect(status().isOk())
				.andExpect(content().string("{\"id\":1,\"name\":\"Adam\",\"birthDate\":\"1992-10-26\"}"));
	}

	@Test
	void testAddUser() throws Exception {

		String location = mvc.perform(post("/users")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"name\":\"Yesus\",\"birthDate\":\"1992-10-26\"}"))
				.andExpect(status().isCreated())
				.andDo(print())
				.andReturn().getResponse().getHeader("location")
				;


		mvc.perform(get(location))
				.andExpect(status().isOk())
				.andExpect(content().string("{\"id\":4,\"name\":\"Yesus\",\"birthDate\":\"1992-10-26\"}"));
	}



	@Test
	void testMapper() throws Exception {
		User user  = new User("coco", LocalDate.now());
		user.setName("coco");
		user.setBirthDate(LocalDate.now());

		String s = mapper.writeValueAsString(user);
		mvc.perform(post("/users")
				.contentType(MediaType.APPLICATION_JSON)
				.content(s));
		String contentAsString = mvc.perform(get("/users/4"))
				.andReturn()
				.getResponse()
				.getContentAsString();

		User user1 = mapper.readValue(contentAsString, User.class);
		Assertions.assertAll(
				() -> Assertions.assertEquals(4, user1.getId()),
				() -> Assertions.assertEquals("coco", user.getName()),
				() -> Assertions.assertEquals(LocalDate.now(), user1.getBirthDate())
		);


//		System.out.println(s1);
	}


	@Test
	void testUserNotFound() throws Exception {
		mvc.perform(get("/users/10"))
				.andDo(print())
				.andExpect(status().isNotFound());
	}

	@Test
	void testDeleteUser() throws Exception {
		mvc.perform(delete("/users/2"))
				.andExpect(status().isOk());
		mvc.perform(get("/users/2"))
				.andExpect(status().isNotFound());

	}

	@Test
	void test201statusCodeFail() throws Exception {
		User user  = new User("coco", LocalDate.now());

		String s = mapper.writeValueAsString(user);
		ResultActions resultActions = mvc.perform(post("/userstest")
						.contentType(MediaType.APPLICATION_JSON)
						.content(s))
				.andExpect(status().isCreated())
				.andDo(print());
		String contentAsString = mvc.perform(get("/users/4"))
				.andReturn()
				.getResponse()
				.getContentAsString();

		User user1 = mapper.readValue(contentAsString, User.class);

		Assertions.assertAll(
				() -> Assertions.assertEquals(4, user1.getId()),
				() -> Assertions.assertEquals("coco", user.getName()),
				() -> Assertions.assertEquals(LocalDate.now(), user1.getBirthDate())
		);
	}

	@Test
	public void testResponseRepresentationMimeTypeWithAcceptHeader() throws Exception {
		mvc.perform(get("/users/1").accept(MediaType.APPLICATION_XML))
				.andExpect(content().contentType("application/xml;charset=UTF-8"))
				.andDo(print());
	}

}
