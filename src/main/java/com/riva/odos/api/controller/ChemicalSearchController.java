package com.riva.odos.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riva.odos.domain.Chemical;
import com.riva.odos.services.ChemicalService;

@RestController
@RequestMapping(value="/api/v1", produces= {MediaType.APPLICATION_JSON_VALUE})
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ChemicalSearchController {

	@Autowired
	ChemicalService chemicalService;
	
    @GetMapping(value="/chemical")
    public List<Chemical> chemicalSearch(@RequestParam(value="searchChemName") String searchChemName) {
        return chemicalService.searchChemicals(searchChemName); 
    }
    
}
