package com.example.helloworld.exception;

public class AgeIllegalRuntimeException extends RuntimeException{
    public AgeIllegalRuntimeException(){

    }

    public AgeIllegalRuntimeException(String message){
        super(message);
    }
}
