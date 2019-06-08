package it.contrader.dto;

import java.util.List;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {
	
	private int idProject;
	
	private String project;
	
	private String tipologie;
	
	private UserDTO userDTO;

	private List<TaskDTO> taskDTO;
}
