package it.contrader.model;

/**
 * Classe Model di esempio
 *
 */
public class Project {

	/**
	 * I campi che sono attributi di una certa tabella che vogliamo rappresentare
	 * <br>
	 * Possiamo avere n colonne
	 */
	private int idproject;
	private String name;
	private String descrizione;
	private String tipo;
	private int iduser;

	/**
	 * Costruttore con parametri
	 */
	public Project(int idproject, String name, String descrizione, String tipo , int iduser) {
		super();
		this.idproject = idproject;
		this.name = name;
		this.descrizione = descrizione;
		this.tipo = tipo;
		this.iduser = iduser;
	
}

	public int getIdproject() {
		return idproject;
	}

	public void setIdproject(int idproject) {
		this.idproject = idproject;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
}
