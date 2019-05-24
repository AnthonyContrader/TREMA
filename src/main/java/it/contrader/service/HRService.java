package it.contrader.service;

import java.util.List;

import it.contrader.model.HumanResource;

public class HRService {
	public HRService hrserviceDAO;
	
	public HRService() {
		this.hrserviceDAO=new HRService();
	}
	
	public List<HumanResource> getAllHR(){
		return this.hrserviceDAO.getAllHR();
	}
	
	public HRService readHR(int id) {
		return this.hrserviceDAO.readHR(id);
	}
	
	public boolean insertHR(HumanResource hrService) {
		return this.hrserviceDAO.insertHR(hrService);
	}
	
	public boolean deleteHR(int id) {
		return this.hrserviceDAO.deleteHR(id);
	}
	
	public boolean updateHR(HumanResource hr) {
		return this.hrserviceDAO.updateHR(hr);
	}
}
