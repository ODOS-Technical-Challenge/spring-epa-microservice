package com.riva.odos.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChemicalDto {
	private String name;
	private String usage;
	private String healthEffect;
}
