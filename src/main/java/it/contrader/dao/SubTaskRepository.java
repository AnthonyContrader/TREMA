package it.contrader.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.SubTask;
import it.contrader.model.Task;

public interface SubTaskRepository extends CrudRepository<SubTask, Integer> {
	public List<SubTask> findAllByTask(Task task);
}
