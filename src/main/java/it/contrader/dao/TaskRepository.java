package it.contrader.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Project;
import it.contrader.model.Task;

public interface TaskRepository extends CrudRepository<Task, Integer>{
	public List<Task> findAllByProject(Project project);
}
