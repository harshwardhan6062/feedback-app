package com.example.feedbackbe.utils;

import com.example.feedbackbe.model.Tenant;
import com.example.feedbackbe.service.tenant.info.TenantInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

// These is just a helper file and can be ignored

@Component
public class TenantUtils {

    @Autowired
    TenantInfoServiceImpl tenantService;

    public void getAndPrintAllTenants() {
        System.out.println("\n\n");
        List<Tenant> allTenants = tenantService.getAllTenants();
        for (Tenant tenant : allTenants) {
            System.out.println(tenant.getTenantId() + " " + tenant.getName() + " " + tenant.getEmail());
        }
        System.out.println("\n\n");
    }

}
