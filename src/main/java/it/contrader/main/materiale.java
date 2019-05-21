package it.contrader.main;

public class materiale {
	//private int idMateriale; //non fatto
	private String materiale;
	//private int idTipologia; //non fatto
	private String dataAcquisto;
	private String nrSerie;
	private String venditore;
	private String garanzia;
	private String dataScadenza;
	private int nrInventario;
	
	//inizio set
	
	public void set_materiale(String materiale) {
		this.materiale=materiale;
	}
	public void set_dataAcquisto(String dataAcquisto) {
		this.dataAcquisto=dataAcquisto;
	}
	public void set_nrSerie(String nrSerie) {
		this.nrSerie=nrSerie;
	}
	public void set_venditore(String venditore) {
		this.venditore=venditore;
	}
	public void set_garanzia(String garanzia) {
		this.garanzia=garanzia;
	}
	public void set_dataScadenza(String dataScadenza) {
		this.dataScadenza=dataScadenza;
	}
	public void set_nrInventario(int nrInventario) {
		this.nrInventario=nrInventario;
	}
	
	//fine set
	
	public String get_materiale() {	return this.materiale;	}
	public String get_dataAcquisto() {	return this.dataAcquisto;	}
	public String get_nrSerie() {	return this.nrSerie;	}
	public String get_venditore() {	return this.venditore;	}
	public String get_garanzia() {	return this.garanzia;	}
	public String get_dataScadenza() {	return this.dataScadenza;	}
	public int get_nrInventario() {	return this.nrInventario;	}
}

