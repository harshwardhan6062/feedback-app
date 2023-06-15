package com.example.feedbackbe.client.platform;

import com.example.feedbackbe.model.FeedbackSource;
import com.example.feedbackbe.model.user.PlatformUser;
import com.example.feedbackbe.service.platform.registration.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlatformUserClient {

    private final UserRegistrationService userRegistrationService;

    @Autowired
    public PlatformUserClient(UserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }


    public void createUser(FeedbackSource feedbackSource, String platformId, PlatformUser platformUser) {
        try {
            this.userRegistrationService.registerUser(platformId, platformUser, feedbackSource);
        } catch (Exception e) {
            System.out.println("Failed to register user for platorm");
        }
    }

    public void removeUser(FeedbackSource feedbackSource, String platformId) {
        try {
            this.userRegistrationService.removeUser(platformId, feedbackSource);
        } catch (Exception e) {
            System.out.println("Error while removing user for " + feedbackSource + " with platformId " + platformId);
        }
    }

}
