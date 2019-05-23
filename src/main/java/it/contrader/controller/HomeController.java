package it.contrader.controller;

import it.contrader.main.MainDispatcher;
import it.contrader.service.LoginService;

public class HomeController implements Controller {

    public HomeController() {
        new LoginService();
    }

    public void doControl(Request request) {
        if (request != null) {
            String nomeUtente = request.get("nomeUtente").toString();
            String password = request.get("password").toString();
            
            //Change view according userType
           
        }
        else MainDispatcher.getInstance().callView("Login", null);

    }
}
