package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterDipendenti;
import it.contrader.converter.ConverterUser;
import it.contrader.dao.DipendentiRepository;
import it.contrader.dto.DipendentiDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Dipendenti;

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

	
	public boolean insertDipendenti(DipendentiDTO dipendentiDTO) {
		return dipendentiRepository.save(ConverterDipendenti.toEntity(dipendentiDTO)) != null;
	}
	
	public boolean updateDipendenti(DipendentiDTO dipendentiDTO) {
		return dipendentiRepository.save(ConverterDipendenti.toEntity(dipendentiDTO)) != null;
	}
	
	public void deleteDipendentiById(Integer id) {
		dipendentiRepository.deleteById(id);
	}

	
	public List<DipendentiDTO> findDipendentiDTOByUser( UserDTO userDTO) {
		
		final List<Dipendenti> listDipendenti = dipendentiRepository.findAllByUser(ConverterUser.toEntity(userDTO));
		final List<DipendentiDTO> listDipendentiDTO = new ArrayList<>();
		listDipendenti.forEach(i -> listDipendentiDTO.add(ConverterDipendenti.toDTO(i)));
		return listDipendentiDTO;
	}
}