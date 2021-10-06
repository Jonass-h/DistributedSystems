package org.emp;

public interface Message extends java.rmi.Remote {
    public String lireMessage() throws java.rmi.RemoteException;
}
