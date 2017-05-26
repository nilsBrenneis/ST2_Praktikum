package de.lager;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import de.lager.entities.*;
import de.lager.factories.*;
import de.lager.repositories.*;

@Component
public class SampleData implements ApplicationListener<ContextRefreshedEvent> {  
    
	@Autowired
	private MitarbeiterRepository mitarbeiterRepository;
	@Autowired
    private ZutatRepository zutatRepository;
	@Autowired
	private MindestbestandsaenderungRepository mindestbestandsaenderungRepository;
	@Autowired
	private BestandsaenderungRepository bestandsaenderungRepository;
	
	
    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {

    	createData();
    }
    public SampleData() {
	
    }
    
    public void createData(){
    	
    	Set<Privileg> mitarbeiter = new HashSet<Privileg>();
    	mitarbeiter.add(new Privileg("Bestände verändern"));
    	
    	Set<Privileg> chefkoch = new HashSet<Privileg>();
    	chefkoch.add(new Privileg("MB setzen"));
    	chefkoch.add(new Privileg("Bestände verändern"));
    	
    	Set<Privileg> manager = new HashSet<Privileg>();
    	manager.add(new Privileg("MB setzen"));
    	manager.add(new Privileg("Bestände verändern"));
    	manager.add(new Privileg("MB einsehen"));
    	
    	mitarbeiterRepository.save(new Mitarbeiter("Max","Mustermann","maxmu", new Date(),manager));
    	mitarbeiterRepository.save(new Mitarbeiter("Chef","Koch","chef", new Date(),chefkoch));
    	mitarbeiterRepository.save(new Mitarbeiter("Horst","Heinrich","hohe",new Date(),mitarbeiter));
    	
    	zutatRepository.save(new ZutatFactory().createZutat("Kartoffeln", 1,2,"Nachtschattengewächse"));
    	zutatRepository.save(new ZutatFactory().createZutat("Tomaten", 5000, 200, "Nachtschattengewächse"));
    	zutatRepository.save(new ZutatFactory().createZutat("Karotten", 400, 100, "Gemüse"));
    	zutatRepository.save(new ZutatFactory().createZutat("Rindersteak", 300, 80, "Fleisch"));
    	zutatRepository.save(new ZutatFactory().createZutat("Riesling", 70, 50, "Weißwein"));
    	
    	
    	Mindestbestandsaenderung mb1=	new Mindestbestandsaenderung(new Date(), 2000, zutatRepository.findOneByBezeichnung("Kartoffel"));
    	mindestbestandsaenderungRepository.save(mb1);
    	
    	Bestandsaenderung b1 = new Bestandsaenderung(new Date(),50, zutatRepository.findOneByBezeichnung("Kartoffel"));
    	bestandsaenderungRepository.save(b1);
    	
    	System.out.println(mitarbeiterRepository.findByVorname("Max"));
    		
    }
    
    

}
