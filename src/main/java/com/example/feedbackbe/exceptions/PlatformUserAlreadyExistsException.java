package com.example.feedbackbe.exceptions;

import com.example.feedbackbe.model.FeedbackSource;

public class PlatformUserAlreadyExistsException extends Exception {
    public PlatformUserAlreadyExistsException(String message, String platformId, FeedbackSource feedbackSource) {
        super(message);
        System.out.println("User already exists for id " + platformId + " and feedback source " + feedbackSource );
    }
}
