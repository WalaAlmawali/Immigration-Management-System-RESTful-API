package com.example.Immigration.Management.System.RESTful.API.Exception;

public class OfficerAlreadyBookedException extends RuntimeException{
    public OfficerAlreadyBookedException(String message) {
        super(message);
    }
}
