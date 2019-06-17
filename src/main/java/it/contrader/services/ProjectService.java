package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.dto.ProjectDTO;
import it.contrader.model.Project;
import it.contrader.dao.ProjectRepository;
import it.contrader.converter.ConverterProject;
import it.contrader.converter.ConverterUser;
import it.contrader.dto.UserDTO;

@Service
public class ProjectService extends AbstractService<Project, ProjectDTO> {
	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	private ConverterProject converterProject;

	@Autowired
	private ConverterUser converterUser;

	public List<ProjectDTO> findByUserLogin(UserDTO userDTO) {
		return converterProject.toDTOList(projectRepository.findAllByUser(converterUser.toEntity(userDTO)));
	}
}
