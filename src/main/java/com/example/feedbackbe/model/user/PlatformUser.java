package com.example.feedbackbe.model.user;

public abstract class PlatformUser {
    String platformId;

    String tenantId;

    public String getTenantId() {
        return tenantId;
    }

    public String getPlatformId() {
        return platformId;
    }
}
