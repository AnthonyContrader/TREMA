package it.contrader.converter;

import it.contrader.dto.*;
import it.contrader.model.*;
import it.contrader.converter.ConverterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConverterProject extends AbstractConverter<Project, ProjectDTO> {

	@Autowired
	private ConverterUser converter;

	public ProjectDTO toDTO(Project project) {
		ProjectDTO projectDTO = null;

		if (project != null) {
			projectDTO = new ProjectDTO();
			
			projectDTO.setId(project.getId());
			projectDTO.setProject(project.getProject());
			projectDTO.setTipologie(project.getTipologie());
			projectDTO.setUserDTO(converter.toDTO(project.getUser()));
		}

		return projectDTO;
	}

	public Project toEntity(ProjectDTO projectDTO) {

		Project project = null;

		if (projectDTO != null) {
			project = new Project();

			project.setId(projectDTO.getId());
			project.setProject(projectDTO.getProject());
			project.setTipologie(projectDTO.getTipologie());
			project.setUser(converter.toEntity(projectDTO.getUserDTO()));
		}

		return project;
	}


}
