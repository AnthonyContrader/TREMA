package it.contrader.model;

public class User {
	private int idUser;
	private String username;
	private String password;
	
	public User(String username, String password) {
		this.username=username;
		this.password=password;
	}
	
	public int getidUser() {
		return idUser;
	}

	public void idUser(int idUser) {
		this.idUser = idUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUser(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return this.getidUser()+"\t"+this.getUsername()+"\t"+
				this.getPassword();
	}
	
	public boolean equals(User userCompare)  {
		if (!this.getUsername().equals(userCompare.getUsername())) {
			return false;
		}
		
		if (!this.getPassword().equals(userCompare.getPassword())) {
			return false;
		}
		
		return true;
				
	}

}
