package it.contrader.dto;

public class TaskDTO {
	private Integer idtask;
	private String descrizioneTask;
	private ProjectDTO projectDTO;
	private HumanResourceDTO hrDTO;
	
	public TaskDTO(String descrizioneTask, ProjectDTO projectDTO, HumanResourceDTO hrDTO){
		super();
		this.descrizioneTask = descrizioneTask;
		this.projectDTO = projectDTO;
		this.hrDTO = hrDTO; 
	}

	public Integer getIdtask() {
		return idtask;
	}

	public void setIdtask(Integer idtask) {
		this.idtask = idtask;
	}

	public String getDescrizioneTask() {
		return descrizioneTask;
	}

	public void setDescrizioneTask(String descrizioneTask) {
		this.descrizioneTask = descrizioneTask;
	}

	public ProjectDTO getProjectDTO() {
		return projectDTO;
	}

	public void setProjectDTO(ProjectDTO projectDTO) {
		this.projectDTO = projectDTO;
	}

	public HumanResourceDTO getHRDTO() {
		return hrDTO;
	}

	public void setHRDTO(HumanResourceDTO hrDTO) {
		this.hrDTO = hrDTO;
	}
	
	public boolean equals(TaskDTO taskCompare) {
		if (projectDTO.getIdproject()!=taskCompare.getProjectDTO().getIdproject()) 
			return false;
		
		if (hrDTO.getIdHR()!=taskCompare.getHRDTO().getIdHR()) 
			return false;
		
		if (!this.getDescrizioneTask().equals(getDescrizioneTask()))
			return false;
		
		return true;
	}
}
