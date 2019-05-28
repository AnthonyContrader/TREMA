package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.ProjectDTO;
import it.contrader.model.Project;

/**
 * Il converter si occupa di "convertire" un model in un dto e viceversa
 *
 */
public class ProjectConverter {


	/**
	 * Converte un NodesDTO in Nodes
	 */
	public static Project toEntity(ProjectDTO projectDTO) {

		Project project = null;
		if (projectDTO != null) {
			project = new Project(projectDTO.getIdproject(), projectDTO.getName(), projectDTO.getDescrizione(), projectDTO.getTipo(), projectDTO.getIduser());
		}

		return project;
	}

	/**
	 * Converte un Nodes in NodesDTO
	 */
	public static ProjectDTO toDTO(Project project) {

		ProjectDTO projectDTO = null;
		if (project != null) {
			projectDTO = new ProjectDTO(project.getIdproject(), project.getName(), project.getDescrizione(), project.getTipo(), project.getIduser());
		}

		return projectDTO;
	}
	

}