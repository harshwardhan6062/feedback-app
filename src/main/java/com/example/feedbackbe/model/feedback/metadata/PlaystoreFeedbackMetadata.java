package com.example.feedbackbe.model.feedback.metadata;

import com.example.feedbackbe.model.feedback.DiscourseFeedback;

public class PlaystoreFeedbackMetadata extends  FeedbackMetaData {

    private int rating;

    private String username;

    private String feedbackText;

    private String appId;

    private double appVersion;

    public PlaystoreFeedbackMetadata(int rating,
                                     String feedbackText,
                                     String appId,
                                     double appVersion,
                                     String username) {
        this.rating = rating;
        this.feedbackText = feedbackText;
        this.appId = appId;
        this.appVersion = appVersion;
        this.username = username;
    }
}
