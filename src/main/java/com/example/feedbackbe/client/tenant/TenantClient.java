package com.example.feedbackbe.client.tenant;

import com.example.feedbackbe.model.Tenant;
import com.example.feedbackbe.service.tenant.info.TenantInfoService;
import com.example.feedbackbe.service.tenant.registration.TenantRegistrationService;
import com.example.feedbackbe.service.tenant.registration.TenantRegistrationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TenantClient {

    private final TenantRegistrationService tenantRegistrationService;
    private final TenantInfoService tenantDataRetrievalService;

    @Autowired
    public TenantClient(TenantRegistrationService tenantRegistrationService, TenantInfoService tenantInfoService) {
        this.tenantRegistrationService = tenantRegistrationService;
        this.tenantDataRetrievalService = tenantInfoService;
    }

    public void addTenant(String name, String email) {
        try {
            tenantRegistrationService.addTenant(name, email);
        } catch (Exception e) {
            System.out.println("Cannot create Tenant with email" + email + " and name " + name);
        }
    }

    public void removeTenant(String id) {
        try {
            tenantRegistrationService.removeTenant(id);
        } catch (Exception e) {
            System.out.println("No tenant with id exists");
        }
    }

    public void printAllTenants() {
        List<Tenant> tenants = tenantDataRetrievalService.getAllTenants();
        for(Tenant tenant: tenants) {
            System.out.println(tenant.toString());
        }
    }

}
