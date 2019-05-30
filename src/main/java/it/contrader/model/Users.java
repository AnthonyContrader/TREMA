package it.contrader.model;

import it.contrader.model.Users;

public class Users {

	private Integer iduser;
	private String username;
	private String password;
	private String usertype;

	public Users() {}
	
	public Users(String username, String password, String usertype) {
		this.username = username;
		this.password = password;
		this.usertype = usertype;

		
	}

	public Integer getIduser() {
		return iduser;
	}

	public void setIduser(Integer iduser) {
		this.iduser = iduser;
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

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	@Override
	public String toString() {
		return "idUser=" + iduser + ", username=" + username + ", password=" + password + ", usertype=" + usertype;
	}

	public boolean equals(Users userCompare)  {
		if (!this.getUsername().equals(userCompare.getUsername())) {
			return false;
		}
		
		if (!this.getPassword().equals(userCompare.getPassword())) {
			return false;
		}
		
		if (!this.getUsertype().equals(userCompare.getUsertype())) {
			return false;
		}
		
		return true;
				
	}

}
