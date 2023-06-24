package com.example.feedbackbe.model.user;

public abstract class PlatformUser {
    String platformId;

    String tenantId;

    public PlatformUser(String platformId, String tenantId) {
        this.platformId = platformId;
        this.tenantId = tenantId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public String getPlatformId() {
        return platformId;
    }
}
