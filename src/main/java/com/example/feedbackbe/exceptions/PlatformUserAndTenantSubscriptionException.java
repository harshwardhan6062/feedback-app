package com.example.feedbackbe.exceptions;

import com.example.feedbackbe.model.FeedbackSource;

public class PlatformUserAndTenantSubscriptionException extends Exception {
    public PlatformUserAndTenantSubscriptionException(String message, String tenantId, FeedbackSource feedbackSource) {
        super(message);
        System.out.println("Tenant " + tenantId + " is not subscribed to " + feedbackSource);
    }
}
