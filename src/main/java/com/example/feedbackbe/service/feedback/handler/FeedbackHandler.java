package com.example.feedbackbe.service.feedback.handler;

import com.example.feedbackbe.model.FeedbackRecord;
import com.example.feedbackbe.model.feedback.Feedback;

public interface FeedbackHandler {

    public FeedbackRecord processFeedback(Feedback feedback);

}
