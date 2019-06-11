package it.contrader.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.contrader.model.Project;
import it.contrader.model.Task;

import java.util.List;
import javax.transaction.Transactional;

public interface TaskRepository extends JpaRepository<Task, Integer>{
	public List<Task> findAllByProject(Project project);
	
	@Modifying
	@Transactional
	@Query(value= "INSERT INTO Task (Task, DataInizio, DataFine, IdProject) VALUES (:taskTask, :taskDataInizio, :taskDataFine, :IdProject)", nativeQuery=true)
	public void insertTask(@Param("taskTask") String taskTask, 
						   @Param("taskDataInizio") String taskDataInizio,
						   @Param("taskDataFine") int taskDataFine,
						   @Param("IdProject") int IdProject);
}
