package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.DipMaterial;
import it.contrader.model.Dipendenti;
import it.contrader.model.Material;

import java.util.List;

public interface DipMaterialRepository extends CrudRepository<DipMaterial, Integer> {
	public List<DipMaterial> findAllByMaterial(Material material);
	public List<DipMaterial> findAllByDipendenti(Dipendenti dipendenti);
}
 