package com.example.feedbackbe.service.feedback.persistence;

import com.example.feedbackbe.model.FeedbackRecord;

public interface FeedbackPersistence {
    public void saveFeedback(FeedbackRecord feedbackRecord);
}
