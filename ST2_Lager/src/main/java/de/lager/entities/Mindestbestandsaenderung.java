package de.lager.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Mindestbestandsaenderung {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long mindestbestandsaenderung_id;
    private Date datum;
    private double mindestbestand;
    @ManyToOne
    private Zutat zutat;
    
    
    
    protected Mindestbestandsaenderung() {
    	
    }
    
    
	public Mindestbestandsaenderung(Date datum, double mindestbestand, Zutat zutat) {
		super();
		this.datum = datum;
		this.mindestbestand = mindestbestand;
		this.zutat = zutat;
	}


	public long getId() {
		return mindestbestandsaenderung_id;
	}
	public void setId(long id) {
		this.mindestbestandsaenderung_id = id;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public double getMindestbestand() {
		return mindestbestand;
	}
	public void setMindestbestand(double mindestbestand) {
		this.mindestbestand = mindestbestand;
	}
	public Zutat getZutat() {
		return zutat;
	}
	public void setZutat(Zutat zutat) {
		this.zutat = zutat;
	}
}
