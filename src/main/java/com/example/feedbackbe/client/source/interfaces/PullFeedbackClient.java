package com.example.feedbackbe.client.source.interfaces;

import com.example.feedbackbe.model.feedback.Feedback;

public interface PullFeedbackClient {
    public Feedback pullAndHandleFeedback();
}
