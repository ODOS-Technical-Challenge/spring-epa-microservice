package com.riva.odos.api.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.riva.odos.services.FacilityService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(FacilitySearchController.class)
@ContextConfiguration(classes = FacilitySearchController.class)
public class FacilitySearchControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private FacilityService facilityService;

	@Test
	public void testController() throws Exception {
		mockMvc.perform(get("/api/v1/facility?searchZipCode=3M").contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("utf-8").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	
}
