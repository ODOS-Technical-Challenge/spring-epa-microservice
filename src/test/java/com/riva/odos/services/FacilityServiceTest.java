package com.riva.odos.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.riva.odos.domain.FacilityDto;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { FacilityService.class, ObjectMapper.class })
class FacilityServiceTest {
	
	@Spy
	FacilityService facilityService;
	
	@Autowired
	FacilityService unSpyFacilityService;

	private static final String UNKNOWN = "unknown";
	
	@Test
	void shouldGetFacilities() throws Exception {
		List<FacilityDto> facilities = unSpyFacilityService.getFacilities();
		
		
		assertTrue(facilities.size() > 0);
	}
	
	@Test
	public void testSearchFacilities() throws Exception{
		List<FacilityDto> returnedFacilityList = new ArrayList<>();
		FacilityDto expectedfacilityInfo = new FacilityDto();
		expectedfacilityInfo.setName("3M");
		expectedfacilityInfo.setZipCode("20713");
		
		List<FacilityDto> testFacilities = testFacilityList();
		
		doReturn(testFacilities).when(facilityService).getFacilities();
		
		returnedFacilityList = facilityService.searchFacility("20713");
		
		assertEquals(expectedfacilityInfo.getName(), returnedFacilityList.get(0).getName());
		assertEquals(expectedfacilityInfo.getZipCode(), returnedFacilityList.get(0).getZipCode());
	}
	
	@Test
	public void testSearchFacilitiesNotFound() throws Exception{
		List<FacilityDto> expectedfacilityInfoList = new ArrayList<>();
		List<FacilityDto> returnedFacilityList = new ArrayList<>();
		
		List<FacilityDto> testFacilities = testFacilityList();
		
		doReturn(testFacilities).when(facilityService).getFacilities();
		
		returnedFacilityList = facilityService.searchFacility(UNKNOWN);
		
		assertEquals(expectedfacilityInfoList.size(), returnedFacilityList.size());
	}
	
	private List<FacilityDto> testFacilityList(){
		List<FacilityDto> testFacilityList = new ArrayList<>();
		FacilityDto facility1 = new FacilityDto();
		facility1.setName("3M");
		facility1.setZipCode("20713");
		testFacilityList.add(facility1);
		return testFacilityList;
	}
}
