package it.contrader.dao;
 
import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import it.contrader.model.Project;
import it.contrader.model.User;

@Repository
@Transactional
public interface ProjectRepository extends CrudRepository<Project, Long>{
	public List<Project> findAllByUser(User user);
}
