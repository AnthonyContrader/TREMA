package it.contrader.model;

public class HumanResource {

	private int id;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private int speciality;

    public HumanResource(int id, String username, String password,String name, String surname, String email, String phone, int speciality) {
    	this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.speciality = speciality;
    }
    
    public int getID() {
        return id;
    }

    public void setID(int id) {
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
    
    public String getName() {
    	return this.name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public String getSurname() {
    	return this.surname;
    }
    
    public void setSurname(String surname) {
    	this.surname = surname;
    }
    
    public String getEmail() {
    	return this.email;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }
    
    public String getPhone() {
    	return this.phone;
    }
    
    public void setPhone(String phone) {
    	this.phone = phone;
    }

    public int getSpeciality() {
        return speciality;
    }

    public void setSpeciality(int speciality) {
        this.speciality = speciality;
    }

    public boolean isAdmin() {
    	return (getSpeciality() == 1 ? true : false);
    }
    @Override
    public String toString() {
        return "ID: " + id + "\nNome: "+name+"\nCognome: "+surname+"\nEmail: "+email+"\nTelefono: "+phone+"\nRank: "+speciality+"\n";
    }
}
