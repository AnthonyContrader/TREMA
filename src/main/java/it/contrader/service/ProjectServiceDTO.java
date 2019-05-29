package it.contrader.service;

import it.contrader.converter.ProjectConverter;
import it.contrader.dao.ProjectDAO;
import it.contrader.dto.ProjectDTO;
import it.contrader.model.Project;


public class ProjectServiceDTO extends AbstractServiceDTO<Project,ProjectDTO> {

	public ProjectServiceDTO() {
		dao = new ProjectDAO();
		converter = new ProjectConverter();
	}

}
