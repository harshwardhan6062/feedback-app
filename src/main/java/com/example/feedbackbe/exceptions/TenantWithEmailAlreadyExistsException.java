package com.example.feedbackbe.exceptions;

public class TenantWithEmailAlreadyExistsException extends  Exception{
    public TenantWithEmailAlreadyExistsException(String message, String email) {
        super(message);
        System.out.println("Tenant with email " + email + " already exists!");
    }
}
