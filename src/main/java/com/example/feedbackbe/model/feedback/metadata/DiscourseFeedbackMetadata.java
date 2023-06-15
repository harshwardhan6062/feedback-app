package com.example.feedbackbe.model.feedback.metadata;

import com.example.feedbackbe.model.feedback.DiscourseFeedback;
import com.example.feedbackbe.model.feedback.Feedback;

public class DiscourseFeedbackMetadata extends FeedbackMetaData {

    private String name;
    private String username;
    private String avatar_template;
    private String createdAt;
    private String cooked;
    private int reads;
    private int readers_count;
    private double score;
    public DiscourseFeedbackMetadata(String name,
                                     String username,
                                     String avatar_template,
                                     String createdAt,
                                     String cooked,
                                     int reads,
                                     int readers_count,
                                     double score) {
        this.name = name;
        this.username = username;
        this.avatar_template = avatar_template;
        this.createdAt = createdAt;
        this.cooked = cooked;
        this.reads = reads;
        this.readers_count = readers_count;
        this.score = score;
    }
}
