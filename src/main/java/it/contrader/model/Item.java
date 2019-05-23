package it.contrader.model;

public class Item {

	int id;
	boolean stato;
	int codice;
	String descrizione;
	String itemtype;

	public Item() {}

	public Item(int codice, String descrizione) {
		this.codice = codice;
		this.descrizione = descrizione;		
	}

	public int getItemId() {
		return id;
	}

	public void setItemId(int itemId) {
		this.id = itemId;
	}

	public boolean getStato() {
		return stato;
	}

	public void setStato(boolean stato) {
		this.stato = stato;
	}

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getItemtype() {
		return itemtype;
	}

	public void setItemtype(String itemtype) {
		this.itemtype = itemtype;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", stato=" + stato + ", codice=" + codice + ", descrizione=" + descrizione
				+ ", itemtype=" + itemtype + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (codice != other.codice)
			return false;
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		if (id != other.id)
			return false;
		if (itemtype == null) {
			if (other.itemtype != null)
				return false;
		} else if (!itemtype.equals(other.itemtype))
			return false;
		if (stato != other.stato)
			return false;
		return true;
	}

}