package it.contrader.view.material;

import it.contrader.controller.MaterialController;
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class MaterialInsertView extends AbstractView{
	
	private Request request;
	private String tipo;
	private int idmaterial;
	private int quantita;
	private int idHr;
	
	private  final String mode = "INSERT";
	
	public MaterialInsertView() {
		new MaterialController();
	}

	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("L'inserimento e' andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Material", null);
		}
	}
	
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id Material");
			idmaterial = Integer.parseInt(getInput());
			System.out.println("Inserisci il tipo di materiale");
			tipo= getInput();
			System.out.println("Inserisci la quantita");
			quantita= Integer.parseInt(getInput());
			System.out.println("Inserisci id HR");
			idHr= Integer.parseInt(getInput());
		} catch (Exception e) {

		}
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("idmaterial", idmaterial);
		request.put("tipo", tipo);
		request.put("quantita",quantita);
		request.put("idHR", idHr);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("material", "doControl", request);
	}

}
