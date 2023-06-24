package com.example.feedbackbe.service.feedback.persistence;

import com.example.feedbackbe.model.feedback.FeedbackTypeRecord.FeedbackRecord;

public interface FeedbackPersistence {
    public void saveFeedback(FeedbackRecord feedbackRecord);
}
