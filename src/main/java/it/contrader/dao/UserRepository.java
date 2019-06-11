package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;
import it.contrader.model.User;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

	public User findUserByUserAndPassword(String username,String password);//si deve mettere il nome della variabile nel model
	
	public List<User> findAllByUser(String username);//username
	
}
