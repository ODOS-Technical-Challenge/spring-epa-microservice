package com.riva.odos.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { FacilityService.class })
public class UtilitiesTest {

	@MockBean 
	ObjectMapper objectMapper;
	
	@Mock
	JsonProcessingException jsonProcessingException;
	
	@Autowired
	FacilityService unSpyFacilityService;
	
	
	@Test
	void testSearchFacilitiesExceptionThrown() throws Exception {
		Mockito.doAnswer(invocation -> {
            throw jsonProcessingException;
        }).when(objectMapper).readValue(Mockito.anyString(), Mockito.any(TypeReference.class));
		
		
		unSpyFacilityService.getFacilities();
	}
	
}
