package it.contrader.model;

public class HumanResource {
		private int idHR;
		private String name;
		private String surname;
		private int iduser;
		
		public HumanResource(int idHR, String name, String surname, int iduser) {
			this.idHR=idHR;
			this.name=name;
			this.surname=surname;
			this.iduser=iduser;
		}
		
		public int getIdHR() {
			return idHR;
		}
		public void setIdHR(int idHR) {
			this.idHR = idHR;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSurname() {
			return surname;
		}
		public void setSurname(String surname) {
			this.surname = surname;
		}
		public int getIduser() {
			return iduser;
		}
		public void setIduser(int iduser) {
			this.iduser = iduser;
		}
		@Override
		public String toString() {
			return "idHR=" + idHR + ", name=" + name + ", surname=" + surname + ", iduser=" + iduser;
		}
		
		
}
