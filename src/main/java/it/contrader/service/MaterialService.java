package it.contrader.service;

import java.util.*;
import it.contrader.model.*;
import it.contrader.dao.*;

public class MaterialService {
	private MaterialDAO materialDAO;
	
	public MaterialService() {
		this.materialDAO=new MaterialDAO();
	}
	
	public List<Material> showAllMaterial(int id){
		return this.materialDAO.showAllMaterial(id);
	}
	
	public Material readMaterial(int idHR, int id, String tipo) {
		return this.materialDAO.readMaterial(idHR, id, tipo);
	}
	
	public boolean insertMaterial(Material materialid) {
		return this.materialDAO.insertMaterial(materialid);
	}
	
	public boolean deleteMaterial(int materialId) {
		return this.materialDAO.deleteMaterial(materialId);
	}
	
	public boolean updateMaterial(Material materialToUpdate) {
		return this.materialDAO.updateMaterial(materialToUpdate);
	}
}
