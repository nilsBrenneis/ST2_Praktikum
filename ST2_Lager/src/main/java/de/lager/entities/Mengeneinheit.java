package de.lager.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Mengeneinheit {
	//@Id
	//@GeneratedVa	lue(strategy = GenerationType.AUTO)
    //private long mengeneinheit_id;
    private String bezeichnung;
    
    
    
    protected Mengeneinheit() {
    	
    }
    
    
	public Mengeneinheit( String bezeichnung) {
		super();
		this.bezeichnung = bezeichnung;
	}


	public String getBezeichnung() {
		return bezeichnung;
	}
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
}
