package it.contrader.model;

public class HumanResource {

	private int idHR;
	private int idUser;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private int speciality;

    public HumanResource(int idHR, int idUser,  String name, String surname, String email, String phone, int speciality) {
    	this.idHR = idHR;
    	this.idUser=idUser;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.speciality = speciality;
    }
    
    public int getidHR() {
        return idHR;
    }

    public void setidHR(int idHR) {
        this.idHR = idHR;
    }
    
    public int getidUser() {
    	return this.idUser;
    }
    
    public void setidUser(int idUser) {
    	this.idUser=idUser;
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
        return "ID: " + idHR + "\nNome: "+name+"\nCognome: "+surname+"\nEmail: "+email+"\nTelefono: "+phone+"\nRank: "+speciality+"\n";
    }
}
