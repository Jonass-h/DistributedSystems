package org.emp;

public class MessageImpl implements Message {
    private String message;
    public MessageImpl(String message) {
        this.message=message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
    /*
      custom methods
     */
    public String lireMessage(){
        return this.getMessage();
    }
    public long add(long a, long b) {

        return a+b;
    }
    public long sub(long a, long b) {
        return a-b;
    }
    public long mul(long a, long b) {
        return a*b;
    }
    public long div(long a, long b) {
        return a/b;
    }
}
