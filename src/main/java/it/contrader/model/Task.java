package it.contrader.model;

public class Task {
	private Integer idtask;
	private String descrizione_task;
	private Integer idproject;
	private String descrizione_project;
	private Integer idHR;
	private String descrizione_hr;
	
	public Task() {
		
	}
	
	public Task(int idtask, String descrizione_task, Integer idproject, Integer idHR) {
		super();
		this.idtask = idtask;
		this.descrizione_task = descrizione_task;
		this.idproject = idproject;
		this.idHR = idHR;
	}
	
	public Task(String descrizione_task, Integer idproject, Integer idHR) {
		super();
		this.descrizione_task = descrizione_task;
		this.idproject = idproject;
		this.idHR = idHR;
	}
	
	public Task(String descrizione_task, Integer idproject, String project, Integer idHR, String hr) {
		super();
		this.descrizione_task = descrizione_task;
		this.idproject = idproject;
		this.descrizione_project = project;
		this.idHR = idHR;
		this.descrizione_hr = hr;
	}
	
	public Task(int idtask, String descrizione_task, Integer idproject, String project, Integer idHR, String hr) {
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
	
	public String getDescrizioneProject() {
		return descrizione_project;
	}

	public void setDescrizioneProject(String descrizione_project) {
		this.descrizione_project = descrizione_project;
	}
	
	public Integer getIdHR() {
		return idHR;
	}

	public void setIdHR(Integer idHR) {
		this.idHR = idHR;
	}
	
	public String getDescrizioneHR() {
		return descrizione_hr;
	}

	public void setDescrizioneHR(String descrizione_hr) {
		this.descrizione_hr = descrizione_hr;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Task other = (Task) obj;
		
		if (descrizione_task == null) {
			if (other.descrizione_task != null)
				return false;
		} else if (!descrizione_task.equals(other.descrizione_task))
			return false;
		
		if (descrizione_project == null) {
			if (other.descrizione_project != null)
				return false;
		} else if (!descrizione_project.equals(other.descrizione_project))
			return false;
		
		if (descrizione_hr == null) {
			if (other.descrizione_hr != null)
				return false;
		} else if (!descrizione_hr.equals(other.descrizione_hr))
			return false;
		
		if (idtask != other.idtask)
			return false;
		
		return true;
	}
	
	@Override
	public String toString() {
		return this.getIdtask() + "\t\t" + this.getDescrizione_task() + "\t\t" 
				+ this.getDescrizioneProject() + "\t\t" + this.getDescrizioneHR();
	}
	
	public String TaskFull() {
		return this.getIdtask() + "\t\t" + this.getDescrizione_task() + "\t\t" + this.getIdproject() 
			+ "\t\t" + this.getDescrizioneProject() + "\t\t" + this.getIdHR() + "\t\t" + this.getDescrizioneHR();
	}
}
