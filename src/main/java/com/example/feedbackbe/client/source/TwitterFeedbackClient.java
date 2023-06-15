package com.example.feedbackbe.client.source;

import com.example.feedbackbe.client.source.interfaces.HandleFeedbackClient;
import com.example.feedbackbe.model.FeedbackRecord;
import com.example.feedbackbe.model.feedback.Feedback;
import com.example.feedbackbe.service.feedback.handler.FeedbackHandler;
import com.example.feedbackbe.service.feedback.handler.TwitterFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TwitterFeedbackClient implements HandleFeedbackClient {

    private final FeedbackHandler feedbackService;

    @Autowired
    TwitterFeedbackClient(TwitterFeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @Override
    public FeedbackRecord handleReceivedFeedback(Feedback feedback) {
        feedbackService.processFeedback(feedback);
        return null;
    }
}
