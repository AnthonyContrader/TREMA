package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.SubTask;

@Repository
@Transactional
public interface SubTaskRepository extends CrudRepository<SubTask, Long> {

}
