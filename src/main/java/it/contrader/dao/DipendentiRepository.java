package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;
import it.contrader.model.Task;
import it.contrader.model.Dipendenti;
import java.util.List;

public interface DipendentiRepository extends CrudRepository<Dipendenti, Integer> {
	public List<Dipendenti> findAll();
}
 