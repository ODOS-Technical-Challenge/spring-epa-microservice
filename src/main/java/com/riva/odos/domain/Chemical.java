package com.riva.odos.domain;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;


@Data
@Document(collection = "us_1b")
public class Chemical {
	@DBRef
	@Field("78. CHEMICAL NAME")
	private String name;
	
	@DBRef
	@Field("77. TRI CHEMICAL ID")
	private String chemicalId;
}
