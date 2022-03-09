package com.riva.odos.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.riva.odos.domain.Facility;

public interface FacilityRepository extends MongoRepository<Facility, String> {
	@Query("{ '15. FACILITY ZIP CODE': ?0 }")
	List<Facility> findByZipCode(int zipCode);
}

