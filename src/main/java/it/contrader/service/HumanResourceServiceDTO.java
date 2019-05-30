package it.contrader.service;
import java.util.ArrayList;
import java.util.List;

import it.contrader.converter.*;
import it.contrader.dao.*;
import it.contrader.dto.*;
import it.contrader.model.*;

public class HumanResourceServiceDTO {


/**
 * Classe che si occupa di interfacciarsi con la persistenza e recuperare
 * attraverso i metodi del Data Access Object le tuple desiderate, Le converte
 * in un oggetto DTO e le restituisce al controller opportuno
 */

	private final HumanResourceDAO hrDAO;

	public HumanResourceServiceDTO() {
		this.hrDAO = new HumanResourceDAO();
	}

	/**
	 * Come vediamo la lista recuperata � di tipo Esempio ma noi la convertiamo in EsempioDTO
	 * Invito chi fa i converter a fare un metodo per convertire direttamente la lista senza farli uno ad uno perch� � sporco e poco efficiente
	 */
	public List<HumanResourceDTO> getAllClient() {

		List<HumanResource> list = hrDAO.getAllHr();
		List<HumanResourceDTO> listDTO = new ArrayList<>();

		for (HumanResource hr : list) {
			listDTO.add(HumanResourceConverter.toDTO(hr));
		}

		return listDTO;
	}
	

	
	public HumanResourceDTO readHr(HumanResourceDTO hr) {
		return HumanResourceConverter.toDTO(this.hrDAO.readHr(HumanResourceConverter.toEntity(hr)));
	}

	public boolean updateHr(HumanResourceDTO clientDTO) {
		return this.hrDAO.updateHr(HumanResourceConverter.toEntity(clientDTO));
		
}
	
	public boolean deleteHr(HumanResourceDTO hr) {
		return this.hrDAO.deleteHr(HumanResourceConverter.toEntity(hr));
		
}
	
	public boolean insertHr(HumanResourceDTO hr) {
		return this.hrDAO.insertHr(HumanResourceConverter.toEntity(hr));
	
}
		
	
	
}
