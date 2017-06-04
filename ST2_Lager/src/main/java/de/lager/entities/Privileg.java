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
import javax.persistence.ManyToMany;

@Entity
public class Privileg {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long privileg_id;
    private String bezeichnung;

    
    
    protected Privileg() {
    	
    }
    
    public Privileg(String bezeichnung){
    	this.bezeichnung=bezeichnung;
    }
    
    public Privileg( String bezeichnung, Set<Mitarbeiter> privilegienInhaber) {
		
		this.bezeichnung = bezeichnung;
		this.privilegienInhaber = privilegienInhaber;
	}


	public long getId() {
		return privileg_id;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	@ManyToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
    private Set<Mitarbeiter> privilegienInhaber = new HashSet<Mitarbeiter>();


    public Set<Mitarbeiter> getPrivilegienInhaber() {
        return Collections.unmodifiableSet(privilegienInhaber);
    }

    public void addPrivilegienInhaber(Mitarbeiter p) {
        if (!privilegienInhaber.contains(p)) {
            privilegienInhaber.add(p);
            p.addNutzerprivilegien(this);
        }
    }

    public void removePrivilegienInhaber (Mitarbeiter p) {
        if (privilegienInhaber.contains(p)) {
            privilegienInhaber.remove(p);
            p.addNutzerprivilegien(this);
        }
    }
}