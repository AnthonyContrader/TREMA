package it.contrader.dto;

public class TaskDTO {
	private Integer idtask;
	private String descrizione_task;
	private Integer idproject;
	private Integer idHR;
	
	public TaskDTO(String descrizione_task, Integer idproject, Integer idHR) {
		super();
		this.descrizione_task = descrizione_task;
		this.idproject = idproject;
		this.idHR = idHR;
	}

	public Integer getIdtask() {
		return idtask;
	}

	public void setIdtask(Integer idtask) {
		this.idtask = idtask;
	}

	public String getDescrizione_task() {
		return descrizione_task;
	}

	public void setDescrizione_task(String descrizione_task) {
		this.descrizione_task = descrizione_task;
	}

	public Integer getIdproject() {
		return idproject;
	}

	public void setIdproject(Integer idproject) {
		this.idproject = idproject;
	}

	public Integer getIdHR() {
		return idHR;
	}

	public void setIdHR(Integer idHR) {
		this.idHR = idHR;
	}
}
