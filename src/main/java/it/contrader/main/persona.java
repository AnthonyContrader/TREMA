package it.contrader.main;

public class persona {
	//private int Id_Persona;  //non fatto
	private String nome;
	private String cognome;
	private String via;
	private String nrCivico;
	private String telefono;
	private String citta;
	private String cap;
	//private int idNazione;  //non fatto
	private String email;
	private String sesso;
	private String dataNascita;
	
	//inizio set
	
	public void set_nome(String nome) {
		this.nome=nome;
	}
	public void set_cognome(String cognome) {
		this.cognome=cognome;
	}
	public void set_via(String via) {
		this.via=via;
	}
	public void set_nrCivico(String nrCivico) {
		this.nrCivico=nrCivico;  		
	}
	public void set_telefono(String telefono) {
		this.telefono=telefono;  		
	}
	public void set_citta(String citta) {
		this.citta=citta;  		
	}
	public void set_cap(String cap) {
		this.cap=cap;  		
	}
	public void set_email(String email) {
		this.email=email;  		
	}
	public void set_sesso(String sesso) {
		this.sesso=sesso;  		
	}
	public void set_dataNascita(String dataNascita) {
		this.dataNascita=dataNascita;
	}
	
	//fine set
	
	public String get_nome() {	return this.nome;	}
	public String get_cognome() {	return this.cognome;	}
	public String get_via() {		return this.via;	}
	public String get_nrCivico() {	return this.nrCivico;	}
	public String get_telefono() {	return this.telefono;	}
	public String get_citta() {	return this.citta;	}
	public String get_cap() {	return this.cap;	}
	public String get_email() {	return this.email;	}
	public String get_sesso() {	return this.sesso;	}
	public String get_dataNascita() {	return this.dataNascita;	}
}
