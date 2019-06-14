package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Task;

@Repository
@Transactional
public interface TaskRepository extends CrudRepository<Task,  Long> {
	
}
