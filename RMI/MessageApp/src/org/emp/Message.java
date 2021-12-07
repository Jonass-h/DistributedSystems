package org.emp;

public interface Message extends java.rmi.Remote {
    public String lireMessage()     throws java.rmi.RemoteException;
    public long add(long a, long b) throws java.rmi.RemoteException;
    public long sub(long a, long b) throws java.rmi.RemoteException;
    public long mul(long a, long b) throws java.rmi.RemoteException;
    public long div(long a, long b) throws java.rmi.RemoteException;
}
