package it.contrader.view.material;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class MaterialInsertView extends AbstractView{
	
	private Request request;
	private String descrizione;
	private int idmaterial;
	
	private  final String mode = "INSERT";
	
	public MaterialInsertView() {}

	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("L'inserimento è andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Material", null);
		}
	}
	
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci il materiale");
			idmaterial = Integer.parseInt(getInput());
			System.out.println("Inserisci il tipo di materiale");
			descrizione= getInput();
		} catch (Exception e) {

		}
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("idmaterial", idmaterial);
		request.put("descrizione", descrizione);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Material", "doControl", request);
	}

}
