package com.example.feedbackbe.model.feedback;

import lombok.Builder;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Builder
public class PlaystoreFeedback extends Feedback {

    private String id;

    private String username;

    private String createdAt;

    @Min(0)
    @Max(5)
    private int rating;

    private String feedbackText;

    private String appId;

    public String getCreatedAt() {
        return createdAt;
    }

    public String getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public String getFeedbackText() {
        return feedbackText;
    }

    public String getAppId() {
        return appId;
    }

    public double getAppVersion() {
        return appVersion;
    }

    private double appVersion;

    public String getUsername() {
        return this.username;
    }

}
