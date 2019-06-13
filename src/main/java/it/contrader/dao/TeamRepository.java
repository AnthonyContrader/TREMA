package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;
import it.contrader.model.Team;
import it.contrader.model.SubTask;
import it.contrader.model.DipMaterial;

import java.util.List;

public interface TeamRepository extends CrudRepository<Team, Integer> {
    public List<Team> findAllBySubTask(SubTask subTask);
    public List<Team> findAllByDipMaterial(DipMaterial dipMaterial);
}