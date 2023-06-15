package com.example.feedbackbe.model.feedback;

import com.example.feedbackbe.model.FeedbackSource;
import com.example.feedbackbe.model.FeedbackType;
import lombok.Builder;

public class TwitterFeedback extends Feedback {

    private String id;

    private String username;

    private String createdAt;
    private String country;
    private String post;
    private String imageURL;
    private int likes;
    private int shares;

    public TwitterFeedback(String country,
                           String username,
                           String createdAt,
                           String id,
                           String post,
                           String imageURL,
                           int likes,
                           int shares) {

        this.country = country;
        this.post = post;
        this.imageURL = imageURL;
        this.likes = likes;
        this.shares = shares;
        this.id = id;
        this.username = username;
        this.createdAt = createdAt;
    }

    public String getUsername() {
        return this.username;
    }

    public String getId() {
        return this.id;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public String getCountry() {
        return this.country;
    }

    public String getPost() {
        return this.post;
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public int getLikes() {
        return this.likes;
    }

    public int getShares() {
        return this.shares;
    }

}
