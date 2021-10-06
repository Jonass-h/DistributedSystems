package org.emp;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientLocale {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost");
            Message stub = (Message) registry.lookup("Message");
            String response = stub.lireMessage();
            System.out.println("response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
