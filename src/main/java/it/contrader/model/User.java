package it.contrader.model;

import java.util.Date;

public class User {
	protected int iduser;
	protected String username;
	protected String password;
	protected String usertype;
	
	public User() {}
	
	public User (String username, String password, String usertype) {
		this.username = username;
		this.password = password;
		this.usertype = usertype;
	}

	public int getUserId() {
		return iduser;
	}
	public void setUserId(int userId) {
		this.iduser = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}
	
	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	
	@Override
	public String toString() {
		return  iduser + "\t"  + username +"\t\t" +   password + "\t\t" + usertype;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		User other = (User) obj;
		
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		
		if (iduser != other.iduser)
			return false;
		
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		
		return true;
	}

}
