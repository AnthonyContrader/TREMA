package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialDTO {

	private int IdMaterial;

	private String Material;
	
	private int Quantita;
	
	private MaterialDTO	materialDTO;

}