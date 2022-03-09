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
import com.riva.odos.domain.Facility;
import com.riva.odos.domain.FacilityDto;
import com.riva.odos.repository.FacilityRepository;

@Service
public class FacilityService {

	@Autowired
	ObjectMapper objectMapper;
	
	@Autowired
	FacilityRepository facilityRepository;

	public List<Facility> getFacilities() {
		return facilityRepository.findAll();
	}

	protected String retrieveJson() throws IOException {
		try (InputStream in = getClass().getResourceAsStream("/FacilitiesList.json");
				BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
			return reader.lines().collect(Collectors.joining(System.lineSeparator()));
		}
	}

	protected List<FacilityDto> parseJson() {
		try {
			String json = retrieveJson();
			return objectMapper.readValue(json, new TypeReference<List<FacilityDto>>() {
			});
		} catch (JsonProcessingException e) {
			return new ArrayList<>();
		} catch (IOException e) {
			return new ArrayList<>();
		}
	}

	public List<Facility> searchFacility(Integer searchString) {
		return facilityRepository.findByZipCode(searchString);
	}

}
