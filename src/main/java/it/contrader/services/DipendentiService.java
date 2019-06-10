package it.contrader.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.model.Dipendenti;
import it.contrader.dto.DipendentiDTO;
import it.contrader.dao.DipendentiRepository;
import it.contrader.converter.ConverterDipendenti;

import it.contrader.dto.TaskDTO;
import it.contrader.dao.TaskRepository;
import it.contrader.converter.ConverterTask;

import java.util.ArrayList;
import java.util.List;

@Service
public class DipendentiService {
	private final DipendentiRepository dipendentiRepository;
	
	@Autowired
	public TaskRepository taskRepository;
	
	@Autowired
	public DipendentiService(DipendentiRepository dipendentiRepository) {
		this.dipendentiRepository = dipendentiRepository;
	}
	
	public List<DipendentiDTO> getListDipendentiDTO(){
		return ConverterDipendenti.toListDTO((List<Dipendenti>) dipendentiRepository.findAll());
	}
	
	public DipendentiDTO getDipendentiDTOById(Integer idDipendenti) {
		return ConverterDipendenti.toDTO(dipendentiRepository.findById(idDipendenti).get());
	}
	
	public boolean insertDipendenti(DipendentiDTO dipendentiDTO) {
		return dipendentiRepository.save(ConverterDipendenti.toEntity(dipendentiDTO)) != null;
	}
	
	public boolean updateDipendenti(DipendentiDTO dipendentiDTO) {
		return dipendentiRepository.save(ConverterDipendenti.toEntity(dipendentiDTO)) != null;
	}
	
	public void deleteDipendentiById(Integer idDipendenti) {
		dipendentiRepository.deleteById(idDipendenti);
	}

	public List<DipendentiDTO> findDipendentiDTOByTask(TaskDTO taskDTO) {
		final List<Dipendenti> listDipendenti = dipendentiRepository.findAllByTask(ConverterTask.toEntity(taskDTO));
		final List<DipendentiDTO> listDipendentiDTO = new ArrayList<>();
		listDipendenti.forEach(i -> listDipendentiDTO.add(ConverterDipendenti.toDTO(i)));
		return listDipendentiDTO;
	}
}