package it.contrader.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import it.contrader.model.Task;
import it.contrader.model.Material;
import java.util.List;

public interface MaterialRepository extends CrudRepository<Material, Integer> {
	public List<Material> findAllByIdDipMaterial(IdDipMaterial IdDipMaterial);
}
 