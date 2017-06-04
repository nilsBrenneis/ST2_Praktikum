package de.lager.repositories;

import org.springframework.data.repository.CrudRepository;

import de.lager.entities.Privileg;

public interface PrivilegRepository extends CrudRepository<Privileg, Long> {
	Privileg findByBezeichnung(String bezeichnung);
}
