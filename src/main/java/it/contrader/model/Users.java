package it.contrader.model;

<<<<<<< HEAD
/**
 * Classe Model di esempio
 *
 */

public class Users {

	/**
	 * I campi che sono attributi di una certa tabella che vogliamo rappresentare
	 * <br>
	 * Possiamo avere n colonne
	 */
	
	private Integer id;
=======
public class Users {

	private Integer iduser;
>>>>>>> a55be6440364c682e5d9000e8e115f516e6d832b
	private String username;
	private String password;
	private String usertype;

<<<<<<< HEAD
	// Costruttore con parametri
	public Users(Integer id, String username, String password, String ruolo) {
=======
	public Users(String username, String password, String usertype) {
>>>>>>> a55be6440364c682e5d9000e8e115f516e6d832b
		super();
		this.username = username;
		this.password = password;
<<<<<<< HEAD
		this.ruolo = ruolo;
=======
		this.usertype = usertype;

		
>>>>>>> a55be6440364c682e5d9000e8e115f516e6d832b
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
