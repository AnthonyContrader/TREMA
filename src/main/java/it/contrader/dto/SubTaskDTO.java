package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubTaskDTO {
	private long id;

	private String subTask;
	
	private Date dataInizio;

	private Date dataFine;
	
	private TaskDTO taskDTO;
}

