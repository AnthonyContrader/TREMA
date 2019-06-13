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
	@Autowired
	private DipendentiRepository dipendentiRepository;
	
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
}