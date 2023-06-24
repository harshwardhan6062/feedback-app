package com.example.feedbackbe.model.feedback;

import lombok.Builder;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class PlaystoreFeedback extends Feedback {

    private String id;

    private String username;

    private String createdAt;

    private String feedbackText;

    @Min(0)
    @Max(5)
    private int rating;

    private int likes;


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


    public double getAppVersion() {
        return appVersion;
    }

    private double appVersion;

    public int getLikes() {
        return this.likes;
    }

    public String getUsername() {
        return this.username;
    }

}
