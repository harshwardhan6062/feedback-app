package com.example.feedbackbe.model.feedback.metadata;

import com.example.feedbackbe.model.feedback.DiscourseFeedback;

public class TwitterFeedbackMetadata extends FeedbackMetaData {

    private String country;
    private String post;

    private String imageURL;

    private int likes;

    private int shares;

    public String getCountry() {
        return country;
    }

    public String getPost() {
        return post;
    }

    public String getImageURL() {
        return imageURL;
    }

    public int getLikes() {
        return likes;
    }

    public int getShares() {
        return shares;
    }

    public TwitterFeedbackMetadata(String country,
                                   String post,
                                   String imageURL,
                                   int likes,
                                   int shares) {

        this.country = country;
        this.post = post;
        this.imageURL = imageURL;
        this.likes = likes;
        this.shares = shares;
    }

}
