package com.riva.odos.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riva.odos.domain.Facility;
import com.riva.odos.domain.FacilityDto;
import com.riva.odos.services.FacilityService;

@RestController
@RequestMapping(value="/api/v1", produces= {MediaType.APPLICATION_JSON_VALUE})
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FacilitySearchController {

	@Autowired
	FacilityService facilityService;
	
    @GetMapping(value="/facility")
    public List<Facility> facilitySearch(@RequestParam(value="searchZipCode") String searchZipCode) {
        return facilityService.searchFacility(searchZipCode);
    }
}
