package com.example.feedbackbe.model.feedback.FeedbackTypeRecord;

import com.example.feedbackbe.model.FeedbackSource;
import com.example.feedbackbe.model.FeedbackType;
import com.example.feedbackbe.model.feedback.DiscourseFeedback;

public class FeedbackRecord {

    private String feedbackID;
    private String tenantId;
    private FeedbackType feedbackType;
    private FeedbackSource feedbackSource;


    public FeedbackRecord(String feedbackID, String tenantId, FeedbackType feedbackType, FeedbackSource feedbackSource) {
        this.feedbackID = feedbackID;
        this.tenantId = tenantId;
        this.feedbackType = feedbackType;
        this.feedbackSource = feedbackSource;
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
