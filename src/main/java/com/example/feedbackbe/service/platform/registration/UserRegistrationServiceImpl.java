package com.example.feedbackbe.service.platform.registration;

import com.example.feedbackbe.exceptions.PlatformUserAlreadyExistsException;
import com.example.feedbackbe.exceptions.PlatformUserAndTenantSubscriptionException;
import com.example.feedbackbe.exceptions.PlatformUserDoesNotExistException;
import com.example.feedbackbe.exceptions.TenantDoesNotExist;
import com.example.feedbackbe.model.FeedbackSource;
import com.example.feedbackbe.model.Tenant;
import com.example.feedbackbe.model.user.PlatformUser;
import com.example.feedbackbe.repository.PlatformUserDAO;
import com.example.feedbackbe.service.platform.info.UserDataRetrievalService;
import com.example.feedbackbe.service.tenant.info.TenantInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

    private final TenantInfoService tenantInfo;

    private final UserDataRetrievalService userDataRetrievalService;

    private final PlatformUserDAO platformUserDAO;

    @Autowired
    public UserRegistrationServiceImpl(TenantInfoService tenantInfo, UserDataRetrievalService userDataRetrievalService, PlatformUserDAO platformUserDAO) {
        this.tenantInfo = tenantInfo;
        this.userDataRetrievalService = userDataRetrievalService;
        this.platformUserDAO = platformUserDAO;
    }

    public void checkIfTenantExist(String tenantId) throws TenantDoesNotExist {
        if(tenantId == null) throw new TenantDoesNotExist("Tenant passed is null", "-1");
        List<Tenant> allTenants = tenantInfo.getAllTenants();
        boolean tenantFound = false;
        for(Tenant tenant: allTenants) if(tenant.getTenantId() == tenantId) tenantFound = true;

        if(!tenantFound) throw new TenantDoesNotExist("No tenant found", tenantId);
    }

    public void checkIfPlatformUserExists(FeedbackSource feedbackSource, String platformId) throws PlatformUserDoesNotExistException, PlatformUserAndTenantSubscriptionException, PlatformUserAlreadyExistsException {
        Map<String, PlatformUser> platformUsers = userDataRetrievalService.getPlatformUsers(feedbackSource);
        if(platformUsers.get(platformId) != null) throw new PlatformUserAlreadyExistsException("Platform user already exist", platformId, feedbackSource);
    }

    @Override
    public void registerUser(String platformUserId, PlatformUser platformUser, FeedbackSource feedbackSource) throws Exception {
        try {
            checkIfTenantExist(platformUser.getTenantId());
            checkIfPlatformUserExists(feedbackSource, platformUserId);
            platformUserDAO.createUser(feedbackSource, platformUserId, platformUser);
        } catch (TenantDoesNotExist | PlatformUserAndTenantSubscriptionException | PlatformUserDoesNotExistException | PlatformUserAlreadyExistsException e) {
            throw new Exception("Failed to register user for " + feedbackSource);
        }
    }

    @Override
    public void removeUser(String platformUserId, FeedbackSource feedbackSource) throws Exception {
        try {
            checkIfPlatformUserExists(feedbackSource, platformUserId);
            platformUserDAO.removeUser(feedbackSource, platformUserId);
        } catch (PlatformUserAndTenantSubscriptionException | PlatformUserDoesNotExistException | PlatformUserAlreadyExistsException e) {
            throw new Exception("Failed to register user for " + feedbackSource);
        }
    }

}
