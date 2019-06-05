package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import it.contrader.dto.UserDTO;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DipendentiDTO {

	private int idDipendente;

	private String name;
	
	private String surname;

	private UserDTO userDTO;

}