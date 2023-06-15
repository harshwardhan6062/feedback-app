package com.example.feedbackbe.repository;

import com.example.feedbackbe.model.Tenant;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TenantDAOImpl implements TenantDAO {
    private List<Tenant> tenants;

    public TenantDAOImpl() {
        tenants = new ArrayList<>();
    }

    public void addToDB(Tenant tenant) {
        tenants.add(tenant);
    }

    public void removeFromDB(String id) {
        tenants = tenants.stream().filter(tenant -> tenant.getTenantId().equals(id) == false).toList();
    }

    public List<Tenant> getAllTenantsFromDB() {
        return this.tenants;
    }

}
