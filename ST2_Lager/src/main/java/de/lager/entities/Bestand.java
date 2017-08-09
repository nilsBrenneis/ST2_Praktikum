package de.lager.entities;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Bestand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bestand_id;
    private double menge;
    private double mindestbestand;
    private Mengeneinheit mengeneinheit;
   	@OneToOne(mappedBy="bestand",fetch = FetchType.LAZY)
   	@JsonIgnore
   	private Zutat zutat;
    //test
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private Set<Bestandsaenderung> bestandsaenderungen = new HashSet<Bestandsaenderung>();
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private Set<Mindestbestandsaenderung> mindestbestandsaenderungen = new HashSet<Mindestbestandsaenderung>();
    
    
    protected Bestand() {
    	
    }
    
    
	public Bestand(double menge, double mindestbestand) {
		this.menge = menge;
		this.mindestbestand = mindestbestand;
	}
	
	
	public Bestand(double menge, double mindestbestand, String mengeneinheit,Zutat zutat) {
		this.menge = menge;
		this.mindestbestand = mindestbestand;
		this.mengeneinheit=Mengeneinheit.valueOf(mengeneinheit.toLowerCase());
	}
	
	public enum Mengeneinheit {
		l,kg,ml,g,flaschen,stueck, tonne
	}


	public long getId() {
		return bestand_id;
	}
	public void setId(long id) {
		this.bestand_id = id;
	}
	public double getMenge() {
		return menge;
	}
	public void setMenge(double menge) {
		this.menge = menge;
	}
	public double getMindestbestand() {
		return mindestbestand;
	}
	public void setMindestbestand(double mindestbestand) {
		this.mindestbestand = mindestbestand;
	}
	public Mengeneinheit getMengeneinheit() {
		return mengeneinheit;
	}
	public void setMengeneinheit(Mengeneinheit mengeneinheit) {
		this.mengeneinheit = mengeneinheit;
	}
	
	public Zutat getZutat(){
		return zutat;
	}
	
	public void setZutat(Zutat zutat){
		this.zutat=zutat;
	}
	
	public void addBestandsaenderung(Bestandsaenderung b){
		if(!bestandsaenderungen.contains(b)){
			bestandsaenderungen.add(b);
			b.setBestand(this);
		}
	}
	
	public Set<Bestandsaenderung> getBestandsaenderungen(){
		return Collections.unmodifiableSet(bestandsaenderungen);
	}
	
	public void addMindestbestandsaenderung(Mindestbestandsaenderung b){
		if(!mindestbestandsaenderungen.contains(b)){
			mindestbestandsaenderungen.add(b);
			b.setBestand(this);
		}
	}
	
	public Set<Mindestbestandsaenderung> getMindestbestandsaenderungen(){
		return Collections.unmodifiableSet(mindestbestandsaenderungen);
	}
	
	
}

