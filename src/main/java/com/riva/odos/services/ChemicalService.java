package com.riva.odos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riva.odos.domain.Chemical;
import com.riva.odos.repository.ChemicalRepository;

@Service
public class ChemicalService {

	@Autowired
	ChemicalRepository chemicalRepository;
	
	
	public List<Chemical> searchChemicals(String chemicalSearch){
		return chemicalRepository.findByChemicalName(chemicalSearch);
	}
}
