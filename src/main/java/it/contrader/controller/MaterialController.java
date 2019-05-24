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
			Ambiente ambiente = mService.readAmbiente(hrid,materialid);
			request = new Request();
			request.put("ambiente", ambiente);
			MainDispatcher.getInstance().callView(sub_package + "AmbienteRead", request);

			break;
		case "INSERT":
			hrid = Integer.parseInt(request.get("buildingid").toString());
			tipo = request.get("tipo").toString();
			Ambiente ambienteToInsert = new Ambiente(tipo,hrid);
			mService.insertAmbiente(ambienteToInsert);
			request = new Request();
			request.put("mode", "ok");
			MainDispatcher.getInstance().callView(sub_package + "AmbienteInsert", request);

			break;
		case "DELETE":
			materialid = Integer.parseInt(request.get("materialid").toString());
			mService.deleteAmbiente(materialid);
			request = new Request();
			request.put("mode", "ok");
			MainDispatcher.getInstance().callView(sub_package + "AmbienteDelete", request);
			break;

		case "UPDATE":
			hrid = Integer.parseInt(request.get("buildingid").toString());
			id = Integer.parseInt(request.get("id").toString());
			tipo = (String) request.get("tipo");
			Ambiente ambienteToUpdate = new Ambiente(tipo,hrid);
			ambienteToUpdate.setId(id);
			mService.updateAmbiente(ambienteToUpdate);
			request = new Request();
			request.put("mode", "ok");
			MainDispatcher.getInstance().callView(sub_package +  "AmbienteUpdate", request);
			break;

		case "LISTAMBIENTE":
			hrid=Integer.parseInt(request.get("buildingid").toString());
			List<Ambiente> listambiente =  mService.showAllAmbiente(hrid);
			request.put("listambiente", listambiente);
			request.put("mode", "ok");
			MainDispatcher.getInstance().callView("Ambiente", request);
			break;

		case "GETCHOICE":
			switch (choice.toUpperCase()) {
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "AmbienteRead", null);
				break;
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "AmbienteInsert", null);
				break;
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "AmbienteUpdate", null);
				break;
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "AmbienteDelete", null);
				break;
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;
			case "B":
				MainDispatcher.getInstance().callView("HomeOperatore", null);
				break;
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
	}
}
