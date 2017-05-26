package de.lager.entities;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Zutat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long zutat_id;
    private String bezeichnung;
    @OneToOne(cascade=CascadeType.ALL)
    private Bestand bestand;
    @Embedded 
    private Zutatenkategorie zutatenkategorie;
    
    
    protected Zutat() {
    	
    }
    
    
	public Zutat(String bezeichnung, Bestand bestand) {
		this.bezeichnung = bezeichnung;
		this.bestand = bestand;
	}

	
	public Zutat(String bezeichnung, Bestand bestand,Zutatenkategorie kategorie) {
		this.bezeichnung = bezeichnung;
		this.bestand = bestand;
		this.zutatenkategorie=kategorie;
	}
	
	
	public long getId() {
		return zutat_id;
	}
	public void setId(long id) {
		this.zutat_id = id;
	}
	public String getBezeichnung() {
		return bezeichnung;
	}
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	public Bestand getBestand() {
		return bestand;
	}
	public void setBestand(Bestand bestand) {
		this.bestand = bestand;
	}
	public Zutatenkategorie getZutatenkategorie() {
		return zutatenkategorie;
	}
	public void setZutatenkategorie(Zutatenkategorie zutatenkategorie) {
		this.zutatenkategorie = zutatenkategorie;
	}

	
}
