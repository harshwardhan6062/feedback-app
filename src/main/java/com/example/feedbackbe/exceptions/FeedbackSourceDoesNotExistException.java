package com.example.feedbackbe.exceptions;

import com.example.feedbackbe.model.FeedbackSource;

public class FeedbackSourceDoesNotExistException extends Exception {

    public FeedbackSourceDoesNotExistException(String message, FeedbackSource feedbackSource) {
        super(message);
        System.out.println("Feedback source " + feedbackSource + " does not exist!");
    }

}
