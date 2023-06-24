package com.example.feedbackbe.model.user;

public class TwitterUser extends PlatformUser{

    // We can define all the needed keys and attributes needed for calling the Twitter service

    public TwitterUser(String platformId, String tenantId) {
        super(platformId, tenantId);
    }

    @Override
    public String toString() {
        return "TwitterUser{" +
                "platformId='" + platformId + '\'' +
                ", tenantId='" + tenantId + '\'' +
                '}';
    }
}
