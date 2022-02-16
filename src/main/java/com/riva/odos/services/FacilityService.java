package com.riva.odos.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.riva.odos.domain.FacilityDto;

@Service
public class FacilityService {
	
	@Autowired
	ObjectMapper objectMapper;

	public List<FacilityDto> getFacilities() {
		return parseJson(retrieveJson());
	}

	protected String retrieveJson() {
		try (InputStream in = getClass().getResourceAsStream("/FacilitiesList.json");
			    BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
			return reader.lines().collect(Collectors.joining(System.lineSeparator()));
		} catch (IOException e) {
			return "Error retrieving JSON";
		} 
	}
	
	protected List<FacilityDto> parseJson(String json) {
		try {
			return objectMapper.readValue(json, new TypeReference<List<FacilityDto>>() {});
		} catch (JsonProcessingException e) {
			return new ArrayList<FacilityDto>();
		}
		
	}
	
	public List<FacilityDto> searchFacility(String searchString) {
		List<FacilityDto> allFacilities = getFacilities();
		List<FacilityDto> searchResults = new ArrayList<>();
		for(FacilityDto facility: allFacilities) {
			if(facility.getZipCode().equals(searchString)) {
				searchResults.add(facility);
			}
		}
		return (searchResults);
	}
	
}
