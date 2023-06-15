package com.example.feedbackbe.exceptions;

public class TenantDoesNotExist extends Exception {
    public TenantDoesNotExist(String message, String id) {
        super(message);
        System.out.println("Tenant with id " + id + " does not exist");
    }
}
