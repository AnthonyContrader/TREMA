package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.DipMaterial;
import it.contrader.model.Dipendenti;
import it.contrader.model.Material;

import java.util.List;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface MaterialRepository extends CrudRepository<Material, Long> {
	public List<Material> findAll();
}
 