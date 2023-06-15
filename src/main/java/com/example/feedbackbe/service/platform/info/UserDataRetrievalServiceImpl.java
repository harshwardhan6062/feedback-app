package com.example.feedbackbe.service.platform.info;

import com.example.feedbackbe.model.FeedbackSource;
import com.example.feedbackbe.model.user.PlatformUser;
import com.example.feedbackbe.repository.PlatformUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserDataRetrievalServiceImpl implements UserDataRetrievalService {

    private final PlatformUserDAO platformUserDAO;

    @Autowired
    public UserDataRetrievalServiceImpl(PlatformUserDAO platformUserDAO) {
        this.platformUserDAO = platformUserDAO;
    }

    @Override
    public String getTenantId(FeedbackSource feedbackSource, String id) {
        return platformUserDAO.getTenantId(feedbackSource, id);
    }

    @Override
    public Map<String, PlatformUser> getPlatformUsers(FeedbackSource feedbackSource) {
        return platformUserDAO.getPlatformUsers(feedbackSource);
    }


}
