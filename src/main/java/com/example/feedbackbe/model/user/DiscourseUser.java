package com.example.feedbackbe.model.user;

public class DiscourseUser extends PlatformUser {

    // We can define all the needed keys and attributes needed for calling the Discourse service
    public DiscourseUser(String platformId, String tenantId) {
        super(platformId, tenantId);
    }

    @Override
    public String toString() {
        return "DiscourseUser{" +
                "platformId='" + platformId + '\'' +
                ", tenantId='" + tenantId + '\'' +
                '}';
    }
}
