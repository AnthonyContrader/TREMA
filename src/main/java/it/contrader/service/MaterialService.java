package it.contrader.service;

import java.util.*;
import it.contrader.model.*;
import it.contrader.dao.*;

public class MaterialService {
	
	private MaterialDAO materialDAO;
	
	public MaterialService() {
		this.materialDAO=new MaterialDAO();
	}
	
	public List<Material> getAllMaterial(){
		return this.materialDAO.getAllMaterial();
	}
	
	public Material readMaterial(int idmaterial) {
		return this.materialDAO.readMaterial(idmaterial);
	}
	
	public boolean insertMaterial(Material hrModel) {
		return this.materialDAO.insertMaterial(hrModel);
	}
		
	public boolean deleteMaterial(int materialId) {
		return this.materialDAO.deleteMaterial(materialId);
	}
	
	public boolean insertMaterial(int idmaterial, String tipo, int quantita, int idHr){
		Material mat=new Material(idmaterial, tipo, quantita, idHr);
		return materialDAO.insertMaterial(mat);
	}
	
	public boolean updateMaterial(int idmaterial, String tipo, int idHr, int quantita) {
		Material mat=new Material(idmaterial, tipo, quantita, idHr);
		mat.setidMaterial(idmaterial);
		return materialDAO.updateMaterial(mat);			
}
}
