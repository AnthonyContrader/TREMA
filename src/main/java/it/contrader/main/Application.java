package it.contrader.main;


public class Application {

    public static void main(String[] args) {
        MainDispatcher.getInstance().callAction("Login", "doControl", null);   
    }
}
