package com.example.feedbackbe.service.tenant.registration;

import com.example.feedbackbe.exceptions.TenantDoesNotExist;
import com.example.feedbackbe.exceptions.TenantWithEmailAlreadyExistsException;
import com.example.feedbackbe.exceptions.TenantWithNameAlreadyExistsException;
import com.example.feedbackbe.model.Tenant;
import com.example.feedbackbe.repository.TenantDAO;
import com.example.feedbackbe.repository.TenantDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TenantRegistrationServiceImpl implements TenantRegistrationService {

    public TenantDAO tenantDAO;

    @Autowired
    public TenantRegistrationServiceImpl(TenantDAO tenantDAO) {
        this.tenantDAO = tenantDAO;
    }

    @Override
    public void addTenant(String name, String email) throws TenantWithNameAlreadyExistsException, TenantWithEmailAlreadyExistsException {
        List<Tenant> allTenants = tenantDAO.getAllTenantsFromDB();
        for(Tenant tenant: allTenants) if(tenant.getName() == name) {
            throw new TenantWithNameAlreadyExistsException("Tenant with name already exists", name);
        } else if(tenant.getEmail() == email) {
            throw new TenantWithEmailAlreadyExistsException("Tenant with email already exists", email);
        }
        tenantDAO.addToDB(new Tenant(UUID.randomUUID().toString(), name, email));
    }

    @Override
    public void removeTenant(String id) throws TenantDoesNotExist {
        List<Tenant> allTenants = tenantDAO.getAllTenantsFromDB();
        boolean tenantExists = false;
        for(Tenant tenant: allTenants) if(tenant.getTenantId() == id) tenantExists = true;
        if(tenantExists) tenantDAO.removeFromDB(id);
        else {
            throw new TenantDoesNotExist("No tenant found", id);
        }
    }
}
