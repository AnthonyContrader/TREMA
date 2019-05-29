package it.contrader.service;

import java.util.ArrayList;
import java.util.List;

import it.contrader.converter.HumanResourceConverter;
import it.contrader.dao.*;
import it.contrader.dto.HumanResourceDTO;
import it.contrader.model.*;

public class HumanResourceServiceDTO {
	
	private HumanResourceDAO hrDao;
	
	public HumanResourceServiceDTO() {
		this.hrDao=new HumanResourceDAO();
	}
	
	public List<HumanResourceDTO> getAllHR(){
		List<HumanResource> list=hrDao.getAllHR();
		List<HumanResourceDTO> listDTO=new ArrayList<>();
		for(HumanResource hr : list) {
			listDTO.add(HumanResourceConverter.toDTO(hr));
		}
		return listDTO;
	}
	
	public HumanResourceDTO readHR(HumanResourceDTO hrDto) {
		return HumanResourceConverter.toDTO(this.hrDao.readHR(HumanResourceConverter.toEntity(hrDto)));
	}
	
	public boolean updateHR(HumanResourceDTO hrDto) {
		return this.hrDao.updateHR(HumanResourceConverter.toEntity(hrDto));
	}
	
	public boolean deleteHR(HumanResourceDTO hrDto) {
		return this.hrDao.deleteHR(HumanResourceConverter.toEntity(hrDto));
	}
	
	public boolean insertHR(HumanResourceDTO hrDto) {
		return this.hrDao.insertHR(HumanResourceConverter.toEntity(hrDto));
	}
	
	
	
}
