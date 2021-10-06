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

    public String lireMessage(){
        return this.getMessage();
    }
}
