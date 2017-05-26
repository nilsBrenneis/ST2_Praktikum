package de.lager.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Zutatenkategorie {
	private String kategorie;
    
    
    
    protected Zutatenkategorie() {
    	
    }
    
    
	public Zutatenkategorie(String kategorie) {
		super();
		this.kategorie = kategorie;
	}

	public String getKategorie() {
		return kategorie;
	}
	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}
}
