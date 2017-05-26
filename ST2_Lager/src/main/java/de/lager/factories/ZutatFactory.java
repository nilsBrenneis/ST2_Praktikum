package de.lager.factories;

import org.springframework.stereotype.Component;

import de.lager.entities.Bestand;
import de.lager.entities.Zutat;
import de.lager.entities.Zutatenkategorie;

@Component
public class ZutatFactory {
	
    public ZutatFactory() {}
    
	public Zutat createZutat(String bezeichnung, double menge, double mindestbestand, String kategorie) {
		
		Bestand bestand =  new Bestand(menge, mindestbestand);
		Zutat neueZutat = new Zutat(bezeichnung, bestand,new Zutatenkategorie(kategorie));
		bestand.setZutat(neueZutat);
		return neueZutat;
		
	}
}
