package it.contrader.model;

public class User {
	private int idUser;
	private String username;
	private String password;
	private String userType;

	public User(int idUser, String username, String password, String userType) {
		this.idUser = idUser;
		this.username = username;
		this.password = password;
		this.userType = userType;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return this.getIdUser() + "\t" + this.getUsername() + "\t" + this.getPassword();
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
