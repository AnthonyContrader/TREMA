package it.contrader.dto;

/**
 * Il DTO (Data transfer object) è un ponte che ci permette di nascondere le
 * informazioni principali del nostro model
 * 
 */
public class UsersDTO {

	private Integer iduser;
	private String username;
	private String password;
	private String usertype;

	public UsersDTO(Integer iduser, String username, String password, String usertype) {
		super();
		this.iduser = iduser;
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
