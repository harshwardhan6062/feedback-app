package com.example.feedbackbe.service.feedback.persistence;

import com.example.feedbackbe.model.user.FeedbackTypeRecord.FeedbackRecord;

public interface FeedbackPersistence {
    public void saveFeedback(FeedbackRecord feedbackRecord);
}
