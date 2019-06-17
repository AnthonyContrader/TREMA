package it.contrader.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterDipendenti;
import it.contrader.dao.DipendentiRepository;
import it.contrader.dto.DipendentiDTO;
import it.contrader.model.Dipendenti;

@Service
public class DipendentiService extends AbstractService<Dipendenti, DipendentiDTO> {
	@Autowired
	private DipendentiRepository dipendentiRepository;
	
	@Autowired
	private ConverterDipendenti converterDipendenti;
	
	public List<DipendentiDTO> findAllDipendenti() {
		return converterDipendenti.toDTOList(dipendentiRepository.findAll());
	}
}