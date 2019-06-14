package it.contrader.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {
	private long id;

	private String task;

	private Date dataInizio;

	private Date dataFine;

	private ProjectDTO projectDTO;
}
