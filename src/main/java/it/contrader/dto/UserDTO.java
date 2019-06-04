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

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName_user() {
		return name_user;
	}

	public void setName_user(String name_user) {
		this.name_user = name_user;
	}

	public String getSurname_user() {
		return surname_user;
	}

	public void setSurname_user(String surname_user) {
		this.surname_user = surname_user;
	}

	public String getAzienda() {
		return azienda;
	}

	public void setAzienda(String azienda) {
		this.azienda = azienda;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public List<ProjectDTO> getProjectsDTO() {
		return projectsDTO;
	}

	public void setProjectsDTO(List<ProjectDTO> projectsDTO) {
		this.projectsDTO = projectsDTO;
	}

	
}
