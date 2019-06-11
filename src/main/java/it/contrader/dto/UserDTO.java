package it.contrader.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	private Integer IdUser;

	private String UserLogin;
	
	private String Password;

	private String NameUser;
	
	private String SurnameUser;
	
	private String Azienda;
	
	private String UserType;
	
	private List<ProjectDTO> ProjectsDTO;
	
}
