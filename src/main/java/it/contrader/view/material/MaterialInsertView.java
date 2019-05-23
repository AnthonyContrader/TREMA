package it.contrader.view.material;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class MaterialInsertView extends AbstractView{
	
	private Request request;
	private String nome;
	private String model;
	private String category;
	private int inventory;
	private int idMaterial;
	
	private  final String mode = "INSERT";
	
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
			System.out.println("Inserisci il materiale:");
			nome= getInput();
			System.out.println("Inserisci il modello:");
			model= getInput();
			System.out.println("Inserisci la categoria:");
			category= getInput();
			System.out.println("Inserisci il numero di inventario:");
			inventory= Integer.parseInt(getInput());
			System.out.println("Inserisci id materiale:");
			idMaterial= Integer.parseInt(getInput());
		} catch (Exception e) {
				System.out.println("Insert error!!");
		}
		
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("Name", nome);
		request.put("Model", model);
		request.put("Category", category);
		request.put("Inventory", inventory);
		request.put("idMaterial", idMaterial);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Material", "doControl", request);
		
	}

}
