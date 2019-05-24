package it.contrader.view.material;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class MaterialUpdateView extends AbstractView{
	
	private int idmaterialtoupdate;
	private String tipotoupdate;
	private int idHRtoupdate;
	private Request request;
	
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
		idmaterialtoupdate=Integer.parseInt(getInput().toString());
		System.out.println("Inserire la nuova tipologia:");
		tipotoupdate=getInput().toString();
		System.out.println("Inserire il nuovo ID del dipendente");
		idHRtoupdate=Integer.parseInt(getInput().toString());
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("idMaterial", idmaterialtoupdate);
		request.put("tipo", tipotoupdate);
		request.put("idHR", idHRtoupdate);
		request.put("mode", "UPDATE");
		MainDispatcher.getInstance().callAction("Material", "doControl", request);


	}

}