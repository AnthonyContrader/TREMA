package it.contrader.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Material;
import it.contrader.model.Task;

public interface MaterialRepository extends CrudRepository<Material, Integer> {

	public List<Material> findAllByTask(Task task);
}
 