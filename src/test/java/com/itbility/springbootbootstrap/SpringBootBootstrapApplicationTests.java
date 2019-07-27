package com.itbility.springbootbootstrap;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest
public class SpringBootBootstrapApplicationTests {
	
	private static final String API_ROOT = "http://localhost:8080/calculateDays";


	
	@Autowired(required=true)
	private MockMvc mvc;
	
	@Test
	public void calculateDaysWithPositiveDifference() throws Exception {
		
		mvc.perform(MockMvcRequestBuilders
				.post(API_ROOT).param("startDate", "2019-07-20").param("endDate", "2019-07-24")
				.contentType(MediaType.APPLICATION_JSON)
			    .accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(model()
				.attribute("message", "Number of Days : 4"));
	}
	
	@Test
	public void calculateDaysWithNegativeDifference() throws Exception {
		
		mvc.perform(MockMvcRequestBuilders
				.post(API_ROOT).param("startDate", "2019-07-20").param("endDate", "2019-07-15")
				.contentType(MediaType.APPLICATION_JSON)
			    .accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(model()
				.attribute("message", "EndDate should be greater than StartDate"));
	}
}
