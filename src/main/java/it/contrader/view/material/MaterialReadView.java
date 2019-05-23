package it.contrader.view.material;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.model.*;
import it.contrader.view.AbstractView;

public class MaterialReadView extends AbstractView{
	private int idMaterial;
	private Request request;
	private final String mode="READ";
	@Override
	public void showResults(Request request) {
		if (request != null) {
			Material material = (Material) request.get("material");//forse material con la maiuscola
			System.out.println(material);

			MainDispatcher.getInstance().callView("Material", null);
		}
		
	}
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID del materiale:");
		idMaterial = Integer.parseInt(getInput());
		
	}
	@Override
	public void submit() {
		// TODO Auto-generated method stub
		
	}
}
