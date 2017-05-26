package de.lager.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Bestandsaenderung {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bestandsaenderung_id;
    private Date datum;
    private double mengenaenderung;
    @ManyToOne
    private Zutat zutat;
    
    
    protected Bestandsaenderung() {
    	
    }
    
    
	public Bestandsaenderung( Date datum, double mengenaenderung, Zutat zutat) {
		this.datum = datum;
		this.mengenaenderung = mengenaenderung;
		this.zutat = zutat;
	}


	public long getId() {
		return bestandsaenderung_id;
	}
	public void setId(long id) {
		this.bestandsaenderung_id = id;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public double getMengenaenderung() {
		return mengenaenderung;
	}
	public void setMengenaenderung(double mengenaenderung) {
		this.mengenaenderung = mengenaenderung;
	}
	public Zutat getZutat() {
		return zutat;
	}
	public void setZutat(Zutat zutat) {
		this.zutat = zutat;
	}
}
