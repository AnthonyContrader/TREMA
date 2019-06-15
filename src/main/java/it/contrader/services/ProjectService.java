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
	private final ProjectRepository projectRepository;
	
	@Autowired
	private ConverterProject converterProject;
	
	@Autowired
	private ConverterUser converterUser;
	
	@Autowired
	public ProjectService(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}
	
	public List<ProjectDTO> findByUserLogin(UserDTO userDTO) {
		final List<Project> list = projectRepository.findByUserLogin(converterUser.toEntity(userDTO));
		final List<ProjectDTO> listDTOs = new ArrayList<>();
		list.forEach(i -> listDTOs.add(converterProject.toDTO(i)));
		return listDTOs;
	}
}
