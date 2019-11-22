package com.org.census.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CensusQueryControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testRange_isOK() throws Exception {
		mockMvc.perform(get("/census/pupulation/range").param("start", "10").param("end", "20"))
				.andExpect(status().isOk()).andReturn();
	}
	
	@Test
	public void testRange_isBadRequest() throws Exception {
		mockMvc.perform(get("/census/pupulation/range").param("start", "10"))
				.andExpect(status().isBadRequest()).andReturn();
	}
	
	
	@Test
	public void testMedianAge_isOK() throws Exception {
		mockMvc.perform(get("/census/pupulation/medianage").param("start", "10").param("end", "20"))
				.andExpect(status().isOk()).andReturn();
	}
	
	@Test
	public void testMedianAge_isBadRequest() throws Exception {
		mockMvc.perform(get("/census/pupulation/medianage").param("start", "10"))
				.andExpect(status().isBadRequest()).andReturn();
	}
	
	
	@Test
	public void testMedianAge_isNotFound() throws Exception {
		mockMvc.perform(get("/census/pupulations").param("start", "10"))
				.andExpect(status().isNotFound()).andReturn();
	}
	
	@Test
	public void testTopPopulated_isOk() throws Exception {
		mockMvc.perform(get("/census/pupulation/polulated").param("top", "10"))
				.andExpect(status().isOk()).andReturn();
	}
	
	@Test
	public void testGenderDiff_isOk() throws Exception {
		mockMvc.perform(get("/census/pupulation/diff/female"))
				.andExpect(status().isOk()).andReturn();
	}
	
	@Test
	public void testGenderDiff_isMthodNotAllowed() throws Exception {
		mockMvc.perform(post("/census/pupulation/diff/female"))
				.andExpect(status().isMethodNotAllowed()).andReturn();
	}
	

}
