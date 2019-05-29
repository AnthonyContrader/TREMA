package it.contrader.dto;

public class ProjectDTO {
	
		private int idproject;
		private String name;
		private String descrizione;
		private String tipo;
		private int iduser;

		public ProjectDTO() {

		}

		public ProjectDTO(String name, String descrizione, String tipo, int iduser) {
			super ();
			this.setName(name);
			this.setDescrizione(descrizione);
			this.setTipo(tipo);
			this.setIduser(iduser);

		}
		public ProjectDTO(int idproject, String name, String descrizione, String tipo, int iduser) {
			super ();
			this.idproject = idproject;
			this.name = name;
			this.descrizione = descrizione;
			this.tipo = tipo;
			this.iduser = iduser;

		}
		public int getIduser() {
			return iduser;
		}

		public void setIduser(int iduser) {
			this.iduser = iduser;
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

		public int getIdproject() {
			return idproject;
		}

		public void setIdproject(int idproject) {
			this.idproject = idproject;
		}
	
	
}