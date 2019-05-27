package it.contrader.service;

import java.util.List;
import it.contrader.dao.*;
import it.contrader.model.*;

public class HRService {
	
	private HumanResourceDAO hrDao;
	
	public HRService() {
		this.hrDao=new HumanResourceDAO();
	}
	
	public List<HumanResource> getAllHR(){
		return this.hrDao.getAllHR();
	}
	
	public boolean insertHR(HumanResource hrModel) {
		return this.hrDao.insertHR(hrModel);
	}
	
	public HumanResource readHR(int id) {
		return this.hrDao.readHR(id);
	}
	
	public boolean deleteHR(int id) {
		return this.hrDao.deleteHR(id);
	}
	
	public boolean insertHR(int id, String name, String surname, int iduser) {
		HumanResource newHr = new HumanResource(id, iduser, surname, name);
		return hrDao.insertHR(newHr);
	}
	
	public boolean updateHR(int id, String name, String surname, int iduser) {
		HumanResource newHr = new HumanResource(id, iduser, surname, name);
		newHr.setidHR(id);
		return this.hrDao.updateHR(newHr);
	}
}
