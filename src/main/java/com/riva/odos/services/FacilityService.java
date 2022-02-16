package com.riva.odos.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.util.Lists;
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
		return parseJson();
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
			return Lists.newArrayList();
		} catch (IOException e) {
			return Lists.newArrayList();
		}
	}

	public List<FacilityDto> searchFacility(String searchString) {
		List<FacilityDto> allFacilities = getFacilities();

		return allFacilities.stream().filter(facility -> facility.getZipCode().equals(searchString))
				.collect(Collectors.toList());
	}

}
