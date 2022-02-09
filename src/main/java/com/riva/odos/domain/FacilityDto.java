package com.riva.odos.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FacilityDto {
	private String name;
	private String street;
	private String city;
	private String county;
	private String state;
	private String zipCode;
	private Long longitude;
	private Long latitude;
	@JsonProperty("chemicals")
	private List<ChemicalDto> chemicals;
}
