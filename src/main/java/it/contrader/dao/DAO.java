package it.contrader.dao;

import java.util.List;

import it.contrader.model.Task;

//T = entity
public interface DAO<T> {
	
	public List<T> getAll();
	
	public List<T> getAllBy(Object o);
	
	public List<T> getAllBy(Integer id, String Descrizione);

	public T read(int id);
	
	public T read(String param1, String param2);
	
	public boolean insert(T t);
	
	public boolean update(T t);
	
	public boolean delete(T t);
}
