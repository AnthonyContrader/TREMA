package it.contrader.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DipendentiDTO {

	private int idDipendente;

	private String NomeDip;
	
	private String CognomeDip;
	
	private List<DipMaterialDTO> dipMaterialsDTO;

}