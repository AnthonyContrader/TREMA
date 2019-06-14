package it.contrader.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {
	
	private Long id;
	
	private String project;
	
	private String tipologie;
	
	private UserDTO userDTO;
}
