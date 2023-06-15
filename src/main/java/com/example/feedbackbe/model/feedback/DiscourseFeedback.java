package com.example.feedbackbe.model.feedback;


import lombok.Builder;

@Builder
public class DiscourseFeedback extends Feedback {
    private String id;
    private String userID;
    private String name;
    private String username;
    private String avatar_template;
    private String createdAt;
    private String cooked;
    private int reads;
    private int readers_count;
    private double score;

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
