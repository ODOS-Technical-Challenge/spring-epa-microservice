package com.riva.odos.services;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.riva.odos.domain.FacilityDto;

@Service
public class FacilityService {
	
	@Autowired
	ObjectMapper objectMapper;

	public List<FacilityDto> getFacilities() throws Exception {
		return parseJson(retrieveJson());
	}

	protected String retrieveJson() throws Exception {
		try (InputStream in = getClass().getResourceAsStream("/FacilitiesList.json");
			    BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
			return reader.lines().collect(Collectors.joining(System.lineSeparator()));
		} 
		
	}
	
	protected List<FacilityDto> parseJson(String json) throws Exception {
		try {
			return objectMapper.readValue(json, new TypeReference<List<FacilityDto>>() {});
		} finally {}
	}
	
	public List<FacilityDto> searchFacility(String searchString) throws Exception{
		List<FacilityDto> allFacilities = getFacilities();
		List<FacilityDto> searchResults = new ArrayList<>();
		for(FacilityDto facility: allFacilities) {
			if(facility.getZipCode().equals(searchString)) {
				searchResults.add(facility);
			}
		}
		return (searchResults);
	}
	
//	public AirportInfoDto getSingleFacility(String shortCode) {
//		List<AirportInfoDto> allAirports = getFacilities();
//		
//		for(AirportInfoDto airport: allAirports) {
//			if(airport.getShortcode().toUpperCase().contains(shortCode.toUpperCase())) {
//				return airport;
//			}
//		}
//		return null;
//	}
	
//	public AirportWaitTimeDto searchAirportHistoricWaitTimes(String airportShortCode) {
//		
//		AirportWaitTimeDto airportWaitTimes = new AirportWaitTimeDto();
//		AirportInfoDto airport = getSingleFacility(airportShortCode);
//		
//		if(airport != null) {
//			airportWaitTimes = buildMockAirportWaitTimeDto(airport);
//		}
//		
//		return airportWaitTimes;
//	}
//	
//	public PredictedWaitTimeDto getPredictedwaitTime(String airportShortCode, Date futureDate) {
//		PredictedWaitTimeDto predictedWaitTime = new PredictedWaitTimeDto();
//		AirportInfoDto airport = getSingleAirport(airportShortCode);
//		if(airport != null) {
//			predictedWaitTime = buildMockPredictedWaitTimeDto(airport);
//		}
//		return predictedWaitTime;
//	}
//	
//	private List<AirportInfoDto> mockDelayTimes(List<AirportInfoDto> airports) {
//		airports.forEach((airport) -> airport.setDelayTimes(mockDelayTime()));
//		return airports;
//	}
	
//	private DelayTimeDto mockDelayTime() {
//		Integer minEstimatedWaitTime = (int) (Math.random() * 60);
//		Integer maxEstimatedWaitTime = (int) (minEstimatedWaitTime + (Math.random() * 120));
//		Integer maxEstimatedPrecheckTime = (int) (Math.random() * 60);
//
//		DelayTimeDto delayTime = new DelayTimeDto();
//		delayTime.setMinEstimatedWaitTime(minEstimatedWaitTime);
//		delayTime.setMaxEstimatedWaitTime(maxEstimatedWaitTime);
//		delayTime.setMaxEstimatedPrecheckTime(maxEstimatedPrecheckTime);
//
//		return delayTime;
//	}
//
//	protected AirportWaitTimeDto buildMockAirportWaitTimeDto(AirportInfoDto airport) {
//		AirportWaitTimeDto airportWaitTime = new AirportWaitTimeDto();
//		airportWaitTime.setLongname(airport.getName());
//		airportWaitTime.setShortname(airport.getShortcode());
//		airportWaitTime.setCurrentWaitMinutes(createMockListOfWaitTimes());
//		return airportWaitTime;
//	}
//	
//	protected PredictedWaitTimeDto buildMockPredictedWaitTimeDto(AirportInfoDto airport) {
//		Long minWait = 1L;
//	    Long maxWait = 120L;
//		
//		PredictedWaitTimeDto predictedWaitTime = new PredictedWaitTimeDto();
//		predictedWaitTime.setLongname(airport.getName());
//		predictedWaitTime.setShortname(airport.getShortcode());
//		predictedWaitTime.setPredictedWaitMinutes(minWait + (long) (Math.random() * (maxWait - minWait)));
//		
//		return predictedWaitTime;
//	}
//	
//	protected List<Long> createMockListOfWaitTimes() {
//		List<Long> waitTimeList = new ArrayList<>();
//		Long minWait = 1L;
//	    Long maxWait = 300L;
//	    for(int i = 0; i < 25; i++) {
//	    	waitTimeList.add(minWait + (long) (Math.random() * (maxWait - minWait)));
//	    }
//	    return waitTimeList;
//	}
	
	
}
