package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;
import it.contrader.model.Team;
import java.util.List;

public interface TeamRepository extends CrudRepository<Team, Integer> {

    public List<Team> findAllByTeam(int IdTeam);
	
}