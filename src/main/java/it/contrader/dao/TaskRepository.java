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
	//public Task findUserByUserUserAndUserPass(String username,String password);
	//public List<Task> findAllByUser(User user);	
	public List<Task> findAllByProject(Project project);
		
	//Tree methods
	public Task findAllByProjectAndTaskFatherIsNull(Project project);
		
	@Modifying
	@Transactional
	@Query(value= "INSERT INTO Tasks (task, data_inizio, data_fine, objective, idproject) VALUES (:task, :data_inizio,:data_fine, :objective, :idprojectId)", nativeQuery=true)
	public void insertTask( @Param("task") String task, 
							@Param("data_inizio") String data_inizio,
							@Param("data_fine") String data_fine,
							@Param("objective") String objective,
							@Param("idproject") int idproject);
	
}
