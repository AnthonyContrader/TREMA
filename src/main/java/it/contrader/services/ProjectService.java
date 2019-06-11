package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.dto.ProjectDTO;
import it.contrader.converter.ConverterProject;
import it.contrader.dao.ProjectRepository;
import it.contrader.model.Project;

import it.contrader.converter.ConverterUser;
import it.contrader.dto.UserDTO;

import it.contrader.dto.TaskDTO;
import it.contrader.converter.ConverterTask;

@Service
public class ProjectService {

	private final ProjectRepository projectRepository;		
	@Autowired
	private TaskService taskService;

	@Autowired
	public ProjectService(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	public List<ProjectDTO> getListProjectDTO() {
		return ConverterProject.toListDTO((List<Project>) projectRepository.findAll());
	}

	public ProjectDTO getProjectDTOById(Integer id) {
		return ConverterProject.toDTO(projectRepository.findById(id).get());
	}

	public boolean insertProject(ProjectDTO projectDTO) {
		return projectRepository.save(ConverterProject.toEntity(projectDTO)) != null;
	}

	public boolean updateProject(ProjectDTO projectDTO) {
		return projectRepository.save(ConverterProject.toEntity(projectDTO)) != null;
	}

	public void deleteProjectById(Integer id) {
		projectRepository.deleteById(id);
	}

	public List<ProjectDTO> findProjectDTOByUserLogin(UserDTO userDTO) {
		final List<Project> listProject = projectRepository.findAllByUserLogin(ConverterUser.toEntity(userDTO));
		final List<ProjectDTO> listProjectDTO = new ArrayList<>();
		listProject.forEach(i -> listProjectDTO.add(ConverterProject.toDTO(i)));
		return listProjectDTO;
	}
	
	public List<TaskDTO> findTaskDTOByProject(ProjectDTO projectDTO) {
		List<TaskDTO> taskList = new ArrayList<TaskDTO>();
		taskList = taskService.findTaskDTOByProject(projectDTO);
		return taskList;
	}
	
	/* Tree management
	public TaskDTO findTaskRoot(ProjectDTO projectDTO) {
		return taskService.findProjectTaskRoot(projectDTO);
	}*/
}