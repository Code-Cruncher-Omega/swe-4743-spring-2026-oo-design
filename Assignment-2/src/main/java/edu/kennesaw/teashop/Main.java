package edu.kennesaw.teashop;

import edu.kennesaw.teashop.userinterface.Application;

public class Main {
    public static void main(String[] args) {
        Application app = new Application(System.in, System.out);
        app.run();
    }
}