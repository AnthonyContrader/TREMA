package it.contrader.model;

public class Task {
	private Integer idtask;
	private String descrizione_task;
	private Project project;
	private HumanResource hr;
	
	public Task() {
		
	}
	
	public Task(String descrizione_task, Project project, HumanResource hr) {
		super();
		this.descrizione_task = descrizione_task;
		this.project = project;
		this.hr = hr;
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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
	public HumanResource getHR() {
		return hr;
	}

	public void setHR(HumanResource hr) {
		this.hr = hr;
	}
	
	public boolean equals(Task taskCompare) {
		if (!this.getDescrizione_task().equals(getDescrizione_task())) {
			return false;
		}
		
		if (project.getProjectId() != taskCompare.getProject().getProjectId()) {
			return false;
		}
		
		if (hr.getId() != taskCompare.getHR().getId()) {
			return false;
		}
		
		return true;
	}
	
	public String toString() {
		return this.getIdtask() + "\t\t" + this.getDescrizione_task() + "\t\t" 
				+ this.getProject().getProjectId() + "\t\t" + this.getHR().getId();
	}
}
