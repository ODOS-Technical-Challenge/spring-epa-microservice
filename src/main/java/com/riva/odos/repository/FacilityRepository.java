package com.riva.odos.repository;

import java.util.Map;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.riva.odos.domain.Facility;

public interface FacilityRepository extends MongoRepository<Facility, String> {

}

