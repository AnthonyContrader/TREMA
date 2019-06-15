package it.contrader.dao;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Project;
import it.contrader.model.Task;

@Repository
@Transactional
public interface TaskRepository extends CrudRepository<Task,  Long> {
	public List<Task> findByProject(Project project);
}
