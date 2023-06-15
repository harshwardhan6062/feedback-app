package com.example.feedbackbe.repository;

import com.example.feedbackbe.model.Tenant;

import java.util.ArrayList;
import java.util.List;

public interface TenantDAO {

    public void addToDB(Tenant tenant);

    public void removeFromDB(String id);

    public List<Tenant> getAllTenantsFromDB();
}
