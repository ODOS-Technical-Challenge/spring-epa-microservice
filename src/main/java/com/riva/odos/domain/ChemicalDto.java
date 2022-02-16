package com.riva.odos.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChemicalDto {
	private String name;
	private String usage;
	private String healthEffects;
	private String mixtureName;
	private Boolean elementalMetalIncluded;
	private String classification;
	private String unitOfMeasure;
	private Boolean cleanAirInd;
	private Boolean carcinogenInd;
	private Boolean pfasInd;
	private Boolean metalInd;
}
