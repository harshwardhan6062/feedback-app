package com.example.feedbackbe.model.user;

import jakarta.annotation.Nullable;

public class PlaystoreUser extends PlatformUser {

    // We can define all the needed keys and attributes needed for calling the playstore service

    public PlaystoreUser(String platformId, String tenantId) {
        super(platformId, tenantId);
    }

    @Override
    public String toString() {
        return "PlaystoreUser{" +
                "platformId='" + platformId + '\'' +
                ", tenantId='" + tenantId + '\'' +
                '}';
    }
}
