package com.example.feedbackbe.service.platform.registration;

import com.example.feedbackbe.model.FeedbackSource;
import com.example.feedbackbe.model.user.PlatformUser;

public interface UserRegistrationService {

    public void removeUser(String platformUserId, FeedbackSource feedbackSource) throws Exception;

    public void registerUser(String platformUserId, PlatformUser platformUser, FeedbackSource feedbackSource) throws Exception;

}
