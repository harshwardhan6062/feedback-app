package com.example.feedbackbe.model.user.FeedbackTypeRecord;

import com.example.feedbackbe.model.FeedbackSource;
import com.example.feedbackbe.model.FeedbackType;
import com.example.feedbackbe.model.feedback.metadata.FeedbackMetaData;

public class PostFeedbackRecord extends FeedbackRecord {

    private String postContent;

    private String imageURL;

    private int likes;

    private int shares;

    private String username;

    private String createdAt;
    private int reads;


    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getReads() {
        return reads;
    }

    public void setReads(int reads) {
        this.reads = reads;
    }

    public PostFeedbackRecord(String feedbackID, String tenantId, FeedbackType feedbackType, FeedbackSource feedbackSource, String postContent, String imageURL, int likes, int shares, String username, String createdAt, int reads) {
        super(feedbackID, tenantId, feedbackType, feedbackSource);
        this.postContent = postContent;
        this.imageURL = imageURL;
        this.likes = likes;
        this.shares = shares;
        this.username = username;
        this.createdAt = createdAt;
        this.reads = reads;
    }

}
