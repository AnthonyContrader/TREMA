package it.contrader.dao;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.DipMaterial;
import it.contrader.model.SubTask;
import it.contrader.model.Team;

@Repository
@Transactional
public interface TeamRepository extends CrudRepository<Team, Long> {
	public List<Team> findAllBySubTask(SubTask subTask);
	public List<Team> findAllByDipMaterial(DipMaterial dipMaterial);
}