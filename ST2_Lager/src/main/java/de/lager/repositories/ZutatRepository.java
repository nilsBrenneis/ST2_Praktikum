package de.lager.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.lager.entities.Zutat;

public interface ZutatRepository extends CrudRepository<Zutat, Long>{
	List<Zutat> findByBezeichnung(String bezeichnung);
	Zutat findOneByBezeichnung(String bezeichnung);
}

