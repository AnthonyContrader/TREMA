package it.contrader.view.material;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class MaterialDeleteView extends AbstractView{
	
	int idMaterial;
	private final String mode="DELETE";
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("La cancellazione e' andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Material", null);
		}
		
	}

	@Override
	public void showOptions() {
		System.out.print("Inserire l'ID del materiale da eliminare:\n");
		idMaterial=Integer.parseInt(getInput());
		
	}

	@Override
	public void submit() {
		Request request = new Request();
		request.put("mode", mode); //forse drop
		request.put("idMaterial", idMaterial);
		MainDispatcher.getInstance().callAction("Material", "doControl", request);
		
	} //da creare nella cartella 

}
