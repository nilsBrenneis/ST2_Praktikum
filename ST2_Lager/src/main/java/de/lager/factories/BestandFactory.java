package de.lager.factories;

import java.util.Date;

import de.lager.entities.Bestand;
import de.lager.entities.Bestandsaenderung;
import de.lager.entities.Mindestbestandsaenderung;
import de.lager.entities.Zutat;

public class BestandFactory {

	public BestandFactory(){
		
	}
	
	public Bestand createBestand(Zutat zutat, double menge, double mindestbestand, String mengeneinheit){
		
		Bestand bestand = new Bestand(menge, mindestbestand,mengeneinheit,zutat);
		Bestandsaenderung bestandsaenderung = new Bestandsaenderung(new Date(), menge,bestand);
		Mindestbestandsaenderung mindestbestandsaenderung = new Mindestbestandsaenderung(new Date(), mindestbestand,bestand);
		
		
		return bestand;
	}
	
}

