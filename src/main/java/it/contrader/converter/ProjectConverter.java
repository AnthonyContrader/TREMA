package it.contrader.converter;

import it.contrader.dto.ProjectDTO;
import it.contrader.dto.UsersDTO;
import it.contrader.model.Project;
import it.contrader.model.Users;

public class ProjectConverter {
	
	public static Project toEntity(ProjectDTO projectDTO) {

		Project project = null;
		if (projectDTO != null) {
			Users user = UsersConverter.toEntity(projectDTO.getUserDTO());
			project = new Project(projectDTO.getprojectName(),projectDTO.getDescrizione(),projectDTO.getTipo(),user );
			project.setProjectId(projectDTO.getId());
		}
		return project;
	}

	
	public static ProjectDTO toDTO(Project project) {

		ProjectDTO projectDTO  = null;
		if (project != null) {
			UsersDTO userDTO = UsersConverter.toDTO(project.getUser());
			projectDTO = new ProjectDTO(project.getProjectName(),project.getDescrizione(),project.getTipo(),userDTO);
			projectDTO.setId(project.getProjectId());
		}

		
		return projectDTO;
	}
	

}