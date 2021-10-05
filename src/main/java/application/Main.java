package application;

import application.service.DBEngine;

public class Main {

    public static void main(String[] args) {
        DBEngine engine = new DBEngine();

        System.out.println(engine.isConnected());

        if(engine.isConnected()) {

            System.out.println();
        } else {
            System.out.println("no connection");
        }
    }
}
