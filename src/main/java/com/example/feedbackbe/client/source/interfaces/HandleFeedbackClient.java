package com.example.feedbackbe.client.source.interfaces;

import com.example.feedbackbe.model.FeedbackRecord;
import com.example.feedbackbe.model.feedback.Feedback;

public interface HandleFeedbackClient {
    public FeedbackRecord handleReceivedFeedback(Feedback feedback);
}
