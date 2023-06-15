package com.example.feedbackbe.exceptions;

import com.example.feedbackbe.model.FeedbackSource;

public class PlatformUserDoesNotExistException extends Exception {
    public PlatformUserDoesNotExistException(String message, String platformId, FeedbackSource feedbackSource) {
        super(message);
        System.out.println("User with platformId " + platformId + " does not exists on " + feedbackSource);
    }
}
