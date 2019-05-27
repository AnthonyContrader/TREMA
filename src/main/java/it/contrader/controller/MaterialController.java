package it.contrader.controller;

import java.util.List;

import it.contrader.main.MainDispatcher;
import it.contrader.model.*;
import it.contrader.service.*;

public class MaterialController implements Controller{

	private static String sub_package = "material.";
	private MaterialService materialService;

	public MaterialController() {
		this.materialService = new MaterialService();
	}


	@Override
	public void doControl(Request request) {
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");

		int idMaterial;
		int idHr = 0;
		int quantita = 0;
		String tipo = null;

		switch (mode) {
		case "READ":
			idMaterial = Integer.parseInt(request.get("idmaterial").toString());
			Material material = materialService.readMaterial(idMaterial);
			request.put("material", material);
			MainDispatcher.getInstance().callView(sub_package + "MaterialRead", request);
			break;
		case "INSERT":
			idMaterial = Integer.parseInt(request.get("idmaterial").toString());
			tipo = request.get("tipo").toString();
			quantita= Integer.parseInt(request.get("quantita").toString());
			idHr = Integer.parseInt(request.get("idHR").toString());
			materialService.insertMaterial(idMaterial,tipo, quantita, idHr);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "MaterialInsert", request);
			break;
		case "DELETE":
			idMaterial = Integer.parseInt(request.get("idmaterial").toString());
			materialService.deleteMaterial(idMaterial);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "MaterialDelete", request);
			break;
		case "UPDATE":
			idMaterial = Integer.parseInt(request.get("idmaterial").toString());
			tipo = request.get("tipo").toString();
			idHr = Integer.parseInt(request.get("idHR").toString());
			quantita = Integer.parseInt(request.get("quantita").toString());
			materialService.updateMaterial(idMaterial, tipo, idHr, quantita);
			request = new Request();
			request.put("mode", "mode");
			
			MainDispatcher.getInstance().callView(sub_package + "MaterialUpdate", request);
			break;
		case "Material":
			List<Material> mlist = materialService.getAllMaterial();
			request.put("material", mlist);
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
			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
	}
}
