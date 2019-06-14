package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DipendentiDTO {

	private long id;

	private String nomeDip;
	
	private String cognomeDip;

}