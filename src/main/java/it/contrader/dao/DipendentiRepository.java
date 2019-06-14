package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Dipendenti;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface DipendentiRepository extends CrudRepository<Dipendenti, Long> {

}
 