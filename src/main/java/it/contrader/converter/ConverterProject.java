package it.contrader.converter;

import it.contrader.dto.*;
import it.contrader.model.*;

import java.util.ArrayList;
import java.util.List;

public class ConverterProject {
		
		public static ProjectDTO toDTO(Project project) {
			ProjectDTO projectDTO=null;
			
			if(project != null) {
				projectDTO = new ProjectDTO();
				projectDTO.setIdProject(project.getIdProject());
				projectDTO.setProject(project.getProject());
				projectDTO.setTipologie(project.getTipologie());
				projectDTO.setUserDTO(ConverterUser.toDTO(project.getUser()));
				/*
				List<Task> taskList= project.getTasks();
				//List<TaskDTO> taskListDTO= new ArrayList<TaskDTO>();
				
				for (Task task: taskList) {
					taskListDTO.add(ConverterTask.toDTO(task));
				} 
				
				projectDTO.setTaskDTO(taskListDTO); */
			}
		
			return projectDTO;
	}
		public static Project toEntity(ProjectDTO projectDTO) {
			
			Project project = null;
			
			if (projectDTO != null) {
				project = new Project();
				
				project.setIdProject(projectDTO.getIdProject());
				project.setProject(projectDTO.getProject());
				project.setTipologie(projectDTO.getTipologie());; 
				project.setUser(ConverterUser.toEntity(projectDTO.getUserDTO()));
				/*
				List<TaskDTO> taskListDTO= projectDTO.getTaskDTO();
				List<Task> taskList= new ArrayList<Task>();
				
				for (TaskDTO taskDTO: taskListDTO) {
					taskList.add(ConverterTask.toEntity(taskDTO));
				}
				
				project.setTasks(taskList); */
			}
			
			return project;
			}
		
		public static List<ProjectDTO> toListDTO(List<Project> list) {
			List<ProjectDTO> listProjectDTO = new ArrayList<>();
			if (!list.isEmpty()) {
				for (Project project : list) {
					listProjectDTO.add(ConverterProject.toDTO(project));
				}
			}
			return listProjectDTO;
		}
		
		public static List<Project> toListEntity(List<ProjectDTO> listProjectDTO) {
			List<Project> list = new ArrayList<>();
			if (!listProjectDTO.isEmpty()) {
				for (ProjectDTO projectDTO : listProjectDTO) {
					list.add(ConverterProject.toEntity(projectDTO));
				}
			}
			return list;
		}
}
