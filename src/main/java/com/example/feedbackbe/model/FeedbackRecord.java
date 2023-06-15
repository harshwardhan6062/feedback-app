package com.example.feedbackbe.model;

import com.example.feedbackbe.model.feedback.DiscourseFeedback;
import com.example.feedbackbe.model.feedback.metadata.FeedbackMetaData;

public class FeedbackRecord {

    private String feedbackID;
    private String tenantId;
    private FeedbackType feedbackType;
    private FeedbackSource feedbackSource;

    private FeedbackMetaData metadata;

    public FeedbackRecord(String feedbackID, String tenantId, FeedbackType feedbackType, FeedbackSource feedbackSource, FeedbackMetaData metadata) {
        this.feedbackID = feedbackID;
        this.tenantId = tenantId;
        this.feedbackType = feedbackType;
        this.feedbackSource = feedbackSource;
        this.metadata = metadata;
    }

    public String getFeedbackID() {
        return this.feedbackID;
    }

    public String getTenantId() {
        return this.tenantId;
    }

    public FeedbackSource getFeedbackSource() {
        return this.feedbackSource;
    }

    public FeedbackType getFeedbackType() {
        return this.feedbackType;
    }

}
