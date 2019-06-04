package it.contrader.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Dipendenti;
import it.contrader.model.User;

public interface DipendentiRepository extends CrudRepository<Dipendenti, Integer> {

	public List<Dipendenti> findAllByUser(User user);
}
 