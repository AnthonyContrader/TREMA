package it.contrader.controller;

import java.util.List;

import it.contrader.main.MainDispatcher;
import it.contrader.model.*;
import it.contrader.service.*;

public class MaterialController implements Controller{

	private static String sub_package = "material.";

	private  MaterialService mService;//


	private int hrid;//

	private int materialid;//

	private String tipo;//

	int id;//


	public MaterialController() {
		this.mService = new MaterialService();
	}


	@Override
	public void doControl(Request request) {
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");




		switch(mode.toUpperCase()) {
		case "READ":
			hrid = Integer.parseInt(request.get("idHR").toString());
			materialid =Integer.parseInt(request.get("materialid").toString());
			tipo=request.get("tipo").toString();
			Material material = mService.readMaterial(hrid,materialid,tipo);
			request = new Request();
			request.put("material", material);
			MainDispatcher.getInstance().callView(sub_package + "MaterialRead", request);

			break;
		case "INSERT":
			hrid = Integer.parseInt(request.get("materialid").toString());
			tipo = request.get("tipo").toString();
			Material materialToInsert = new Material(materialid, hrid, tipo);
			mService.insertMaterial(materialToInsert);
			request = new Request();
			request.put("mode", "ok");
			MainDispatcher.getInstance().callView(sub_package + "MaterialInsert", request);

			break;
		case "DELETE":
			materialid = Integer.parseInt(request.get("materialid").toString());
			mService.deleteMaterial(materialid);
			request = new Request();
			request.put("mode", "ok");
			MainDispatcher.getInstance().callView(sub_package + "materialDelete", request);
			break;

		case "UPDATE":
			hrid = Integer.parseInt(request.get("hrid").toString());
			id = Integer.parseInt(request.get("id").toString());
			tipo = (String) request.get("tipo");
			Material materialToUpdate = new Material(materialid, hrid, tipo);
			materialToUpdate.setidMaterial(id);
			mService.updateMaterial(materialToUpdate);
			request = new Request();
			request.put("mode", "ok");
			MainDispatcher.getInstance().callView(sub_package +  "MaterialUpdate", request);
			break;

		case "MATERIALLIST":
			hrid=Integer.parseInt(request.get("materialid").toString());
			List<Material> listamaterial =  mService.showAllMaterial(hrid);
			request.put("listamaterial", listamaterial);
			request.put("mode", "ok");
			MainDispatcher.getInstance().callView("Material", request);
			break;

		case "GETCHOICE":
			switch (choice.toUpperCase()) {
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "MaterialRead", null);
				break;
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "MaterialInsert", null);
				break;
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "MaterialUpdate", null);
				break;
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "MaterialDelete", null);
				break;
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
	}
}
