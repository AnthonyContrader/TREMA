package it.contrader.view.material;

import it.contrader.controller.*;
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Material;
import it.contrader.view.AbstractView;

public class MaterialReadView extends AbstractView{
	private int idmaterial;
	private Request request;
	
	public MaterialReadView() {
		new MaterialController();
	}

	@Override
	public void showResults(Request request) {
		if (request != null) {
			Material material = (Material) request.get("material");
			System.out.println(material);
			MainDispatcher.getInstance().callView("Material", null);
		}

	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID del materiale");
		idmaterial = Integer.parseInt(getInput());

	}

	@Override
	public void submit() {
		request = new Request();
		request.put("idmaterial", idmaterial);
		request.put("mode", "READ");
		MainDispatcher.getInstance().callAction("Material", "doControl", request);

	}
	
}
