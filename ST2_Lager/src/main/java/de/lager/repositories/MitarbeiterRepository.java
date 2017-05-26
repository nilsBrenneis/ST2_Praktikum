package de.lager.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.lager.entities.Mitarbeiter;

public interface MitarbeiterRepository extends CrudRepository<Mitarbeiter, Long>{
	List<Mitarbeiter> findByVorname(String vorname);
	List<Mitarbeiter> findByName(String name);
	Mitarbeiter findByBenutzername(String benutzername);
}

