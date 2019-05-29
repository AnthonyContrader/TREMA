package it.contrader.dto;

public class UsersDTO implements DTO {



	private Integer id;
	private String username;
	private String password;
	private String usertype;

	public UsersDTO(Integer id, String username, String password, String usertype) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.usertype = usertype;
	}

	public UsersDTO (String username, String password, String usertype) {
		this.username = username;
		this.password = password;
		this.usertype = usertype;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		return username ;
	}
}
