package com.example.feedbackbe.model.feedback;


import lombok.Builder;

import java.util.Date;

public class DiscourseFeedback extends Feedback {
    private String id;
    private String userID;
    private String name;
    private String username;

    private int likes;

    private int shares;

    private String createdAt;

    private String imageURL;

    public void setUsername(String username) {
        this.username = username;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getImageURL() {
        return imageURL;
    }

    private String content;
    private String avatar_template;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String cooked;
    private int reads;
    private int readers_count;
    private double score;


    public int getShares() {
        return shares;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getAvatar_template() {
        return avatar_template;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getCooked() {
        return cooked;
    }

    public int getReads() {
        return reads;
    }

    public int getReaders_count() {
        return readers_count;
    }

    public double getScore() {
        return score;
    }

    public String getName() {
        return this.name;
    }

    public String getUserID() {
        return this.userID;
    }

}
