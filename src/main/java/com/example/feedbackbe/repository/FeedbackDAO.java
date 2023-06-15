package com.example.feedbackbe.repository;

import com.example.feedbackbe.model.FeedbackRecord;
import com.example.feedbackbe.model.FeedbackSource;
import com.example.feedbackbe.model.FeedbackType;

import java.util.List;

public interface FeedbackDAO {

    public void addFeedback(FeedbackRecord feedbackRecord);

    public FeedbackRecord getFeedbackById(String id);

    public List<FeedbackRecord> getFeedbackByTenant(String tenantId);

    public List<FeedbackRecord> getFeedbackBySource(FeedbackSource feedbackSource);

    public List<FeedbackRecord> getFeedbackRecordByType(FeedbackType feedbackType);

}
