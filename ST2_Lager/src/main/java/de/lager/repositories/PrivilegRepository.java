package de.lager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.lager.entities.Privileg;

public interface PrivilegRepository extends CrudRepository<Privileg, Long> {
	Privileg findByBezeichnung(String bezeichnung);
}
