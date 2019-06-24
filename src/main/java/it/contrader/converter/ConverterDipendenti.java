package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.DipendentiDTO;
import it.contrader.model.Dipendenti;

@Component
public class ConverterDipendenti extends AbstractConverter<Dipendenti, DipendentiDTO> {
	public DipendentiDTO toDTO(Dipendenti dipendenti) {
		DipendentiDTO dipendentiDTO = null;
		
		if (dipendenti != null) {
			dipendentiDTO = new DipendentiDTO();
			dipendentiDTO.setId(dipendenti.getId());
			dipendentiDTO.setNomeDip(dipendenti.getNomeDip());
			dipendentiDTO.setCognomeDip(dipendenti.getCognomeDip());
		}
		
		return dipendentiDTO;
	}
	 
	public Dipendenti toEntity(DipendentiDTO dipendentiDTO) {
		Dipendenti dipendenti = null;
		
		if (dipendentiDTO != null) {
			dipendenti = new Dipendenti();
			dipendenti.setId(dipendentiDTO.getId());
			dipendenti.setNomeDip(dipendentiDTO.getNomeDip());
			dipendenti.setCognomeDip(dipendentiDTO.getCognomeDip());
		}
		
		return dipendenti;	
	}
}