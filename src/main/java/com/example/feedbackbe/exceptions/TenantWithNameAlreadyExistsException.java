package com.example.feedbackbe.exceptions;

public class TenantWithNameAlreadyExistsException extends  Exception{
    public TenantWithNameAlreadyExistsException(String message, String name) {
        super(message);
        System.out.println("Tenant with name " + name + " already exists!");
    }
}
