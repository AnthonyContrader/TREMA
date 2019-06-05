package it.contrader.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	private Integer idUser;

	private String user;
	
	private String password;

	private String name_user;
	
	private String surname_user;
	
	private String azienda;
	
	private String usertype;
	
	private List<ProjectDTO> projectsDTO;
	
}
