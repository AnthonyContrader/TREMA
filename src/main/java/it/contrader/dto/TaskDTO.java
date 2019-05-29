package it.contrader.dto;

public class TaskDTO {
	private Integer idtask;
	private String descrizione_task;
	private Integer idproject;
	private String descrizione_project;
	private Integer idHR;
	private String descrizione_hr;
	
	public TaskDTO() {
		
	}
	
	public TaskDTO(int idtask, String descrizione_task, Integer idproject, Integer idHR) {
		super();
		this.idtask = idtask;
		this.descrizione_task = descrizione_task;
		this.idproject = idproject;
		this.idHR = idHR;
	}
	
	public TaskDTO(String descrizione_task, Integer idproject, Integer idHR) {
		super();
		this.descrizione_task = descrizione_task;
		this.idproject = idproject;
		this.idHR = idHR;
	}
	
	public TaskDTO(String descrizione_task, Integer idproject, String project, Integer idHR, String hr) {
		super();
		this.descrizione_task = descrizione_task;
		this.idproject = idproject;
		this.descrizione_project = project;
		this.idHR = idHR;
		this.descrizione_hr = hr;
	}
	
	public TaskDTO(int idtask, String descrizione_task, Integer idproject, String project, Integer idHR, String hr) {
		super();
		this.idtask = idtask;
		this.descrizione_task = descrizione_task;
		this.idproject = idproject;
		this.descrizione_project = project;
		this.idHR = idHR;
		this.descrizione_hr = hr;
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
