package it.contrader.converter;

import it.contrader.dto.ProjectDTO;
import it.contrader.model.Project;

public class ProjectConverter implements Converter<Project,ProjectDTO> {


	public Project toEntity(ProjectDTO projectDTO) {

		Project project = null;
		if (projectDTO != null) {
			project = new Project(projectDTO.getName(),projectDTO.getDescrizione(), projectDTO.getTipo(), projectDTO.getIduser());
			Integer id = projectDTO.getIdproject();
			if(id != null) {
				project.setIdproject(projectDTO.getIdproject());
			}


		}
		return project;

	}



	public ProjectDTO toDTO(Project project) {

		ProjectDTO projectDTO = null;
		if (project != null) {
			projectDTO = new ProjectDTO(project.getIdproject(),project.getName(), project.getDescrizione(),project.getTipo(), project.getIduser());
		}

		return projectDTO;
	}
}
