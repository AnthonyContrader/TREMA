package it.contrader.dao;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.SubTask;
import it.contrader.model.Task;

@Repository
@Transactional
public interface SubTaskRepository extends CrudRepository<SubTask, Long> {
	public List<SubTask> findAllByTask(Task task);
}
