package com.example.feedbackbe.client.platform;

import com.example.feedbackbe.model.FeedbackSource;
import com.example.feedbackbe.model.user.PlatformUser;
import com.example.feedbackbe.service.platform.factory.PlatformUserFactory;
import com.example.feedbackbe.service.platform.info.UserDataRetrievalService;
import com.example.feedbackbe.service.platform.registration.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PlatformUserClient {

    private final UserRegistrationService userRegistrationService;
    private final UserDataRetrievalService userDataRetrievalService;
    private final PlatformUserFactory platformUserFactory;

    @Autowired
    public PlatformUserClient(UserRegistrationService userRegistrationService, UserDataRetrievalService userDataRetrievalService, PlatformUserFactory platformUserFactory) {
        this.userRegistrationService = userRegistrationService;
        this.userDataRetrievalService = userDataRetrievalService;
        this.platformUserFactory = platformUserFactory;
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

    public void printAllUsersForPlatform(FeedbackSource feedbackSource) {
        Map<String, PlatformUser> users = this.userDataRetrievalService.getPlatformUsers(feedbackSource);
        for(Map.Entry<String, PlatformUser> user: users.entrySet()) {
            PlatformUser userDetails = user.getValue();
            platformUserFactory.convertToSpecificUser(userDetails).toString();
        }
    }

}
