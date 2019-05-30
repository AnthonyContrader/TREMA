package it.contrader.dto;

public class MaterialDTO {
	private int idmaterial;
	private String tipo;
	private int quantita;
	private HumanResourceDTO hrDTO;
	
	public MaterialDTO(String tipo, int quantita, HumanResourceDTO hrDTO){
		super();
		this.tipo = tipo;
		this.quantita = quantita;
		this.hrDTO = hrDTO; 
	}

	public int getIdmaterial() {
		return idmaterial;
	}

	public void setIdmaterial(int idmaterial) {
		this.idmaterial = idmaterial;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public HumanResourceDTO getHRDTO() {
		return hrDTO;
	}

	public void setHRDTO(HumanResourceDTO hrDTO) {
		this.hrDTO = hrDTO;
	}
	
	public boolean equals(MaterialDTO materialCompare) {
		if (hrDTO.getIdHR()!=materialCompare.getHRDTO().getIdHR()) 
			return false;
		
		if (!this.getTipo().equals(getTipo()))
			return false;
		
		return true;
	}
}
