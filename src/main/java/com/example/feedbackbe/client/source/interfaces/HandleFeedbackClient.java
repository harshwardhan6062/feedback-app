package com.example.feedbackbe.client.source.interfaces;

import com.example.feedbackbe.model.feedback.Feedback;

public interface HandleFeedbackClient {
    public void handleReceivedFeedback(Feedback feedback);
}
