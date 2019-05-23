package it.contrader.model;

public class User {
	private int iduser;
	private String username;
	private String password;

public User(int iduser, String username, String password) {
		this.iduser = iduser;	
		this.username = username;
		this.password = password;
	}

	public int getidUser() {
		return iduser;
	}

	public void setidUser(int idUser) {
		this.iduser = idUser;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return username;
	}
	
	public void getPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return this.getidUser() + "\t" + this.getUsername() + "\t" + this.getPassword();
	}

	public boolean equals(User userCompare) {
		if (!this.getUsername().equals(userCompare.getUsername())) {
			return false;
		}

		if (!this.getPassword().equals(userCompare.getPassword())) {
			return false;
		}

		return true;

	}

}
