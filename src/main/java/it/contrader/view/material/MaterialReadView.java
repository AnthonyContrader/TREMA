package it.contrader.view.material;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Material;
import it.contrader.view.AbstractView;

public class MaterialReadView extends AbstractView{
	
	private int idHR;
	private int idmaterial;
	private Request request;

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
		System.out.println("Inserisci l'ID del building:");
		idHR = Integer.parseInt(getInput());
		System.out.println("Inserisci l'ID dell'ambiente");
		idmaterial = Integer.parseInt(getInput());

	}

	@Override
	public void submit() {
		request = new Request();
		request.put("idHR", idHR);
		request.put("idmaterial", idmaterial);
		request.put("mode", "READ");
		MainDispatcher.getInstance().callAction("Matrial", "doControl", request);

	}
	
}
