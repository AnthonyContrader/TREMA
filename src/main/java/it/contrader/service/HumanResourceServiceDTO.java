package it.contrader.service;

import java.util.ArrayList;
import java.util.List;

import it.contrader.converter.HumanResourceConverter;
import it.contrader.dao.HumanResourceDAO;
import it.contrader.dto.HumanResourceDTO;
import it.contrader.model.HumanResource;

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
	public List<HumanResourceDTO> getAllHr() {

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
