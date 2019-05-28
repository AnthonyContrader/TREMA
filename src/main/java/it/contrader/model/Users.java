package it.contrader.model;

public class Users {

	private Integer iduser;
	private String username;
	private String password;
	private String usertype;

	public Users(String username, String password, String usertype) {
		super();
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


}
