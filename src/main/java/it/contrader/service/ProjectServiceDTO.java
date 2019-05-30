package it.contrader.service;

import java.util.ArrayList;
import java.util.List;

import it.contrader.converter.ProjectConverter;
import it.contrader.dao.ProjectDAO;
import it.contrader.dto.ProjectDTO;
import it.contrader.model.Project;



public class ProjectServiceDTO {


/**
 * Classe che si occupa di interfacciarsi con la persistenza e recuperare
 * attraverso i metodi del Data Access Object le tuple desiderate, Le converte
 * in un oggetto DTO e le restituisce al controller opportuno
 */

	private final ProjectDAO projectDAO;

	public ProjectServiceDTO() {
		this.projectDAO = new ProjectDAO();
	}

	/**
	 * Come vediamo la lista recuperata � di tipo Esempio ma noi la convertiamo in EsempioDTO
	 * Invito chi fa i converter a fare un metodo per convertire direttamente la lista senza farli uno ad uno perch� � sporco e poco efficiente
	 */
	public List<ProjectDTO> getAllProject() {

		List<Project> list = projectDAO.getAllProject();
		List<ProjectDTO> listDTO = new ArrayList<>();

		for (Project project : list) {
			listDTO.add(ProjectConverter.toDTO(project));
		}

		return listDTO;
	}
	

	
	public ProjectDTO readProject(ProjectDTO projectDTO) {
		return ProjectConverter.toDTO(this.projectDAO.readProject(ProjectConverter.toEntity(projectDTO)));
	}

	public boolean updateProject(ProjectDTO projectDTO) {
		return this.projectDAO.updateProject(ProjectConverter.toEntity(projectDTO));
		
}
	
	public boolean deleteProject (ProjectDTO projectDTO) {
		return this.projectDAO.deleteProject(ProjectConverter.toEntity(projectDTO));
		
}
	
	public boolean insertProject (ProjectDTO projectDTO) {
		return this.projectDAO.insertProject(ProjectConverter.toEntity(projectDTO));
	
}
		
	
	
}
