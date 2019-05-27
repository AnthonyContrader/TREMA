package it.contrader.view.material;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class MaterialUpdateView extends AbstractView{
	
	private int idmaterial;
	private String tipo;
	private int quantita;
	private int idHR;
	private Request request;
	
	public MaterialUpdateView() {}
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("La modifica e' andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Material", null);
		}
	}

	@Override
	public void showOptions() {
		System.out.println("Inserire l'ID del materiale da modificare:");
		idmaterial=Integer.parseInt(getInput().toString());
		System.out.println("Inserire la nuova tipologia:");
		tipo=getInput().toString();
		System.out.println("Inserire la nuova quantita':");
		quantita=Integer.parseInt(getInput().toString());
		System.out.println("Inserire il nuovo ID del dipendente");
		idHR=Integer.parseInt(getInput().toString());
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("idmaterial", idmaterial);
		request.put("tipo", tipo);
		request.put("quantita", quantita);
		request.put("idHR", idHR);
		request.put("mode", "UPDATE");
		MainDispatcher.getInstance().callAction("Material", "doControl", request);


	}

}