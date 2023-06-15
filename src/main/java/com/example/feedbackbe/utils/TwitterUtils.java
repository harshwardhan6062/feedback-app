package com.example.feedbackbe.utils;

import com.example.feedbackbe.model.FeedbackType;
import com.example.feedbackbe.model.feedback.Feedback;
import com.example.feedbackbe.model.feedback.TwitterFeedback;

import java.util.Date;
import java.util.UUID;

public class TwitterUtils {

    public Feedback generateFeedback() {
        return new TwitterFeedback("en", "ha_w_k", new Date().toString(), UUID.randomUUID().toString(),"Twitter is a cool platform @Elon Must", "", 3, 3);
    }

}
