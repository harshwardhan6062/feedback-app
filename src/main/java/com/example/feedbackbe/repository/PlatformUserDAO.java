package com.example.feedbackbe.repository;

import com.example.feedbackbe.model.FeedbackSource;
import com.example.feedbackbe.model.user.PlatformUser;

import java.util.Map;

public interface PlatformUserDAO {
    public void createUser(FeedbackSource feedbackSource, String platformId, PlatformUser platformUser);

    public void removeUser(FeedbackSource feedbackSource, String platformId);

    public String getTenantId(FeedbackSource feedbackSource, String platformId);

    public Map<String, PlatformUser> getPlatformUsers(FeedbackSource feedbackSource);
}
