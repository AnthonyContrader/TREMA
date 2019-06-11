 package it.contrader.dao;
 
 import org.springframework.data.repository.CrudRepository;
 import it.contrader.model.*;
 import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Integer>{

	public List<Project> findAllByUser(User user);
}
