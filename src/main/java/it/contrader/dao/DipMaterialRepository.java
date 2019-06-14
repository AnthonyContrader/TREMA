package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.DipMaterial;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface DipMaterialRepository extends CrudRepository<DipMaterial, Long> {
	
}
 