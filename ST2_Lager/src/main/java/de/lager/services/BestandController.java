package de.lager.services;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import de.lager.entities.Bestand;
import de.lager.entities.Zutat;
import de.lager.factories.BestandFactory;
import de.lager.repositories.BestandRepository;
import de.lager.repositories.ZutatRepository;

@RestController
public class BestandController {
 
    @Autowired
    private ZutatRepository zutatRepository;
    @Autowired 
    private BestandRepository bestandRepository;
    
    /**
     * Liste des kompletten Besetands
     * @return
     */
    @RequestMapping(path = "/kunden", method = RequestMethod.GET)
    public List<Zutat> getAllZutaten() {
		return (List<Zutat>) zutatRepository.findAll();
    }
	
    /**
     * Bestand einzelner Zutat einsehen
     * @return
     */
    @RequestMapping(path="/bestand/zutat/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getZutatById(@PathVariable("id") Long id ) {
		Zutat z = zutatRepository.findOne(id);
		if (z == null) return ResponseEntity.notFound().build();
		else return ResponseEntity.ok().body(z);
	}

    /**
     * Zutat ändern
     * @return
     */
    @RequestMapping(path="/zutat/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> setZutatById(@RequestParam Long id,  @RequestParam("bezeichnung") String bezeichnung, @RequestParam("kategorie") String kategorie) {
		Zutat z = zutatRepository.findOne(id);
		if (z == null) {
			return ResponseEntity.notFound().build();
		}
		else {
			z.setBezeichnung(bezeichnung);
			z.setZutatenkategorie(kategorie);
			zutatRepository.save(z);
			return ResponseEntity.ok().body(z);
		}
	}
    
    /**
     * Bestand einzelner Zutat ändern
     * @return
     */
    @RequestMapping(path="/zutat/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> setZutatById(@RequestParam Long id,  @RequestParam("menge") Double menge, @RequestParam("mindestbestand") Double mindestbestand) {
		Zutat z = zutatRepository.findOne(id);
		if (z == null) {
			return ResponseEntity.notFound().build();
		}
		else {
			Bestand b = z.getBestand();
			b.setMenge(menge);
			b.setMindestbestand(mindestbestand);
			bestandRepository.save(b);
			return ResponseEntity.ok().body(z);
		}
	}
    
    /**
     * Zutat löschen
     * @return
     */
    @RequestMapping(path="/bestand/zutat/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteZutat(@PathVariable("id") Long id) {
		if (zutatRepository.exists(id)) {
			zutatRepository.delete(id);
		    return ResponseEntity.ok().build();
		} 
		else return ResponseEntity.notFound().build();
    }
    
    
    /**
     * Neue Zutat hinzufügen
     * @return
     */
    @RequestMapping(value = "/bestand/zutat/neu", method = RequestMethod.POST)
    public ResponseEntity <?> persistZutat(
    		@RequestParam("name") String name, @RequestParam("kategorie") String kategorie, @RequestParam("bestand") String bestand, @RequestParam("menge") Double menge, @RequestParam("mindestbestand") Double mindestbestand, @RequestParam("einheit") String einheit) 
    {
    	Zutat z = new Zutat(name, kategorie);
    	Bestand b = new BestandFactory().createBestand(z, menge, mindestbestand, einheit);
    	z.setBestand(b);
    	zutatRepository.save(z);
    	
    	URI location = ServletUriComponentsBuilder.fromCurrentRequestUri()
    					.path("/{id}").buildAndExpand( z.getId() ).toUri();
		return ResponseEntity.created( location ).body( z );
    }
    
}
