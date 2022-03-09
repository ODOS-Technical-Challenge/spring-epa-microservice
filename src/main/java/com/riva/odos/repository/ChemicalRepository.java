package com.riva.odos.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.riva.odos.domain.Chemical;

public interface ChemicalRepository extends MongoRepository<Chemical, String> {

	@Query("{ '78. CHEMICAL NAME': ?0 }")
	List<Chemical> findByChemicalName(String chemicalName);
	
}
