package com.airtel;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.airtel.starter.controller.HelloController;
import com.airtel.starter.model.Starter;
import com.airtel.starter.service.StarterService;



/**
 * @author B0200130
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
public class HelloControllerTest {

	private MockMvc mockMvc;

	@Mock
	private StarterService starterService;

	@InjectMocks
	private HelloController helloController;

	@Before
	public void setup() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(helloController).build();
	}

	@Test
	public void name() throws Exception {
		// mockMvc.perform(MockMvcRequestBuilders.get("/starter/hello")).andExpect(MockMvcResultMatchers.status().isOk())
		// .andExpect(MockMvcResultMatchers.content().string("Hi"));
		Mockito.when(starterService.hello()).thenReturn("Hi");

		mockMvc.perform(get("/starter/hello")).andExpect(status().isOk()).andExpect(content().string("Hi"));

		Mockito.verify(starterService).hello();
	}

	@Test
	public void addStarterTest() throws Exception {

		String json = "{\r\n" + "  \"desc\": \"hello to me !!\",\r\n" + "  \"id\": \"1\",\r\n"
				+ "  \"name\": \"hello\"\r\n" + "}";
		mockMvc.perform(post("/starter").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isOk());
//		.andExpect(jsonPath("$.*", Matchers.hasSize(1)));

		// .andExpect(jsonPath(expression, matcher))
	}

	@Test
	public void getStarterTest() throws Exception {

		Mockito.when(starterService.getAllStarter()).thenReturn(new ArrayList<>(
				Arrays.asList(new Starter("1", "hello", "Come In!!"), new Starter("2", "Bye", "Get Lost!!"))));
		
		mockMvc.perform(get("/starter").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
		.andExpect(jsonPath("$.*", Matchers.hasSize(2)));
//				.andExpect(jsonPath("$.id", Matchers.is("1")));

		// .andExpect(jsonPath(expression, matcher))
		
		Mockito.verify(starterService).getAllStarter();
	}
}
