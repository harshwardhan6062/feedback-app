package com.example.feedbackbe.service.tenant.info;

import com.example.feedbackbe.model.Tenant;
import com.example.feedbackbe.repository.TenantDAO;
import com.example.feedbackbe.repository.TenantDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantInfoServiceImpl implements TenantInfoService {

    public TenantDAO tenantDAO;

    @Autowired
    public TenantInfoServiceImpl(TenantDAO tenantDAO) {
        this.tenantDAO = tenantDAO;
    }

    public List<Tenant> getAllTenants() { return tenantDAO.getAllTenantsFromDB(); }

}
