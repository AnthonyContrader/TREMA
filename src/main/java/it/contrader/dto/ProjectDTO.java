package it.contrader.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {
	
	private int idProject;
	
	private String project;
	
	private String tipologia;
	
	private int idUser;
}
