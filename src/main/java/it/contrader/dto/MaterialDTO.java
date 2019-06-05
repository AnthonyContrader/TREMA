package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialDTO {

	private int Idmaterial;

	private String material;
	
	private int quantita;
	
	private UserDTO userDTO;
	
	private int	taskDTO;

}