package com.devkuma.spring01demo;

/**
 * SampleBean
 */
public class SampleBean implements SampleBeanInterface{

    private String message;
    
    public SampleBean(){
        message = "(no message)";
    }

    public SampleBean(String message){
        this.message = message;
    }

    @Override
    public String toString() {
        return "SampleBean [message=" + message + "]";
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }
}