package it.contrader.view.material;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class MaterialUpdateView extends AbstractView{

	private int idMaterial;
	private Request request;
	private String tipo;
	private int idHR;

	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("La modifica è andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Material", null);
		}

	}

	@Override
	public void showOptions() {
		System.out.println("Inserire l'ID del materiale da modificare:");
		idMaterial=Integer.parseInt(getInput().toString());
		System.out.println("Inserire la nuova tipologia:");
		tipo=getInput().toString();
		System.out.println("Inserire il nuovo ID del dipendente");
		idHR=Integer.parseInt(getInput().toString());
	}

	@Override
	public void submit() {

		request = new Request();
		request.put("idMaterial", idMaterial);
		request.put("tipo", tipo);
		request.put("idHR", idHR);
		request.put("mode", "UPDATE");
		MainDispatcher.getInstance().callAction("Material", "doControl", request);


	}

}