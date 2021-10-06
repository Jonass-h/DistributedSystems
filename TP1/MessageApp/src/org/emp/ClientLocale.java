package org.emp;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientLocale {
    public static void main(String[] args) {
        try {

            Registry registry = LocateRegistry.getRegistry("localhost");
            Message stub = (Message) registry.lookup("ServeurCalcul");
            long addition = stub.add(5,8);
            System.out.println("response: " + addition);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
