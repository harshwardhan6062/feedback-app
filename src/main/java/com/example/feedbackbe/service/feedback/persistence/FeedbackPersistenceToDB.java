package com.example.feedbackbe.service.feedback.persistence;

import com.example.feedbackbe.model.feedback.FeedbackTypeRecord.FeedbackRecord;
import com.example.feedbackbe.repository.FeedbackDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackPersistenceToDB implements FeedbackPersistence {

    private final FeedbackDAO feedbackDAO;

    @Autowired
    public FeedbackPersistenceToDB(FeedbackDAO feedbackDB) {
        this.feedbackDAO = feedbackDB;
    }

    @Override
    public void saveFeedback(FeedbackRecord feedbackRecord) {
        feedbackDAO.addFeedback(feedbackRecord);
    }
}
