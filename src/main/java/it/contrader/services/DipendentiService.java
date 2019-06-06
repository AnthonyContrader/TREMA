package it.contrader.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.model.Dipendenti;
import it.contrader.model.Task;
import it.contrader.dao.DipendentiRepository;
import it.contrader.dto.DipendentiDTO;
import it.contrader.dto.ProjectDTO;
import it.contrader.dto.TaskDTO;
import it.contrader.converter.ConverterDipendenti;
import it.contrader.converter.ConverterProject;
import it.contrader.converter.ConverterTask;
import it.contrader.converter.ConverterUser;
import it.contrader.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class DipendentiService {
	private final DipendentiRepository dipendentiRepository;
	
	@Autowired
	public DipendentiService(DipendentiRepository dipendentiRepository) {
		this.dipendentiRepository = dipendentiRepository;
	}
	
	public List<DipendentiDTO> getListaDipendentiDTO(){
		return ConverterDipendenti.toListDTO((List<Dipendenti>) dipendentiRepository.findAll());
	}
	
	public DipendentiDTO getDipendentiDTOById(Integer id) {
		return ConverterDipendenti.toDTO(dipendentiRepository.findById(id).get());
	}
	
	public List<DipendentiDTO> getListaDipendentiDTOByTask(TaskDTO taskDTO) {
		return ConverterDipendenti.toListDTO((List<Dipendenti>) dipendentiRepository.findAllByTask(ConverterTask.toEntity(taskDTO)));
	}
	
	public boolean insertDipendenti(DipendentiDTO dipendentiDTO) {
		return dipendentiRepository.save(ConverterDipendenti.toEntity(dipendentiDTO)) != null;
	}
	
	public boolean updateDipendenti(DipendentiDTO dipendentiDTO) {
		return dipendentiRepository.save(ConverterDipendenti.toEntity(dipendentiDTO)) != null;
	}
	
	public void deleteDipendentiById(Integer id) {
		dipendentiRepository.deleteById(id);
	}

	public List<DipendentiDTO> findDipendentiDTOByTask(Task task) {
		
		final List<Dipendenti> listDipendenti = dipendentiRepository.findAllByTask(task);
		final List<DipendentiDTO> listDipendentiDTO = new ArrayList<>();
		listDipendenti.forEach(i -> listDipendentiDTO.add(ConverterDipendenti.toDTO(i)));
		return listDipendentiDTO;
	}
}