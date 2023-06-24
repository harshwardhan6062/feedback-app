package com.example.feedbackbe.model.feedback.FeedbackTypeRecord;

import com.example.feedbackbe.model.FeedbackSource;
import com.example.feedbackbe.model.FeedbackType;

public class ReviewFeedbackRecord extends FeedbackRecord {

    private String username;

    private String feedbackText;

    private int likes;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFeedbackText() {
        return feedbackText;
    }

    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public ReviewFeedbackRecord(String feedbackID, String tenantId, FeedbackType feedbackType, FeedbackSource feedbackSource, String username, String feedbackText, int likes) {
        super(feedbackID, tenantId, feedbackType, feedbackSource);
        this.username = username;
        this.feedbackText = feedbackText;
        this.likes = likes;
    }
}
