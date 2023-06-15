package com.example.feedbackbe.service.tenant.registration;

import com.example.feedbackbe.exceptions.TenantDoesNotExist;
import com.example.feedbackbe.exceptions.TenantWithEmailAlreadyExistsException;
import com.example.feedbackbe.exceptions.TenantWithNameAlreadyExistsException;

public interface TenantRegistrationService {

    public void addTenant(String name, String email) throws TenantWithNameAlreadyExistsException, TenantWithEmailAlreadyExistsException;

    public void removeTenant(String id) throws TenantDoesNotExist;

}
